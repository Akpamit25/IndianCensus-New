package com.IndiaCensusAnalyser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import builder.CSVBuilderFactory;
import builder.CSVException;
import builder.ICSVBuilder;
import builder.OpenCSVBuilder;
import pojo.IndiaCensusCSV;
import pojo.StateCodeCSV;
import builder.OpenCSVBuilder;

public class CensusAnalyser {
	public int loadIndiaCensusData(String csvFilePath) throws CSVException, IOException {

		String[] csvFile = csvFilePath.split("[.]");
		if (!csvFile[1].equals("csv")) {
			throw new CSVException(CSVException.ExceptionType.WRONG_FILE_TYPE);
		}
		checkDelimiter(csvFilePath);
		checkHeader(csvFilePath);

		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			Iterator<IndiaCensusCSV> censusCsvIterator = csvBuilder.getCSVFileIterator(reader,IndiaCensusCSV.class);
			return this.getCount(censusCsvIterator);
		} catch (IOException e) {
			throw new CSVException(e.getMessage(), CSVException.ExceptionType.WRONG_FILE_PATH);
		}
	}

	public void checkDelimiter(String csvFilePath) throws CSVException {
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(csvFilePath));
			while (true) {
				String line = br.readLine();
				String[] Linecolumns = line.split(",");
				if (Linecolumns.length < 4) {
					throw new CSVException(CSVException.ExceptionType.WRONG_DELIMITER_TYPE);
				}
			}
		} catch (NullPointerException | IOException e) {
		}

	}

	public void checkHeader(String csvFilePath) throws CSVException {
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(csvFilePath));
			String FirstLine = br.readLine();
			String[] columns = FirstLine.split(",");
			boolean isCorrect = columns[0].equals("State") && columns[1].equals("Population")
					&& columns[2].equals("AreaInSqKm") && columns[3].equals("DensityPerSqKm");
			if (!isCorrect) {
				throw new CSVException(CSVException.ExceptionType.WRONG_HEADER);
			}

		} catch (NullPointerException | IOException e) {
			e.printStackTrace();
		}

	}

	public int loadIndiaStateCodeData(String csvFilePath) throws CSVException, IOException {
		String[] csvFile = csvFilePath.split("[.]");
		if (!csvFile[1].equals("csv")) {
			throw new CSVException(CSVException.ExceptionType.WRONG_FILE_TYPE);
		}

		checkDelimiterStateCode(csvFilePath);
		checkHeaderStateCode(csvFilePath);
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			Iterator<StateCodeCSV> censusCsvIterator = csvBuilder.getCSVFileIterator(reader,StateCodeCSV.class);
			return this.getCount(censusCsvIterator);
		} catch (IOException e) {
			throw new CSVException(e.getMessage(), CSVException.ExceptionType.WRONG_FILE_PATH);
		}
	}

	public void checkDelimiterStateCode(String csvFilePath) throws CSVException {
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(csvFilePath));
			while (true) {
				String line = br.readLine();
				String[] Linecolumns = line.split(",");
				if (Linecolumns.length < 2) {
					throw new CSVException(CSVException.ExceptionType.WRONG_DELIMITER_TYPE);
				}
			}
		} catch (NullPointerException | IOException e) {
		}
	}

	public void checkHeaderStateCode(String csvFilePath) throws CSVException {
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(csvFilePath));
			String FirstLine = br.readLine();
			String[] columns = FirstLine.split(",");
			boolean isCorrect = columns[0].equals("State") && columns[1].equals("StateCode");
			if (!isCorrect) {
				throw new CSVException(CSVException.ExceptionType.WRONG_HEADER);
			}

		} catch (NullPointerException | IOException e) {
		}

	}

	private <E> int getCount(Iterator<E> iterator) {
		int numOfEntries = 0;
		Iterable<E> csvIterable = () -> iterator;
		numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
		return numOfEntries;
	}
}
