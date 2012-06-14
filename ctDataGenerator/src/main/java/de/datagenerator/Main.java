package de.datagenerator;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.datagenerator.generator.Generator;

public class Main {

   public static void main(final String[] args) {
	  final int userIdx = 0;
      final int eventsPerUserIdx = 1;
      final int messagesPerUserIdx = 2;
      final int participationsPerUserIdx = 3;
      
      long user = Long.valueOf(args[userIdx]);
      long eventsPerUser = Long.valueOf(args[eventsPerUserIdx]);
      long messagesPerUser = Long.valueOf(args[messagesPerUserIdx]);
      long participationsPerUser = Long.valueOf(args[participationsPerUserIdx]);
            
      Injector injector = Guice.createInjector(new DBModule());
      Generator dataGenStrat = injector.getInstance(Generator.class);
      dataGenStrat.generate(user, eventsPerUser, messagesPerUser, participationsPerUser);
   }
}
