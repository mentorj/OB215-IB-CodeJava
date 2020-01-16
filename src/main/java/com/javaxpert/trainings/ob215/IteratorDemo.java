package com.javaxpert.trainings.ob215;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class IteratorDemo {
    public static void main(String[] args) {
        String[] words= {"toto","titi","tutu"};
        List<String> wordsList = Arrays.asList(words);
        for(Iterator iter = wordsList.iterator();iter.hasNext();){
            String current = (String)iter.next();
            System.out.println("current = " + current);
        }

        Arrays.stream(words).forEach(System.out::println);
    }
}
