package ru.frank.model;

public class VkJsonMessage {

    private String type;
    private VkMessage vkMessage;
    private int groupId;
    private String secret;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public VkMessage getVkMessage() {
        return vkMessage;
    }

    public void setVkMessage(VkMessage vkMessage) {
        this.vkMessage = vkMessage;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {

        if(vkMessage != null){
            return "VkJsonMessage{" +
                    "type='" + type + '\'' +
                    ", vkMessage=" + vkMessage.toString() +
                    ", groupId=" + groupId +
                    ", secret='" + secret + '\'' +
                    '}';
        } else{
            return "VkJsonMessage{" +
                    "type='" + type + '\'' +
                    ", vkMessage=" + "null" +
                    ", groupId=" + groupId +
                    ", secret='" + secret + '\'' +
                    '}';
        }

    }
}
