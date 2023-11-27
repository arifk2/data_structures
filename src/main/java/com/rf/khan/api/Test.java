package com.rf.khan.api;

public class Test {
	int version = 10;
	
	public static void main(String[] args) {
		
	}

	public String concatWS(String separator, String... args) {
		   StringBuilder sb = new StringBuilder();
		    if (args.length > 0) {
		      if (this.getDatabaseVersion() >= 15) {
		        sb.append("concat_ws(" + separator + ",");
		        sb.append(String.join(",", args));
		        sb.append(")");
		      } else {
		        sb.append(String.join("+" + separator + "+", args));
		      }
		    }
		    return sb.toString();
	  }
	
	public int getDatabaseVersion() {
		return version;
	}
}
