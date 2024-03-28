package dyn;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Fib {
	public static BigInteger fibDyn(int n) {
		return fibDyn(n, new HashMap<Integer, BigInteger>());
	}
	private static BigInteger fibDyn(int n, Map<Integer, BigInteger> memo) {
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		if (n <= 2) {
			return BigInteger.valueOf(1);
		}
		memo.put(n,
				fibDyn(n - 1, memo).add(fibDyn(n - 2, memo)));
		return memo.get(n);
	}
	
	public static long fib(long n) {
		if (n <= 2) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}
	
	public static void main(String[] args) {
		long startTime = 0;
		long endTime = 0;
		
//		startTime = System.currentTimeMillis();
//		System.out.println(fib(60L));
//		endTime = System.currentTimeMillis();
//		System.out.println("fib total execution time: " + (endTime - startTime) / 1000 + "seconds");
//		System.out.println();
//		startTime = System.currentTimeMillis();
//		System.out.println(fibDyn(600));
//		endTime = System.currentTimeMillis();
//		System.out.println("fibDyn executed in " + (endTime - startTime) / 1000 + " seconds");
//		
//		List<String> list1 = new ArrayList<>();
//		
//		list1.add("foo");
//		
//		List<String> list2 = list1;
//		List<String> list3 = new ArrayList<>(list1);
//		
//		list1.clear();
//		list2.add("bar");
//		list3.add("baz");
//		
//		System.out.println(list1);
//		System.out.println(list2);
//		System.out.println(list3);
		
		Set<Integer> set = new TreeSet<Integer>();
		
		set.add(3);
		set.add(3);
		set.add(2);
		
		System.out.println(set);
		
	}
}



