package com.example.test;

import java.util.HashSet;

public class NumberPairsForSum {
	
	void numberPairsForSum(int[] array, int sum) {
	    HashSet<Integer> set = new HashSet<Integer>();
	    for (int num : array) {
	        if (set.contains(sum - num)) {
	            String s = num + ", " + (sum - num) + " add up to " + sum;
	            System.out.println(s);
	        }
	        set.add(num);
	    }
	}

}
