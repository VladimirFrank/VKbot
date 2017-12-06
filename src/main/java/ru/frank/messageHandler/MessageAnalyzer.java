package ru.frank.messageHandler;

public class MessageAnalyzer {

    public MessageAnalyzer(){}

    public String getBotAnswer(String message){
        String answer = "неизвестен смысл сообщения";
        if(message.contains("как")){
            if(message.contains("дела")){
                answer = "у меня норм, а у тебя?";
            }
        } else if(message.contains("привет")){
            answer = "привет пёс!";
        }
        answer = answer.replace(" ", "+");
        return answer;
    }


}
