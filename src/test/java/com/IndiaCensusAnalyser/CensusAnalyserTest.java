package com.IndiaCensusAnalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exception.CensusAnalyserException;

public class CensusAnalyserTest {

	private static final String INDIA_CENSUS_CSV_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCensusData.csv";
	private static final String WRONG_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCensusData_WrongFile.csv";
	private static final String WRONG_TYPE_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCensusData_WrongType.txt";
	private static final String WRONG_DELIMITER_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCensusWrongDelimiter.csv";
	private static final String WRONG_HEADER_PATH = "D:\\Capg_Bridgelabz\\IndiaCensusAnalyser\\src\\main\\java\\resources\\StateCensusWrongHeader.csv";

	@Test
	public void givenCSVFileNumbeOfRecordsShouldMatch() throws CensusAnalyserException {

		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(36, numOfRecords);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void givenIndianCensusDataWithWrongFileShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_FILE_PATH);
		} catch (CensusAnalyserException e) {
//			Assert.assertEquals(e.getExceptionType()  , CensusAnalyserException.ExceptionType.WRONG_FILE_PATH);
			Assert.assertEquals(e.getMessage(), WRONG_FILE_PATH);
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongFileTypeShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_TYPE_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongDelimiterShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_DELIMITER_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_DELIMITER_TYPE);
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongHeaderShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_HEADER_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_HEADER);
		}
	}
}