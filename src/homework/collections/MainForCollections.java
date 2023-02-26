package homework.collections;

import static homework.collections.Duplicate.getDuplicatesWithCount;

public class MainForCollections {
    public static void main(String[] args) {

        System.out.println("-----Repeating words----");

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


        System.out.println("-----Dictionary----");

        /**
         * Создайте класс словаря. Словарь должен позволять добавить слово на исходном языке, например,
         английский и его возможные переводы на целевой язык, напр немецкий.

         Словарь должен уметь добавлять записи в виде пара исходное слово + перевод.
         Должен уметь выдавать все возможные переводы по исходному слову.
         Если слово на исходном языке уже существует, а мы добавляем перевод, то новый перевод должен добавиться,
         а не перезаписать предыдущий. При этом дубликатов переводов одного слова быть не должно.
         По желанию можно добавить обратный поиск, удаление переводов или полностью слов.
         **/


        Dictionary dictionary = new Dictionary();
        dictionary.addWordAndTranslation("katze", "cat");
        dictionary.addWordAndTranslation("katze", "kitty");
        dictionary.addWordAndTranslation("katze", "cat");
        dictionary.addWordAndTranslation("katze", "pussycat");
        System.out.println(dictionary.getTranslationOf("katze"));

        dictionary.addWordAndTranslation("welt", "world");
        dictionary.addWordAndTranslation("welte", "worlds");
        dictionary.addWordAndTranslation("welt", "realm");
        dictionary.addWordAndTranslation("welt", "peace");
        System.out.println(dictionary.getTranslationOf("welt"));
        System.out.println(dictionary.getTranslationOf("welte"));
        System.out.println(dictionary.getTranslationOf("test"));

        System.out.println();
        dictionary.showAll();

    }
}
