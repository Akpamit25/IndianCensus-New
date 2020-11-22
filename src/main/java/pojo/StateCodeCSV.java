package pojo;

import com.opencsv.bean.CsvBindByName;

public class StateCodeCSV {
	@CsvBindByName(column = "State")
	public String state;

	@CsvBindByName(column = "StateCode")
	public String stateCode;

	@Override
	public String toString() {
		return "IndiaCensusCSV{" + "State='" + state + ", StateCode='" + stateCode + '}';
	}

}
