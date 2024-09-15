package org.example;

import java.util.HashMap;
import java.util.Map;

public class FibonacciDemo {
    private static Map<Integer, Long> fibonacciMap = new HashMap<>();

//Час. скл. - О(n), простор. скл. - O(1)
    public long iterationFibonacci(int n) {
        if(n <= 1){
            return n;
        }
        long prev1 = 0, prev2 = 1;
        long result = 0;

        for (int i = 2; i <= n; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }

        return result;
    }

//Час. скл. - О(2^n), простор. скл. - O(n)
    public long recursiveFibonacci(int n) {
        if(n <= 1){
            return n;
        }
        return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
    }

//Час. скл. - О(n), простор. скл. - O(n)
    public long fibonacciDP(int n) {
        if(n <= 1){
            return n;
        }
        if(fibonacciMap.containsKey(n)){
            return fibonacciMap.get(n);
        }
        long fib = fibonacciDP(n-1) + fibonacciDP(n-2);
        fibonacciMap.put(n, fib);
        return fib;
    }


    public static void main(String[] args) {
        FibonacciDemo demo = new FibonacciDemo();
        System.out.println(demo.iterationFibonacci(6));
        System.out.println(demo.recursiveFibonacci(6));
        System.out.println(demo.fibonacciDP(6));
    }
}
