package movie.catalog;

public enum Genre {

    ACTION("Action"),
    ADVENTURE("Adventure"),
    COMEDY("Comedy"),
    CRIME("Crime"),
    DRAMA("Drama"),
    FANTASY("Fantasy"),
    SCI_FI("Sci-Fi"),
    THRILLER("Thriller"),
    WAR("War"),
    WESTERN("Western");

    private String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return genre;
    }
}
