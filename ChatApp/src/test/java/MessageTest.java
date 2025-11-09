import com.mycompany.chatapp.Message;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Name: Eugene Makhukhule 
 * Student Number:  ST1047984
 * POE: Part 3
 * Date: 15 June 2025
 * Description: This program manages messages by storing, sending,
 * and displaying them using dialog boxes.
 */


public class MessageTest {
    private Message msg1, msg2, msg3, msg4;

    // Test if a correctly sized message passes the length check
    @Test
    public void testMessageLengthSuccess() {
        Message msg = new Message("+27718693002", "Short message", "MSG010");
        assertTrue(msg.getMessageText().length() <= 250, "Message should be 250 characters or less");
    }

    // Test if an overly long message fails the length check
    @Test
    public void testMessageLengthFailure() {
        String longMessage = "a".repeat(260); // 260 characters
        Message msg = new Message("+27718693002", longMessage, "MSG011");
        assertFalse(msg.getMessageText().length() <= 250, "Message should be rejected if longer than 250 characters");
    }

    // Test if a valid cellphone number format passes
    @Test
    public void testRecipientFormatSuccess() {
        Message msg = new Message("+27718693002");
        assertTrue(msg.checkRecipientCell(), "Valid cellphone number should pass");
    }

    // Test if invalid cellphone number format fails
    @Test
    public void testRecipientFormatFailure() {
        Message msg = new Message("08575975889");
        assertFalse(msg.checkRecipientCell(), "Invalid cellphone number should fail");
    }

    // Test if message hash contains ':' separator
    @Test
    public void testMessageHash() {
        Message msg = new Message("+27718693002");
        assertTrue(msg.createMessageHash().contains(":"), "Message hash should contain ':' separator");
    }

    // Test if a message can be marked as read
    @Test
    public void testMarkMessageAsRead() {
        Message msg = new Message("+27718693002");
        msg.readMessage(); // Mark as read
        assertTrue(msg.isRead(), "Message should be marked as read.");
    }

    // Test if a read message displays the correct status
    @Test
    public void testMessageReadStatusDisplay() {
        Message msg = new Message("+27718693002");

        // Before reading
        assertFalse(msg.isRead(), "Message should initially not be marked as read.");

        // After marking as read
        msg.readMessage();
        assertTrue(msg.isRead(), "Message should now be marked as read after calling readMessage().");
    }

    // Test if correct formatted recipient returns the success message
    @Test
    public void testValidRecipientFormatSuccess() {
        Message msg = new Message("+27738693002");
        String result = msg.validateRecipientCellWithMessage();
        assertTrue(result.contains("successfully captured"), "Correct number should confirm successful capture.");
    }

    // Test if incorrectly formatted recipient returns the failure message
    @Test
    public void testValidateRecipientFormatFailure() {
        Message msg = new Message("+27738693002");
    String result = msg.validateRecipientCellWithMessage();
    assertTrue(result.contains("successfully captured"), "Correct number should confirm successful capture.");
    }
    
    //POE Part 3 Code Starts here---------------

    /**
     *
     */
    @Test
    void testSendMessageArray(){
        // Clear previous messages (redundant if @BeforeEach clears them)
        Message.getSentMessages().clear();
    
        // Create and send test messages
        Message msg1 = new Message("+27834557896", "Did you get the cake?", "MSG001");
        Message msg4 = new Message("0838884567", "It is dinner time!", "MSG004");
    
        msg1.sendMessage(msg1.getMessageText());
        msg4.sendMessage(msg4.getMessageText());
    
        // Verify
        assertEquals(2, Message.getSentMessages().size());
        assertTrue(Message.getSentMessages().get(0).getMessageText().contains("cake")); 
        assertTrue(Message.getSentMessages().get(1).getMessageText().contains("dinner"));
    }
    
   
    
    //Clear Test Methods
    @BeforeEach
    void setUp() {
   // Clear all message tracking
    Message.getSentMessages().clear();
    Message.getStoredMessages().clear();
    Message.getDisregardedMessages().clear();
    Message.getMessageHashes().clear();
    Message.getMessageIDs().clear();
    
    // Initialize test messages with ALL required fields
    msg1 = new Message("+27834557896", "Did you get the cake?", "MSG001");
    msg2 = new Message("+27838884567", "Where are you? You are late!", "MSG002");
    msg3 = new Message("+27834484567", "Yohoooo, I am at your gate.", "MSG003"); 
    msg4 = new Message("0838884567", "It is dinner time!", "MSG004");
    
    // Validate initialization
    assertAll(
        () -> assertNotNull(msg1.getMessageText(), "Message 1 text is null"),
        () -> assertNotNull(msg2.getMessageText(), "Message 2 text is null"),
        () -> assertNotNull(msg3.getMessageText(), "Message 3 text is null"),
        () -> assertNotNull(msg4.getMessageText(), "Message 4 text is null")
    );
}
       
    
    @Test
    void testLongestMessage() {
         msg1.sendMessage(msg1.getMessageText());
        msg2.sendMessage(msg2.getMessageText());
    
        Message longest = Message.getSentMessages().stream()
        .max(Comparator.comparing(m -> m.getMessageText().length()))
        .orElseThrow();
    
         assertEquals(msg2.getMessageText(), longest.getMessageText()); 
         // msg2's text is longer than msg1's
}
    
    
    //Tracking All messages
    @Test
    void testMessageTracking() {
        //Test Different MNessage Status
       msg1.sendMessage(msg1.getMessageText());  // Sent
         Message.getStoredMessages().add(msg2);    // Stored
         Message.getDisregardedMessages().add(msg3); // Disregarded
    
         assertEquals(1, Message.getSentMessages().size());
         assertEquals(1, Message.getStoredMessages().size());
         assertEquals(1, Message.getDisregardedMessages().size());
    }
   
    
}      
    
    




       

    
    
    

