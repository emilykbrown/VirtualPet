package com.virtualpet.VirtualPet.component;

import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class MoodGenerator {
    private final List<String> moods = Arrays.asList("Excited", "Playful", "Angry", "Sleepy");
    private final Random random = new Random();

    public String generateMoodMessage(String petName) {
        String mood = moods.get(random.nextInt(moods.size()));
        return petName + " is " + mood;
    }
}