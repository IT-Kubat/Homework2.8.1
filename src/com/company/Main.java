package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, String[]> dictionary = new HashMap<>();
        dictionary.put("cool",
                new String[]{"beautiful", "wonderful", "smart", "calm"});
        dictionary.put("house",
                new String[]{"Zhilishe", "Hizhina", "Department", "Kvartiry"});
        dictionary.put("chelovek",
                new String[]{"Lichnost'", "Persona", "Homosapiens", "Individum"});

        HashMap<String, String[]> bigDictionary = new HashMap<>();

        Set<String> keys = dictionary.keySet();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = iterator.next().toString();
            String[] values =dictionary.get(key);
            bigDictionary.put(key,values);
            for (int i = 0; i <values.length ; i++) {
                String new_Key = values[i];
                ArrayList<String> stringArray = new ArrayList<>();
                stringArray.addAll(Arrays.asList(values));
                stringArray.remove(new_Key);
                stringArray.add(key);
                String[] newVal = new String[stringArray.size()];
                newVal = stringArray.toArray(newVal);
                bigDictionary.put(new_Key, newVal);

            }
        }
        System.out.println("Enter your word");
        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine();
        String[] words = sentence.split(" ");
        Random r = new Random();
        for (String word : words) {
            String[] synonyms = bigDictionary.get(word);
            if (synonyms != null) {
                System.out.printf(synonyms[r.nextInt(synonyms.length)] + " ");
            } else {
                System.out.println("Такого слова в словаре нет");
            }
        }
    }
}
