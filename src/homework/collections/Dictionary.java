package homework.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dictionary {

    private Map<String, Set<String>> dictionary;


    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public Map<String, Set<String>> getDictionary() {
        return dictionary;
    }

    public void addWordAndTranslation(String word, Set<String> translation) {
        dictionary.put(word, translation);
    }

    /*public Dictionary(Map<String, Set<String>> dictionary) {
        this.dictionary = dictionary;
    }*/

    public String showDictionary() {
        return dictionary.entrySet().toString();
    }

    public void setDictionary(Map<String, Set<String>> dictionary) {
        this.dictionary = dictionary;
    }


    public String getTranslationOf(String word) {
        if (dictionary.containsKey(word)) {
            return dictionary.get(word).toString();
        }
        else {
            return "Translation of word '" + word + "' does not present in Dictionary";
        }
    }

    public String addTranslation(String transl) {
        //TODO реализация метода добавления новых переводов
        return transl;
    }

}
