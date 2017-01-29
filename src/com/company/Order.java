package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Word {
    public String word;
    public int number;
    Word(String word, int number){
        this.word = word;
        this.number = number;
    }
};

public class Order {
    public static String order(String sentence) {
        List<Word> words = Arrays.stream(sentence.split(" ")).map(word -> new Word(word,getNumber(word))).collect(Collectors.toList());
        Comparator<Word> comparator = Comparator.comparing(e -> e.number);

        words.sort(comparator);
        return words.stream().filter(x->x.number>=0).map(x->x.word).reduce((w1,w2)->(w1+ " " + w2)).get();
    }

    private static int getNumber(String word) {
        IntStream nums = word.chars().filter(c->Character.isDigit(c));
        return nums.findFirst().orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(Order.order("hi is2 Thi1s T4est 3a hi"));
    }
}