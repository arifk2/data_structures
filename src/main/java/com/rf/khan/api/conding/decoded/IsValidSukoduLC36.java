package com.rf.khan.api.conding.decoded;

import java.util.HashSet;
import java.util.Set;

public class IsValidSukoduLC36 {

	public boolean isValidSudoku(char[][] board) {
		Set<String> seen = new HashSet<String>();
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				char number = board[row][col];
				if (number != '.')
					if (seen.contains(number + "_R_" + row) || seen.contains(number + "_C_" + col)
							|| seen.contains(number + "_B_" + row / 3 + "_" + col / 3)) {
						return false;
					} else {
						seen.add(number + "_R_" + row);
						seen.add(number + "_C_" + col);
						seen.add(number + "_B_" + row / 3 + "_" + col / 3);
					}
			}
		}
		return true;
	}
}
