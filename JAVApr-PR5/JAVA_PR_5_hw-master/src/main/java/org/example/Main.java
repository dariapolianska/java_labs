package org.example;

import static org.example.FiniteAutomaton.recognizeTestWord;

public class Main {
    public static void main(String[] args) {
        System.out.println(recognizeTestWord("abcTESTabc"));
        System.out.println(recognizeTestWord("abcTES"));
        System.out.println(recognizeTestWord("abcTEStest"));
    }
}
