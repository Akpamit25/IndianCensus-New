package builder;

import builder.CSVException.ExceptionType;

public class CSVException extends Exception {

	public enum ExceptionType {
		WRONG_FILE_PATH, WRONG_FILE_TYPE, WRONG_DELIMITER_TYPE, WRONG_HEADER;
	}

	ExceptionType type;

	public CSVException(ExceptionType type) {

		this.type = type;
	}

	public CSVException(String message, ExceptionType type) {
		super(message);
		this.type = type;

	}

	public ExceptionType getExceptionType() {
		return type;
	}

}
