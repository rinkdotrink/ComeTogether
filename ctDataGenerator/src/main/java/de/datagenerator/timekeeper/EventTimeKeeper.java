package de.datagenerator.timekeeper;

import java.util.Date;

public class EventTimeKeeper
   extends TimeKeeper {

   public static void startTimeEvent() {
      start = new Date().getTime();
      System.out.print("schreibe [" + eventsPerUser + " Events Pro User * " + user + " User =] " + (eventsPerUser * user) + " Events: ");
   }

   static public void endTime() {
      System.out.println(getRunningTimeKundeInSeconds() + " s");
      allTime += getRunningTimeKundeInSeconds();
   }

}
