package javaStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Streams;

public class StreamDemo {

	// @Test
	public void streamDemo() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Adam");
		names.add("Edwin");
		names.add("Adrian");
		names.add("Alan");
		names.add("Frank");

		Long c = names.stream().filter(s -> s.startsWith("A")).count();

		System.out.println(c);

		long d = Stream.of("Adam", "Edwin", "Adrian", "Alan", "Frank").filter(a -> {
			a.startsWith("A");
			return true;
		}).count();
		System.out.println(d);

		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
	}

	//@Test
	public void streamMap() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Alex");
		names.add("Edwin");
		names.add("Adrian");
		names.add("Alan");
		names.add("Frank");

		Stream.of("Zampa", "Alexa", "Thoma", "John", "Pearce").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 4).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		names.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
		
		String names1[] = {"James", "Cole", "Pat", "Cody"};
		List<String> namesList = Arrays.asList(names1);
		
		Stream<String> newList = Streams.concat(names.stream(),namesList.stream());
		//newList.forEach(s->System.out.println(s));
		
		boolean flag = newList.anyMatch(s->s.equalsIgnoreCase("Adrian"));
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void streamCollect() {
		List<String> collectist = Stream.of("Zampa", "Alexa", "Thoma", "John", "Pearce").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(collectist.get(0));
		
		List<Integer> numbers = Arrays.asList(1,3,5,3,4,4,7,8,1);
		numbers.stream().distinct().forEach(s->System.out.println(s));
		
		List<Integer> numList = Arrays.asList(1,5,2,8,4,9,7,6,3);
		List<Integer> num = numList.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(num.get(2));
	}
}
