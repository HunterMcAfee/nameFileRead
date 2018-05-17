package com.demoproject;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner namesScanner = new Scanner(new File("C:\\Users\\syntel\\IdeaProjects\\nameFileRead\\src\\com\\demoproject\\names.txt"));
        namesScanner.useDelimiter(",");

        List<String> names = new ArrayList<String>();

        while (namesScanner.hasNext()) {
            names.add(namesScanner.next());
        }

        names.sort((string1, string2) -> (string1.compareTo(string2)));

        char startingChar = 'A';
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            charMap.put(startingChar, i);
            startingChar++;
        }
        names.sort((string1, string2) -> {
            Integer string1Val = 0;
            Integer string2Val = 0;
            for (char individualChar: string1.toCharArray()) {
                if (individualChar != '"')
                    string1Val+=charMap.get(individualChar);
            }
            for (char individualChar: string2.toCharArray()) {
                if (individualChar != '"')
                    string2Val+=charMap.get(individualChar);
            }
            return string1Val.compareTo(string2Val);
        });

        int nameTotal = 0;
        for (int i = 0; i < names.size(); i++) {
            for (char individualChar: names.get(i).toCharArray()) {
                if (individualChar != '"')
                    nameTotal+=charMap.get(individualChar);
            }
        }

        System.out.println(nameTotal);
    }
}
