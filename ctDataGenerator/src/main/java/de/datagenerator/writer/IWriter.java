package de.datagenerator.writer;

import de.ct.shared.Product;

public interface IWriter {

	public void close();

	public void write(final Product aProduct);

}
