package javaCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream.range(1, 10).forEach(System.out::println);
		System.out.println();
		
		IntStream.range(1, 10).skip(5).forEach(x -> System.out.println(x));
		System.out.println();
		
		IntStream.range(1, 10).skip(5).forEach(System.out::println);
		System.out.println();
		
		System.out.println(IntStream.range(1, 10).sum());
		System.out.println();
		
		Stream.of("xyz","ghy","abc","rs","ghyt").sorted().findFirst().ifPresent(System.out::println);
		System.out.println();
		
		Stream.of("4","6","3","2","6").sorted().findFirst().ifPresent(System.out::println);
		System.out.println();
		
		String [] names = {"sbn","sasa","assaew","rtrt","snh","lkj"};
		
		Stream.of(names).sorted().findFirst().ifPresent(System.out::println);
		System.out.println();
		
		Arrays.stream(names).filter(x -> x.startsWith("s")).sorted().findFirst().ifPresent(System.out::println);
		System.out.println();
		
		Arrays.stream(names).filter(x -> x.startsWith("s")).sorted().forEach(System.out::println);
		System.out.println();
		
		Arrays.stream(new int[] {2,4,6,8,10}).map(x -> x * x).forEach(x -> System.out.println(x));
		System.out.println();
		
		Arrays.stream(new int[] {2,4,6,8,10}).map(x -> x * x).average().ifPresent(System.out::println);
		System.out.println();
		
		List<String> people = Arrays.asList("ADF","sasa","RTG","HJK","bgjl","HJLH");
		people.stream().map(String::toLowerCase).filter(x -> x.startsWith("h")).forEach(System.out::println);
		System.out.println();
		
		List<Integer> values = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			values.add(i);
		}
		values.stream().filter(x -> x % 5 == 0).filter(x -> x > 50).forEach(System.out::println);
		
		
	}

}
