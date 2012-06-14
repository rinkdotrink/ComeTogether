package de.datagenerator.timekeeper;

import java.util.Date;

public class ParticipationTimeKeeper
   extends TimeKeeper {

   public static void startTimeParticipation() {
      start = new Date().getTime();
      System.out.print("schreibe [" + participationsPerUser + " Participations Pro User * " + user + " User =] " + participationsPerUser * user + " Participations: ");
   }

   static public void endTime() {
      System.out.println(getRunningTimeKundeInSeconds() + " s");
      allTime += getRunningTimeKundeInSeconds();
      System.out.println("TotalTime: " +allTime+ " s");
   }
}
