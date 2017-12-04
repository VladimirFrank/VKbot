package ru.frank.messageHandler;

import ru.frank.model.VkJsonMessage;

public class MessageAnalyzer {

    private VkJsonMessage message;

    public MessageAnalyzer(VkJsonMessage incomingMessage){
        this.message = incomingMessage;
    }

    private String getKeyWords(VkJsonMessage message){
        String userMessage = message.getVkMessage().getBody().toLowerCase();
        if(userMessage.contains("как")){
            if(userMessage.contains("дела")){
                return "как дела?";
            }
        } else if(userMessage.contains("привет")){
            return "привет";
        }

        return "неизвестен смысл сообщения";
    }

    public String getBotAnswer(VkJsonMessage keyWord){
        String userMessage = getKeyWords(keyWord);
        if(userMessage.equals("как дела?")){
            return "я в порядке, а ты?";
        } else if(userMessage.equals("привет")){
            return "Здорово, пьес!";
        } else{
            return "Ничего не понятно! Бэ мэ!";
        }
    }

    public VkJsonMessage getMessage() {
        return message;
    }

    public void setMessage(VkJsonMessage message) {
        this.message = message;
    }
}
