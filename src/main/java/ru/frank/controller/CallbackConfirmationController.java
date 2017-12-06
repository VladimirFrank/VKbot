package ru.frank.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ru.frank.messageHandler.MessageAnalyzer;
import ru.frank.messageHandler.VkMessageParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

@Controller
public class CallbackConfirmationController {

    HttpClient client;
    HttpPost httpPost;
    HttpGet httpGet;


    private String token = "3049fb79a066090c606810d8075e43fade0f7ebf06cce817cb428e9d684f94019aca20552b2ede3805ba5";

    private VkMessageParser messageParser;
    private MessageAnalyzer analyzer;

    private final Random random = new Random();

    private String vkApiMethod = "https://api.vk.com/method/messages.send?access_token=" + token
                            + "&v=5.69";

    @RequestMapping(value = "/callbackConfirmation", method = RequestMethod.POST, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String doChatBotResponse(@RequestBody String incomingMessage){

        if(incomingMessage != null){
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(incomingMessage);
            System.out.println(jsonElement.toString());
            messageParser = new VkMessageParser(incomingMessage);
            String userId = messageParser.getUserId();
            analyzer = new MessageAnalyzer();


            String botAnswer = vkApiMethod + buildVkApiResponse(userId, analyzer.getBotAnswer(messageParser.getMessage()));

            try {

                client = HttpClientBuilder.create().build();
                httpGet = new HttpGet(botAnswer);
                httpGet.addHeader("accept", "application/x-www-form-urlencoded");


                HttpResponse response = client.execute(httpGet);

                BufferedReader br = new BufferedReader(
                        new InputStreamReader((response.getEntity().getContent())));

                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "ok";
    }

    private String buildVkApiResponse(String userId, String message){
        return (vkApiMethod + "&user_id=" + userId + "&message=" + message + "&random_id=" + random.nextInt());
    }
}
