package com.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        char[] ch= s.toCharArray();

        Stack<Character> stk = new Stack<>();

        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');
        for(char c:ch){
            if(hashMap.containsValue(c)){
                stk.push(c);
            }else{
                if(stk.empty() || stk.pop() !=hashMap.get(c)){
                    return false;
                }
            }
        }
        if(stk.empty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s ="[{}]";
        System.out.println(isValid(s));
    }
}
