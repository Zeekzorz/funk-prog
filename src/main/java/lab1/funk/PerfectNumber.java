package lab1.funk;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumber {

    public static Set<Integer> divisors(int n) {
//Imperative Solution:

// TreeSet<Integer> divs = new TreeSet<Integer>();
//
//		for (int i = 1; i <= n; i++) {
//			if (n % i == 0)
//				divs.add(i);
//		}
//		return divs;
//

// Functional solution:
        return IntStream
                .range(1, n + 1)
                .filter(e -> n % e == 0)
                .boxed()
                .collect(Collectors.toSet());

    }

    public static STATE process(int n) {
        //Imperative Solution:

//		int sum = 0;
//
//		for (int i : divisors(n)) {
//			if (i == n)
//				break;
//			sum += i;
//		}

        //Functional solution

        Integer sum = divisors(n)
                .stream()
                .filter(e -> e != n)
                .mapToInt(i -> i).sum();

        return (sum.compareTo(n) == 0) ? STATE.PERFECT : (sum.compareTo(n) > 0) ? STATE.ABUNDANT : STATE.DEFICIENT;

//		if (sum == n)
//			return STATE.PERFECT;
//		else if (sum > n)
//			return STATE.ABUNDANT;
//		else
//			return STATE.DEFICIENT;

    }

    public enum STATE {
        ABUNDANT, DEFICIENT, PERFECT
    }

}
