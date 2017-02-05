package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * //http://www.journaldev.com/2774/java-8-stream
 * 
 * @author Sanjay
 *
 */
public class Java8StreamExample {

	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			myList.add(i);

		// sequential stream
		Stream<Integer> sequentialStream = myList.stream();

		// parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();

		// using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter(p -> p > 70);
		// using lambda in forEach
		highNums.forEach(p -> System.out.println("High Nums parallel=" + p));

		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 70);
		highNumsSeq.forEach(p -> System.out.println("High Nums sequential=" + p));

		int sum = myList.stream().filter(s -> (s > 1 && s < 5)).mapToInt(i -> i).sum();
		System.out.println("Filter and Map =" + sum);

		// use map() to apply functions to an stream
		Stream<String> names = Stream.of("aBc", "d", "ef");
		System.out.println("Using Map to apply functions:: " + names.map(s -> {
			return s.toUpperCase();
		}).collect(Collectors.toList()));

		// Stream flatMap() example - use flatMap() to create a stream from the
		// stream of list.
		Stream<List<String>> namesOriginalList = Stream.of(Arrays.asList("Pankaj"), Arrays.asList("David", "Lisa"),
				Arrays.asList("Amit"));
		// flat the stream from List<String> to String stream
		Stream<String> flatStream = namesOriginalList.flatMap(strList -> strList.stream());
		// flatStream.forEach(System.out::println);
		flatStream.forEach(s -> System.out.println("Using flapMap to convert stream =" + s));

		// Converting Java Stream to Collection or Array
		// use java Stream collect() method to get List, Map or Set from stream.
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
		List<Integer> intList = intStream.collect(Collectors.toList());
		System.out.println("Converting Java Stream to Collection or Array " + intList);
		// prints [1,2,3,4]																						

		intStream = Stream.of(1, 2, 3, 4); // stream is closed, so we need to
											// create it again
		Map<Integer, Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i + 10));
		System.out.println(" use java Stream collect() method to get List, Map or Set from stream " + intMap); 
		// prints {1=11, 2=12, 3=13, 4=14}

		// use reduce() to perform a reduction on the elements of the stream,
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
		Optional<Integer> intOptional = numbers.reduce((i, j) -> {
			return i * j;
		});
		if (intOptional.isPresent())
			System.out.println("Multiplication = " + intOptional.get()); // 120

	}

}