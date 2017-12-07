package ru.frank.messageHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageAnalyzer {

    public MessageAnalyzer(){}

    /**
     *   Коллекция для хранение ответов бота по ключу.
     */
    private static Map<String, String> botAnswersList = new HashMap<>();

    static{
        botAnswersList.put("help", "Бот умеет находить для тебя крутую музыку.%0A" +
                "%0AСписок команд:%0AПривет%0AКак дела?%0AСкинь трек");
        botAnswersList.put("привет", "Привет, человек!");
        botAnswersList.put("как дела?", "ЗАМЕЧАТЕЛЬНО! Хочешь крутую песню, напиши 'скинь трек'");
    }

    /**
     *   Коллекция id music videos
     */
    private static List<String> musicVideoIdList = new ArrayList<>();

    static{
        musicVideoIdList.add("456239092");
        musicVideoIdList.add("456239093");
        musicVideoIdList.add("456239094");
        musicVideoIdList.add("456239095");
        musicVideoIdList.add("456239096");
        musicVideoIdList.add("456239097");
        musicVideoIdList.add("456239098");
        musicVideoIdList.add("456239099");
        musicVideoIdList.add("456239100");
        musicVideoIdList.add("456239101");
        musicVideoIdList.add("456239102");
        musicVideoIdList.add("456239103");
        musicVideoIdList.add("456239104");
        musicVideoIdList.add("456239105");


    }



    public String getBotAnswer(String message){
        message = message.toLowerCase();
        String answer = "Я тебя не понимаю, человек. Если нужен список команд, напиши 'help'";
        if(message.contains("help")){
            answer = botAnswersList.get("help");
        }
        if(message.contains("как")){
            if(message.contains("дела")){
                answer = botAnswersList.get("как дела?");
            }
        } else if(message.contains("привет")){
            answer = botAnswersList.get("привет");
        } else if(message.contains("трек")){
            answer = "Вот твой крутой трек!&attachment=video172635477_" + getRandomMusicVideo();
        }
        answer = answer.replace(" ", "+");
        return answer;
    }


    /**
     * Генерирует случайное число в пределах от 0 до размера массива (хранящего id music videos).
     * @return String;
     */
    private String getRandomMusicVideo(){
        int videoIndex = (int) (Math.random() * musicVideoIdList.size());
        return musicVideoIdList.get(videoIndex);
    }
}
