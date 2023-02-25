package homework.collections;

import java.util.*;

public class Duplicate {

    public static void getDuplicatesWithCount(String source) {

        String[] str = source.toLowerCase().split("[,.? ]+");

        List<String> words = List.of(str);

        Set<String> set = new HashSet<>();

        List<String> duplicates = words.stream()
                .filter(w -> !set.add(w))
                .toList();

        Map<String, Integer> duplicatesWithCount = new HashMap<>();

        for (String s : duplicates) {
            duplicatesWithCount.put(s, Collections.frequency(words, s));
        }

        System.out.println(duplicatesWithCount);
    }

}
