package com.sirdave.data_structures;

import java.util.*;

class WordCount{
    String word;
    int count;

    public WordCount(String word, int count){
        this.word = word;
        this.count = count;
    }
}

public class TopKFrequent {
    static List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<WordCount> priorityQueue =
                new PriorityQueue<>((x, y) ->{
                    if (x.count == y.count)
                        return y.word.compareTo(x.word);
                     else return x.count - y.count;
                });

        HashMap<String, Integer> map = new HashMap<>();

        for (String s: words){
            int val = map.getOrDefault(s, 0);
            map.put(s, val + 1);
        }

        for (String w: map.keySet()){
            WordCount wordCount = new WordCount(w, map.get(w));
            priorityQueue.add(wordCount);

            if(priorityQueue.size()>k) {
                priorityQueue.poll();
            }
        }

        List<String> arrayList = new ArrayList<>();

        while (!priorityQueue.isEmpty()){
            String word = priorityQueue.poll().word;
            arrayList.add(word);
        }
        Collections.reverse(arrayList);
        return arrayList;

    }

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        List<String> output = topKFrequent(words, 2);
        System.out.println(output);
    }
}