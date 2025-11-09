/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.util.Iterator;
import javax.swing.JOptionPane;
/*
 * Name: Eugene Makhukhule 
 * Student Number:  ST1047984
 * POE: Part 3
 * Date: 17 June 2025
 * Description: Message Report
 */

/**
 *
 * @author eugen
 */
public class MessageReport {
    
      /**
     * Displays a list of all sent messages showing sender and recipient.
     * Currently assumes sender is always "Developer".
     */
        
        public static void displayAllSenderRecipients(){
        StringBuilder report = new StringBuilder();
        report.append("Senders and Receipeint of Sent Message:\n");
               
        // Loop through all sent messages
        for (Message msg : Message.getSentMessages()) {
            report.append("From: Developer, To:")
                    .append(msg.getRecipient()).append("\n");
        }
          // Show the report in a dialog box
        JOptionPane.showMessageDialog(null, report.toString());
        }
     /**
     * Finds and displays the longest message (by text length) from sent messages.
     */
        public static void displayLongestMessage() {
        Message longest = null;
        
         // Loop to find the message with the longest text
         for (Message msg : Message.getSentMessages()) {
             if(longest == null ||
            msg.getMessageText().length() > longest.getMessageText().length()){
            longest = msg;
        }
         // If a message was found, show it in a confirmation dialog
         if (longest != null) {
            JOptionPane.showConfirmDialog(null,
                    "Longest message:\n" + longest.getMessageText());
            }
          }
        }
    /**
     * Searches for a message by its unique ID in sent messages.
     * Displays the message details if found.
     * 
     * @param id The ID to search for
     */
        public static void searchByMessageID(String id) {
         for (Message msg : Message.getSentMessages()) {
                if  (msg.getMessageID().equals(id)) {
                 JOptionPane.showMessageDialog(null,
                        "Message found:\nRecipient: " + msg.getRecipient() +
                        "\nMessage: " + msg.getMessageText());
                    return;
            }
        }
        // Show error if ID not found
        JOptionPane.showMessageDialog(null, "Message ID not Found.");
     }
    
    
    /**
     * Displays all messages (sent and stored) sent to a specific recipient.
     * 
     * @param recipient The recipient to search messages for
     */
         public static void searchByRecipient(String recipient) {
        StringBuilder result = new StringBuilder();
        result.append("Messages for ").append(recipient).append(":\n");
          
         // Search in sent messages
             for (Message msg : Message.getSentMessages()) {
                  if (msg.getRecipient().equals(recipient)) {
                result.append("- ").append(msg.getMessageText()).append("\n");
                  }

              }
                 // Search in stored messages
             for (Message msg : Message.getStoredMessages()) {
                    if (msg.getRecipient().equals(recipient)) {
                      result.append("- ").append(msg.getMessageText()).append("\n");
            }
              }
              // Display the result
         JOptionPane.showMessageDialog(null, result.toString());
          }
    
     /**
     * Displays a complete report of all sent and stored messages.
     */
         public static void displayFullReport() {
                StringBuilder report = new StringBuilder();
               report.append("FULL MESSAGE REPORT\n\n");
        
               // Add sent messages
           report.append("SEND MESSAGES:\n");
               for (Message msg : Message.getSentMessages()) {
                   report.append(formatMessage(msg)).append("\n---\n");
        }
                // Add stored messages
               report.append("\nSTORED MESSAGES:\n");
             for (Message msg : Message.getStoredMessages()) {
            report.append(formatMessage(msg)).append("\n---\n");
              }
             // Show the complete report
            JOptionPane.showMessageDialog(null, report.toString());
        }
    
     /**
     * Formats a message into a readable string with details.
     * 
     * @param msg The message to format
     * @return A string representation of the message
     */
            private static String formatMessage(Message msg) {
                return "Hash: " + msg.getMessageHash() + "\n" +
                "ID: " + msg.getMessageID() + "\n" +
                "Recipient: " + msg.getRecipient() + "\n" +
                "Message: " + msg.getMessageText() + "\n" +
                "Status: " + (msg.isSent() ? "Sent" : 
                            (msg.getStoredMessages().contains(msg) ? "Stored" : "Disregarded"));
            }
    
         public static void deleteByHash(String hash) {
                //Check sent Messages
                   for (Iterator<Message> iterator = Message.getSentMessages().iterator(); iterator.hasNext();)
              {
                  Message msg = iterator.next();
                    if (msg.getMessageHash().equals(hash)) {
                iterator.remove();
                 Message.getMessageHashes().remove(hash);
                JOptionPane.showMessageDialog(null,
                        "Message deleted successfully:\n" + msg.getMessageText(),
                        "deletion Successful",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
                    }
             }
         // Check Stored Message
          for (Iterator<Message> iterator = Message.getStoredMessages().iterator(); iterator.hasNext();){
         
               Message msg = iterator.next();
               if (msg.getMessageHash().equals(hash)) {
                  iterator.remove();
                   JOptionPane.showMessageDialog(null,
                     "Stored message deleted successfully:\n" + msg.getMessageText(),
                     "Deletion Successful",
                     JOptionPane.INFORMATION_MESSAGE);
                    return;
                    }
             }
             //If not Found
             JOptionPane.showMessageDialog(null,
                    "No message found with hash: " + hash,
                    "Not Found",
                   JOptionPane.WARNING_MESSAGE);
             
    }
    
}
