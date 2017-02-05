package com.example.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FirstNonReaptedCharacter {

	/**
	 * Create a Set for repeating characters Create a List for Non-repeating
	 * characters Get the character if character is present in repeating set ->
	 * continue else character present in Non-repeating List remove from
	 * NonRepeating List add to repeating set
	 * 
	 * else add to nonRepeating
	 * 
	 * @param word
	 * @return
	 */
	public static char firstNonRepeatingChar(String word) {
		Set<Character> repeating = new HashSet<>();
		List<Character> nonRepeating = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (repeating.contains(letter)) {
				continue;
			}
			if (nonRepeating.contains(letter)) {
				nonRepeating.remove((Character) letter);
				repeating.add(letter);
			} else {
				nonRepeating.add(letter);
			}
		}
		return nonRepeating.get(0);
	}

	/**
	 * Use LinkedHashMap<Character, Integer> c = new
	 * LinkedHashMap<>(String.length)
	 * 
	 * @param str
	 * @return
	 */
	public static char getFirstNonRepeatedChar(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());

		for (char c : str.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}

		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("didn't find any non repeated Character");
	}

	public static String reverse(String str) {
		StringBuilder strBuilder = new StringBuilder();
		char[] strChars = str.toCharArray();

		for (int i = strChars.length - 1; i >= 0; i--) {
			strBuilder.append(strChars[i]);
		}

		return strBuilder.toString();
	}

	public static String reverseRecursively(String str) {

		// base case to handle one char string and empty string
		if (str.length() < 2) {
			return str;
		}

		return reverseRecursively(str.substring(1)) + str.charAt(0);

	}
	
	//Thread creation
	//Thread t1 = new Thread(new ParallelTask(), "Thread - T1");
	//t1.start();
	private static class ParallelTask implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()
                    + " is executing this code");

        }

    }
	
	public static void main(String[] args) {
		String str = "Sony is going to introduce Internet TV soon";
		System.out.println( FirstNonReaptedCharacter.reverseRecursively(str));
	}

}
