package com.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int k=0;
        String first = strs[0];
        String last = strs[strs.length-1];
        int minLength =  Math.min(first.length(), last.length());
        while(k < minLength && first.charAt(k) == last.charAt(k)){
            k++;
        }
        return first.substring(0,k);
    }

    public static void main(String[] args) {
        String[] strs = {};
        String output = longestCommonPrefix(strs);
        System.out.println("===="+ output);
    }
}
