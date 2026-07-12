package com.example.music_player;

public class AudioDevice {

    private String brand;
    private int volume;

    public AudioDevice(String brand) {
        this.brand = brand;
        this.volume = 50;
    }

    public String getBrand() {
        return brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
