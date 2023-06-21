package com.example.music_journal.model.enumerations;

public enum Genre {
    //INDIE, ROCK, POP, HIPHOP, R_B, ALTERNATIVE_POP, FOLK, TECHNO
    ROCK(1),
    POP(2),
    JAZZ(3),
    ELECTRONIC(4),
    INDIE(5),
    HIPHOP(6),
    TECHNO(7),
    ALTERNATIVEPOP(8),
    FOLK(9);


    // Add more genres with their corresponding ordinal values

    private final int ordinalValue;

    private Genre(int ordinalValue) {
        this.ordinalValue = ordinalValue;
    }

    public int getOrdinalValue() {
        return ordinalValue;
    }
}
