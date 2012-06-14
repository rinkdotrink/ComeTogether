package de.datagenerator.writer;

import java.io.IOException;

import de.ct.shared.Event;
import de.ct.shared.Product;
import de.datagenerator.LogUtil;

public class EventWriter extends Writer {

	public EventWriter() {
		try {
			initWriter("Files/Event.txt");
		} catch (Exception e) {
			LogUtil.getLogger().error(e);
		}
	}

	public void write(final Product aProduct) {
		if (aProduct instanceof Event) {
			writeEvent((Event) aProduct);
		}
	}

	private void writeEvent(final Event aEvent) {
		String date = df.format(aEvent.getDate().getTime());
		String s = aEvent.getEventId() + ";" + aEvent.getCreatorId() + ";"
				+ aEvent.getEventUserId() + ";" + date + ";"
				+ aEvent.getEventname() + ";" + aEvent.getOccasion() + ";"
				+ aEvent.getLocation() + ";" + aEvent.getLonRad()
				+ " " + aEvent.getLatRad() + ";" + aEvent.getDescription() + ";"
				+ aEvent.getNumberMaleConfirmed() + ";"
				+ aEvent.getNumberFemaleConfirmed() + "\n";
		try {
			writer.write(s);
		} catch (IOException e) {
			LogUtil.getLogger().error(e);
		}
	}

}
