
import org.junit.Test;
import ru.frank.messageHandler.VkMessageParser;
import static org.junit.Assert.*;


public class VkMessageParserTest {

    private String testJsonIncomingMessage = "{ \n" +
            "   \"type\":\"message_new\", \n" +
            "   \"object\":{ \n" +
            "      \"id\":694, \n" +
            "      \"date\":1499441696, \n" +
            "      \"out\":0, \n" +
            "      \"user_id\":123456, \n" +
            "      \"read_state\":0, \n" +
            "      \"title\":\" ... \", \n" +
            "      \"body\":\"start\" \n" +
            "   }, \n" +
            "   \"group_id\":1, \n" +
            "   \"secret\":\"sjr948dff3kjnfd3\" \n" +
            "}";
    private VkMessageParser vkMessageParser = new VkMessageParser(testJsonIncomingMessage);

    @Test
    public void testGetUserId(){
        System.out.println(vkMessageParser.getUserId());
        assertEquals("123456", vkMessageParser.getUserId());
    }

    @Test
    public void testGetUserMessage(){
        System.out.println(vkMessageParser.getMessage());
        assertEquals("start", vkMessageParser.getMessage());
    }



}
