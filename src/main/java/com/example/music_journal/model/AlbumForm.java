package com.example.music_journal.model;

public class AlbumForm {
    private String name;
    private Integer yearRelease;
    private String favouriteSong;
    private boolean isDeluxe;

    // Getters and Setters

    public boolean isDeluxe() {
        return isDeluxe;
    }

    public void setDeluxe(boolean deluxe) {
        this.isDeluxe = deluxe;
    }
}
