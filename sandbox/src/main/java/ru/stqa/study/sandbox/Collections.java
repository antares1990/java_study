package ru.stqa.study.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public  static void main(String[] arg) {
        String[] langs = {"Java", "C#", "Python", "PHP"};

        List<String> languages = Arrays.asList("Java", "C#");


        for (String l : languages) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}
