package com.rf.khan.api.coding.decoded;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddressesLC93 {

	public static void main(String[] args) {
		RestoreIPAddressesLC93 r = new RestoreIPAddressesLC93();
		System.out.println(r.restoreIpAddresses("25525511135"));
	}

	private List<String> ans = new ArrayList<>();
	String str;

	public List<String> restoreIpAddresses(String s) {
		// case : where not possible
		if (s.length() > 12 || s.length() < 4) {
			return ans;
		}
		str = s;

		// empty string, index, dots
		solve("", 0, 0);

		return ans;
	}

	private void solve(String path, int index, int dots) {
		// base case: of the not is greater than 3 then return
		if (dots > 4)
			return;

		// as the dots == 4 and index is at last if te string then add in the list
		if (dots == 4 && index >= str.length()) {
			ans.add(path.substring(0, path.length() - 1));
			return;
		}

		// now on each iteration string can be 1, 2,3
		for (int length = 1; length <= 3 && index + length <= str.length(); length++) {
			String num = str.substring(index, index + length);
			if (num.charAt(0) == '0' && length != 1)
				break;
			else if (Integer.parseInt(num) <= 255) {
				solve(path + str.substring(index, index + length) + ".", index + length, dots + 1);
			}
		}

	}

}
