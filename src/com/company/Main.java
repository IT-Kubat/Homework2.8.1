package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, String[]> dictionary = new HashMap<>();
        dictionary.put("Cool",
                new String[]{"beautiful", "wonderful", "smart", "calm"});
        dictionary.put("House",
                new String[]{"Zhilishe", "Hizhina", "Department", "Kvartiry"});
        dictionary.put("Chelovek",
                new String[]{"Lichnost'", "Persona", "Homosapiens", "Individum"});
        HashMap<String, String[]> bigDictionary = new HashMap<>();

        Set<String> keys = dictionary.keySet();
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            String key = iter.next().toString();
            String[] value = dictionary.get(key);
            bigDictionary.put(key, value);
            for (int i = 0; i < value.length; i++) {
                String newKey = value[i];
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.addAll(Arrays.asList(value));
                arrayList.remove(newKey);
                arrayList.add(key);
                String[] newValue = new String[arrayList.size()];
                newValue = arrayList.toArray(newValue);
                bigDictionary.put(newKey, newValue);

            }
        }
//            System.out.println("Введите любое слово из словаря: ");
//    Scanner s = new Scanner(System.in);
//    String sentences = s.nextLine().toLowerCase();
//    String[] words = sentences.split(" ");
//    Random r = new Random();
//        for (int i = 0; i < words.length; i++) {
//        String[] synonyms = bigDictionary.get(words[i]);
//        if (synonyms != null) {
//            int randomNumber = r.nextInt(synonyms.length);
//            System.out.printf(synonyms[randomNumber] + " ");
//        } else {
//            System.out.println("Не понял Вас");
//        }
        System.out.println("Enter your word");
        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine();
        String[] words = sentence.split(" ");
        Random r = new Random();
        for (String word : words) {
            String[] synonyms = dictionary.get(word);
            if (synonyms != null) {
                System.out.printf(synonyms[r.nextInt(synonyms.length)] + " ");
            } else {
                System.out.println("Такого слова в словаре нет");
            }

        }
    }
}
