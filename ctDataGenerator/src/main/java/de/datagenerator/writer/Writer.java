package de.datagenerator.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;

import de.ct.shared.Product;
import de.datagenerator.LogUtil;

public abstract class Writer implements IWriter {

	protected BufferedWriter writer;
	protected FileSystem fs;
	protected Path file;
	protected Charset charset;
	protected SimpleDateFormat df; 

	public abstract void write(Product aProduct);

	public void initWriter(String filePath) {
		file = Paths.get(filePath);
		charset = Charset.forName("UTF-8");
		df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			writer = Files.newBufferedWriter(file, charset,
					new OpenOption[] { StandardOpenOption.CREATE });
		} catch (IOException e) {
			LogUtil.getLogger().error(e);
		}
	}

	public void close() {
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			LogUtil.getLogger().error(e);
		}
	}

}
