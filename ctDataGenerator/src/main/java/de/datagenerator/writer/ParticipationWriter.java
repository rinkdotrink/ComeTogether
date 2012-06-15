package de.datagenerator.writer;

import java.io.IOException;

import de.ct.shared.Participation;
import de.ct.shared.Product;
import de.datagenerator.LogUtil;

public class ParticipationWriter extends Writer {

	public ParticipationWriter() {
		try {
			initWriter("Files/Participation.txt");
		} catch (Exception e) {
			LogUtil.getLogger().error(e);
		}
	}

	public void write(final Product aProduct) {
		if (aProduct instanceof Participation) {
			writeParticipation((Participation) aProduct);
		}
	}

	private void writeParticipation(final Participation aParticipation) {
		String s = "" + aParticipation.getParticipationId() + ";"
				+ aParticipation.getUserId() + ";" + aParticipation.getEventId()
				+ "\n";
		try {
			writer.write(s);
		} catch (IOException e) {
			LogUtil.getLogger().error(e);
		}
	}

}
