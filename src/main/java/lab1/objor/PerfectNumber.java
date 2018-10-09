package lab1.objor;

import java.util.Set;
import java.util.TreeSet;

public class PerfectNumber {

    public static Set<Integer> divisors(int n) {
        TreeSet<Integer> divs = new TreeSet<Integer>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                divs.add(i);
        }
        return divs;
    }

    public static STATE process(int n) {
        int sum = 0;

        for (int i : divisors(n)) {
            if (i == n)
                break;
            sum += i;
        }

        if (sum == n)
            return STATE.PERFECT;
        else if (sum > n)
            return STATE.ABUNDANT;
        else
            return STATE.DEFICIENT;

    }

    public enum STATE {
        ABUNDANT, DEFICIENT, PERFECT
    }

}
