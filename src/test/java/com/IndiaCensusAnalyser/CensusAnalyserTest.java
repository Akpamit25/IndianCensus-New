package com.IndiaCensusAnalyser;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import builder.CSVException;
public class CensusAnalyserTest {

	private static final String INDIA_CENSUS_CSV_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCensusData.csv";
	private static final String WRONG_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCensusData_WrongFile.csv";
	private static final String WRONG_TYPE_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCensusData_WrongType.txt";
	private static final String WRONG_DELIMITER_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCensusWrongDelimiter.csv";
	private static final String WRONG_HEADER_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCensusWrongHeader.csv";

	private static final String INDIA_STATE_CODE_CSV_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCode.csv";
	private static final String STATE_CODE_WRONG_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCode_WrongFile.csv";
	private static final String STATE_CODE_WRONG_TYPE_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCode_WrongType.txt";
	private static final String STATE_CODE_WRONG_DELIMITER_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCodeWrongDelimiter.csv";
	private static final String STATE_CODE_WRONG_HEADER_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCodeWrongHeader.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() {

		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(36, numOfRecords);
		} catch (CSVException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void givenIndianCensusDataWithWrongFileShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CSVException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_FILE_PATH);
		} catch (CSVException e) {
//			Assert.assertEquals(e.getExceptionType()  , CSVException.ExceptionType.WRONG_FILE_PATH);
			Assert.assertEquals(e.getMessage(), WRONG_FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongFileTypeShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CSVException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_TYPE_FILE_PATH);
		} catch (CSVException e) {
			Assert.assertEquals(e.getExceptionType(), CSVException.ExceptionType.WRONG_FILE_TYPE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongDelimiterShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CSVException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_DELIMITER_PATH);
		} catch (CSVException e) {
			Assert.assertEquals(e.getExceptionType(), CSVException.ExceptionType.WRONG_DELIMITER_TYPE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongHeaderShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CSVException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_HEADER_PATH);
		} catch (CSVException e) {
			Assert.assertEquals(e.getExceptionType(), CSVException.ExceptionType.WRONG_HEADER);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianStateCodeCSVFileReturnsCorrectRecords() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaStateCodeData(INDIA_STATE_CODE_CSV_FILE_PATH);
			Assert.assertEquals(36, numOfRecords);

		} catch (CSVException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianStateCodeWithWrongFileShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CSVException.class);
			censusAnalyser.loadIndiaStateCodeData(STATE_CODE_WRONG_FILE_PATH);
		} catch (CSVException e) {
			Assert.assertEquals(e.getExceptionType(), CSVException.ExceptionType.WRONG_FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianStateCodeDataWithWrongFileTypeShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CSVException.class);
			censusAnalyser.loadIndiaStateCodeData(STATE_CODE_WRONG_TYPE_FILE_PATH);
		} catch (CSVException e) {
			Assert.assertEquals(e.getExceptionType(), CSVException.ExceptionType.WRONG_FILE_TYPE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianStateCodeDataWithWrongDelimiterShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CSVException.class);
			censusAnalyser.loadIndiaStateCodeData(STATE_CODE_WRONG_DELIMITER_PATH);
		} catch (CSVException e) {
			Assert.assertEquals(e.getExceptionType(), CSVException.ExceptionType.WRONG_DELIMITER_TYPE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianStateCodeDataWithWrongHeaderShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CSVException.class);
			censusAnalyser.loadIndiaStateCodeData(STATE_CODE_WRONG_HEADER_PATH);
		} catch (CSVException e) {
			Assert.assertEquals(e.getExceptionType(), CSVException.ExceptionType.WRONG_HEADER);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}