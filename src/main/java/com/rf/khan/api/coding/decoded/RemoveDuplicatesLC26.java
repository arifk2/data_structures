package com.rf.khan.api.coding.decoded;

public class RemoveDuplicatesLC26 {
	public static void main(String[] args) {
		RemoveDuplicatesLC26 r = new RemoveDuplicatesLC26();
		int[] arr = { 1, 1, 2 };
		int index = r.removeDuplicates(arr);
		System.out.println(index);

		for (int i = 0; i < index; i++) {
			System.out.print(arr[i] + ", ");
		}

	}

	public int removeDuplicates(int[] nums) {
		int insertIndex = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] != nums[i]) {
				nums[insertIndex] = nums[i];
				insertIndex++;
			}
		}

		return insertIndex;
	}
}
