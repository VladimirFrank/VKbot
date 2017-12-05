package ru.frank.messageHandler;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *  Класс парсит json поступивший со стороны клиента.
 *  Структура входящего запроса:
 * {
        "type":"message_new",
        "object":{
            "id":694,
            "date":1499441696,
            "out":0,
            "user_id":123456,
            "read_state":0,
            "title":" ... ",
            "body":"start"
        },
        "group_id":1,
        "secret":"sjr948dff3kjnfd3"
        }
 */
public class VkMessageParser {

    private JsonParser parser;
    private JsonElement jsonElement;
    private JsonObject rootJsonObject;
    private JsonObject childJsonObject;

    private String message;
    private String userId;

    public VkMessageParser(String incomingJson){
        parser = new JsonParser();
        jsonElement = parser.parse(incomingJson);
        rootJsonObject = jsonElement.getAsJsonObject();
        childJsonObject = rootJsonObject.getAsJsonObject("object");
        this.message = childJsonObject.get("body").getAsString();
        this.userId = childJsonObject.get("user_id").getAsString();
    }




    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
