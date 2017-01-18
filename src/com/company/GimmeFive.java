package com.company;

import java.util.stream.IntStream;

public class GimmeFive {

    public static void main(String[] args) {
        GimmeFive obj = new GimmeFive();
        int result = obj.dontGiveMeFive(2,5);
        System.out.println(result);
    }

    public int dontGiveMeFive(int start, int end)
    {
        IntStream stream = IntStream.range(start, end+1);
        IntStream res = stream.filter(num -> !containsFive(num));
        return (int)res.count();
    }


    private boolean containsFive(int number){
        number = Math.abs(number); // Handles negative ranges as well
        while(number>0){
            if(number%10 == 5)
            {
                return true;}
            number = number/10;
        }
        return false;
    }
}
