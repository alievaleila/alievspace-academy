package com.example.music_player;

public class SmartPhone extends AudioDevice implements Playable {

    private String currentSong;

    public SmartPhone(String brand) {
        super(brand);
    }

    @Override
    public void play() {
        System.out.println("Phone: " + (currentSong != null ? currentSong : "No song selected") + " is now playing.");
    }

    @Override
    public void stop() {
        System.out.println("Phone: Stopped playing " + currentSong + ".");
    }

    public void changeSong(String songName) {
        this.currentSong= songName;
        play();

    }

    public void changeSong(String songName, int startSecond) {
        this.currentSong = songName;
        System.out.println("Phone: " + songName + " started from " + startSecond + " seconds.");
    }
}
