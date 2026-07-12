package com.example.music_player;

import java.util.ArrayList;

public class SoundSystem {
    ArrayList<Playable> playables = new ArrayList<>();

    public void addDevice(Playable device) {
        playables.add(device);
    }

    public void startParty() {
        for(Playable device: playables) {
            device.play();
    }


}

}
