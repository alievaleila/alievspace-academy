package com.example.music_player;

public class Main {
    public static void main(String[] args) {
        SoundSystem soundSystem = new SoundSystem();

        SmartPhone myPhone = new SmartPhone("Xiomi 12 Lite");

        myPhone.changeSong("My Favorite Song");
        myPhone.changeSong("New Song", 15);

        soundSystem.addDevice(myPhone);

        System.out.println("\n--- The Party Started ---");
        soundSystem.startParty();
    }
}