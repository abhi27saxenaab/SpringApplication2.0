package com.leetcode;

public class HappyNumber {
    public static void main(String[] args) {
        Boolean isHappy= isHappyNumber(456,0);
        System.out.println(isHappy);

    }

    public static Boolean isHappyNumber(int n, int iterateCount){
        int square = Square(n);
        if(iterateCount >4){
            return false;
        }else if(square==1){
            System.out.println("This is Happy Number");
            return true;
        }
        else{
            return isHappyNumber(square,++iterateCount);
        }
        //return false;
    }
    public static int Square(int n){
        int sum=0;
        while(n>0){
            int last = n%10;
            n = n/10;
            sum = sum + last*last;
        }
        return sum;
    }
}
