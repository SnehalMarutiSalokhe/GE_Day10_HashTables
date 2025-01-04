package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        String sentence = "To be or not to be";
        for (String word : sentence.split(" ")) {
            Integer count = hashTable.get(word);
            count = (count == null) ? 1 : count + 1;
            hashTable.put(word, count);
        }
        System.out.println(hashTable);


        String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        for (String word : paragraph.split(" ")) {
            Integer count = hashTable.get(word);
            count = (count == null) ? 1 : count + 1;
            hashTable.put(word, count);
        }
        System.out.println(hashTable);

        hashTable.remove("avoidable");
        System.out.println(hashTable);
    }
}