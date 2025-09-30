package br.com.guessgame;

public enum Difficulty {
    EASY("Easy", 10),
    MEDIUM("Medium", 5),
    HARD("Hard", 3);

    private final String name;
    private final Integer chances;

    Difficulty(String name, Integer chances) {
        this.name = name;
        this.chances = chances;
    }

    public String getName() {
        return name;
    }
}
