package com.rf.khan.api;

import java.util.HashMap;
import java.util.Map;

public class Arc {
	public static void main(String[] args) {

	}

	Map<String, String> formatMap = new HashMap<String, String>();

	public String getDatePart(String dateValue, String format) {
		StringBuilder sb = new StringBuilder();
		if (formatMap.get(format.toUpperCase()).contains("%")) {
			sb.append("date_format(" + dateValue + "," + formatMap.get(format.toUpperCase()).contains("%") + ")");
		} else {
			sb.append(formatMap.get(format.toUpperCase()) + "(" + dateValue + ")");
		}
		return sb.toString();
	}
}
