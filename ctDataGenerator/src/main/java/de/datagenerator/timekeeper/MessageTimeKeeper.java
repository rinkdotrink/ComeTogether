package de.datagenerator.timekeeper;

import java.util.Date;

public class MessageTimeKeeper
   extends TimeKeeper {

   public static void startTimeMessage() {
      start = new Date().getTime();
      System.out.print("schreibe [" + messagesPerUser + " Messages per User * " + user + " User =] " + messagesPerUser * user + " Messages: ");
   }

   static public void endTime() {
      System.out.println(getRunningTimeKundeInSeconds() + " s");
      allTime += getRunningTimeKundeInSeconds();      
   }
}
