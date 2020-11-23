package builder;

import java.io.Reader;
import java.util.Iterator;

import exception.CensusAnalyserException;

public interface ICSVBuilder<E> {

	public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CensusAnalyserException;

}
