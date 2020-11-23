package builder;

import java.io.Reader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import exception.CSVException;

public class OpenCSVBuilder <E> implements ICSVBuilder{
	public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CSVException {
		try {
			CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(csvClass);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<E> csvToBean = csvToBeanBuilder.build();
			return csvToBean.iterator();
		} catch (IllegalStateException e) {
			throw new CSVException(e.getMessage(), CSVException.ExceptionType.WRONG_FILE_TYPE);
		}

	}

}
