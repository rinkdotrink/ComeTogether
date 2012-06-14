package de.datagenerator.timekeeper;

import java.util.Date;

public class UserTimeKeeper
   extends TimeKeeper {

   public static void startTimeUser() {
      start = new Date().getTime();      
      System.out.print("schreibe " + user + " User: ");
   }

   public static void endTime() {
      System.out.println(getRunningTimeKundeInSeconds() + " s");
      allTime += getRunningTimeKundeInSeconds();
   }
}
