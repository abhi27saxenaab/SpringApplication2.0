package com.leetcode;

import com.BookStore.entity.Book;

public class IndexFirstOccurrenceString {

    public static int strStr(String haystack, String needle) {
        int needlelegth = needle.length();
        Boolean matchedString = false;
        if(needle.length() > haystack.length()){
            //return -1;
            System.out.println("not found");
        }
        int i=0;
        while (i < haystack.length()){

            int substringLenth = Math.min((haystack.length()-i),(needlelegth));

            if((haystack.charAt(i) == needle.charAt(0)) && (haystack.substring(i,i+substringLenth).equals(needle))) {
                matchedString =true;
                break;
            }
            i++;
        }
        if(matchedString==true){
            return i;
        }else{
            return -1;
        }
    }
    public static void main(String[] args) {
        String haystack="sadbutsad";
        String needle ="sad";
        strStr(haystack,needle);


    }
}
