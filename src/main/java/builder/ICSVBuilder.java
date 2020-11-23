package builder;

import java.io.Reader;
import java.util.Iterator;

import exception.CSVException;

public interface ICSVBuilder<E> {

	public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CSVException;

}
