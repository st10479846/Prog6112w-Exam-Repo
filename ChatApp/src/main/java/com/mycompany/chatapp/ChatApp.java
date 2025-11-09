package com.mycompany.chatapp;

/*
 * Name: Eugene Makhukhule 
 * Student Number:  ST1047984
 * POE: Part 2
 * Date: 26 May 2025
 * Description: This program manages messages by storing, sending,
 * and displaying them using dialog boxes.
 */

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;



public class ChatApp {
    // At the top of ChatApp class
        static ArrayList<Message> sentMessages = new ArrayList<>();
        static ArrayList<Message> disregardedMessages = new ArrayList<>();
        static ArrayList<String> messageHashes = new ArrayList<>();
        static ArrayList<String> messageIDs = new ArrayList<>();
    

    public static void main(String[] args) {
        // Display a welcome message using a dialog box
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");

        // Start the chat system (user registration and login process)
        boolean loggedIn = ChatSystem.startChat();

        if (loggedIn) {
            int totalMessages = 0;
            boolean validInput = false;

            // Get valid number of messages
            while (!validInput) {
                String input = JOptionPane.showInputDialog("How many messages would you like to send?");
                try {
                    totalMessages = Integer.parseInt(input);
                    validInput = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid number. Please enter a valid integer.");
                }
            }

            int count = 0; // Total messages sent

            OUTER:
            while (count < totalMessages) {
                String[] options = {"Send Message", "Show Recently Sent Messages", "Quit"};
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Choose an option:",
                        "QuickChat Menu",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]
                );

                switch (option) {
                  //POE Part 3
                    case 0 -> {
                     // Send Message
                         String recipient = JOptionPane.showInputDialog("Enter recipient phone number:");
                         if (recipient == null || recipient.trim().isEmpty()) {
                          JOptionPane.showMessageDialog(null, "Recipient number is required.");
                      break;
                    }

                     String messageText = JOptionPane.showInputDialog("Enter your message:");
                     if (messageText == null || messageText.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Message content is required.");
                  break;
                }
                     ///POE Part Code Editor
                     String flag = "Sent";
                     String messageID = UUID.randomUUID().toString();

                    try {
                     Message message = new Message(recipient.trim());

                    if (Validator.checkCellPhoneNumber(recipient.trim())) {
                       message.composeMessage();  // Generates ID and hash
                         message.displayMessage();
                         message.saveToJson();

                    // Add to tracking arrays
                     sentMessages.add(message);
                     messageHashes.add(message.getMessageHash());
                    messageIDs.add(message.getMessageID());

                 JOptionPane.showMessageDialog(null, "Message sent and saved successfully.");
                 count++;
                } else {
               // Invalid number
                disregardedMessages.add(message);
                 JOptionPane.showMessageDialog(null, "Message disregarded due to invalid phone number.");
             }

             } catch (HeadlessException e) {
                 JOptionPane.showMessageDialog(null, "Error sending message: " + e.getMessage(),
                   "Error", JOptionPane.ERROR_MESSAGE);
             }
        }
                    
//Old Case statement ending
                    case 1 -> {
                        // Show Recently Sent Messages
                        Message.sendStoredMessages();
                    }

                    case 2, JOptionPane.CLOSED_OPTION -> {
                        // Quit
                        JOptionPane.showMessageDialog(null, "You sent a total of " + count + " messages.\nThank you for using QuickChat.");
                        break OUTER;
                    }

                    default -> {
                        JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                    }
                }
            }

            // Final confirmation (already shown in "Quit", this is just redundancy-safe)
            JOptionPane.showMessageDialog(null, "You sent a total of " + count + " messages.");
        } else {
            // Login failed
            JOptionPane.showMessageDialog(null, "Login failed. Exiting QuickChat.");
        }
    }
    
    //POE Part 3 Code Edit
    public static void showReportMenu(){
        String[] options = {
            "Display senders/recipients",
            "Find longest message",
            "Search by message ID",
            "Delete by message hash",
            "Display full report",
            "Exit"
        };
        
        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Message Report Options",
                    "Report Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
        
        switch (choice) {
            case 0 -> MessageReport.displayAllSenderRecipients();
            case 1 -> MessageReport.displayLongestMessage();
            case 2 -> {
                String id = JOptionPane.showInputDialog("Enter message ID:");
                if (id != null) MessageReport.searchByMessageID(id);
            }
            case 3 -> {
                String recipient = JOptionPane.showInputDialog("Enter recipient:");
                if (recipient != null) MessageReport.searchByRecipient(recipient);
            }
            case 4 -> {
                String hash = JOptionPane.showInputDialog("Enter Message Hash");
                if (hash !=null && !hash.trim().isEmpty()) {
                try {
                    MessageReport.deleteByHash(hash.trim());
                    } catch (Exception e) {
                        JOptionPane.showInputDialog(null,
                                "Error deleting message: " + e.toString(),
                                "Deletion Error",
                                JOptionPane.ERROR_MESSAGE);                               
                    }
                } else {
                    JOptionPane.showInputDialog(null,
                            "No hash entered or operation cancelled",
                            "Input Cancelled",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            case 5 -> MessageReport.displayFullReport();
            case 6 -> { return; }
            default -> {}
        }
        }
   
   }
    ///POE PArt 3 Code Edit Searhc by ID
    public static void searchMessageByID(List<Message> messageList, String searchID) {
        boolean found = false;
        StringBuilder messageDetails = new StringBuilder();
        
        for (Message msg : messageList) {
           if (msg.getMessageID().equalsIgnoreCase(searchID)) {
               messageDetails.append("Match found!\n")
                       .append("Recipient: ").append(msg.getRecipient()).append("\n")
                       .append("Message: ").append(msg.getMessageText());
               found = true;
               break;
           }
        }
        if (!found) {
            messageDetails.append("No message found with ID: ").append(searchID);
        }
        JOptionPane.showMessageDialog(
                null,
                messageDetails.toString(),
                "Message Search Results",
                found ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.WARNING_MESSAGE
        );
    }
    


}



