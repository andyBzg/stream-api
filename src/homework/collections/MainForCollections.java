package homework.collections;

import static homework.collections.Duplicate.getDuplicatesWithCount;

public class MainForCollections {
    public static void main(String[] args) {

        /**
        Напишите метод, который получает массив слов (String) и считает количество вхождений по каждому слову.
        **/

        String source = "But I must explain to you how all this mistaken idea of " +
                "denouncing pleasure and praising pain was born and I will give you " +
                "a complete account of the system, and expound the actual teachings " +
                "of the great explorer of the truth, the master-builder of human happiness. " +
                "No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, " +
                "but because those who do not know how to pursue pleasure " +
                "rationally encounter consequences that are extremely painful.";

        getDuplicatesWithCount(source);

    }


}
