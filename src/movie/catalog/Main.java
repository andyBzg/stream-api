package movie.catalog;


/**Создайте микроприложение справочника фильмов, в который можно добавлять информацию о фильме, а так же искать по разным параметрам.
    У фильма должно быть название, год выпуска, жанры, рейтинг. При желании можно еще режиссеры, продюсеры, актеры и прочее.
    Сами фильмы предлагаю оформить в отдельный класс.
    Справочник можно для начала сделать в любой коллекции.
    Функционал:
    Добавление фильма
    Удаление
    Обновление информации о фильме
    Поиск фильмов:
    По жанру, названию, году, рейтингу от до. Как вариант поиск по всем свойствам фильма.
    При этом должен поддерживаться поиск множественным критериям одновременно.
    ** по желанию, оформить все это в консольное приложение.**/

public class Main {
    public static void main(String[] args) {


        MovieCatalog catalog = new MovieCatalog();

        catalog.addMovie("Inception", 2010, "Sci-fi",8.8);
        catalog.addMovie("Star Wars: Episode V - The Empire Strikes Back", 1980, "Adventure", 8.7);
        catalog.addMovie("Full Metal Jacket", 1987, "Drama", 8.3);
        catalog.addMovie("The Matrix", 1999, "Sci-fi", 8.7);
        catalog.addMovie("The Green Mile", 1999, "Drama", 8.6);
        catalog.addMovie("Borat", 2006, "Comedy", 7.3);
        catalog.addMovie("Django Unchained", 2012, "Western", 8.4);
        catalog.addMovie("Mad Max: Fury Road", 2015, "Action", 8.1);
        catalog.addMovie("Terminator 2: Judgment Day", 1991, "Action", 8.6);

//        catalog.remove("Django Unchained");
//        catalog.updateTitle("Django Unchained", "Django");
//        catalog.updateRating("Mad Max: Fury Road", 9.9);
//        catalog.updateReleaseDate("Borat", 2023);
//        catalog.updateGenre("The Green Mile", "Comedy");

//        catalog.searchByTitle("wars");
//        catalog.searchByReleaseDate(2015);
//        catalog.searchByReleaseDate(1980, 2009);
//        catalog.searchByGenre("Drama");
//        catalog.searchByRating(7, 9);
//        catalog.searchByRating(8.5);

        System.out.println();
        System.out.println("-----------");

        System.out.println(catalog.getMovies());


    }
}
