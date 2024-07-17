package org.example;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String input1 = "asd1234.0987745wq";
        String input2 = "asd.0987745wq";
        String input3 = "asd123.wq";
        String input4 = "asd123.9wq";
        String input5 = "123";
        String input6 = "abcd123.456";
        String input7 = "abcd123";

        System.out.println(formatNumber(input1));//1234.09
        System.out.println(formatNumber(input2));//0.09
        System.out.println(formatNumber(input3));//123.00
        System.out.println(formatNumber(input4));//123.90
        System.out.println(formatNumber(input5));//123.00
        System.out.println(formatNumber(input6));//123.45
        System.out.println(formatNumber(input7));//123.00
    }

    public static String formatNumber(String input){
        Pattern pattern = Pattern.compile("(\\d*)\\.(\\d{0,2})");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()){
            String left = matcher.group(1);
            String right = matcher.group(2);

            if (left.isEmpty()){
                left="0";
            }

            if (right.isEmpty()){
                right="00";
            }else if (right.length()==1){
                right=right+"0";
            }
            return left+"."+right;
        }else {
            return input.replaceAll("[^\\d]", "")+".00";
        }
    }
}
