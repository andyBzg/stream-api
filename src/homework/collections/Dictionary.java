package homework.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {

    private Map<String, Set<String>> dictionary;


    public Dictionary() {
        dictionary = new HashMap<>();
    }


    public void addWordAndTranslation(String word, String translation) {
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, new HashSet<>());
        }
        dictionary.get(word).add(translation);
    }

    public String getTranslationOf(String word) {
        if (!dictionary.containsKey(word)) {
            return "Translation of word '" + word + "' does not present in Dictionary";
        }
        else {
            return word + ": " + dictionary.get(word).toString();
        }
    }

    public void showAll() {
        dictionary.forEach((s, set) -> {
                System.out.print(s + ": ");
                System.out.println(set.toString());
            });
    }
}
