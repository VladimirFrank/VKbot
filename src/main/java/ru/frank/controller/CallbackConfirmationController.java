package ru.frank.controller;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ru.frank.model.VkJsonMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class CallbackConfirmationController {

    TransportClient transportClient = HttpTransportClient.getInstance();
    VkApiClient vkApiClient = new VkApiClient(transportClient);
    private String token = "3049fb79a066090c606810d8075e43fade0f7ebf06cce817cb428e9d684f94019aca20552b2ede3805ba5";

    private HttpClient httpClient;
    private HttpPost httpPost;
    private HttpGet httpGet;

    String vkApiMethod = "https://api.vk.com/method/messages.send?user_id=172635477&message=Hello!&access_token=" + token
                            + "&v=5.69";

    @RequestMapping(value = "/callbackConfirmation", method = RequestMethod.POST, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody void doChatBotResponse(@RequestBody VkJsonMessage incomingMessage){

        String line = "";

        if(incomingMessage != null){
            System.out.println(incomingMessage.toString());
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(vkApiMethod);
            HttpResponse response;
            try {
                response = client.execute(request);
                System.out.println("Response Code : "
                        + response.getStatusLine().getStatusCode());
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }
}
