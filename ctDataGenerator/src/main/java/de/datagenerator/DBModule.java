package de.datagenerator;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import de.datagenerator.writer.EventWriter;
import de.datagenerator.writer.IWriter;
import de.datagenerator.writer.MessageWriter;
import de.datagenerator.writer.ParticipationWriter;
import de.datagenerator.writer.UserWriter;
 
public class DBModule
   extends AbstractModule {

   @Override
   protected void configure() {
      bind(IWriter.class).annotatedWith(Names.named("User")).to(UserWriter.class);
      bind(IWriter.class).annotatedWith(Names.named("Event")).to(EventWriter.class);
      bind(IWriter.class).annotatedWith(Names.named("Message")).to(MessageWriter.class);
      bind(IWriter.class).annotatedWith(Names.named("Participation")).to(ParticipationWriter.class);
   }
}
