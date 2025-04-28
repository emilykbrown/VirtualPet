package com.virtualpet.VirtualPet.controller;

import com.virtualpet.VirtualPet.component.MoodGenerator;
import com.virtualpet.VirtualPet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    @Autowired
    private MoodGenerator moodGenerator;

    @Autowired
    private PetService petService;

    @GetMapping("/")
    public String home() {
        return "Welcome to Fluffy's Virtual Pet World!";
    }

    @GetMapping("/pet/info")
    public String getPetInfo() {
        return petService.getPetInfo();
    }

    @GetMapping("/pet/mood")
    public String getPetMood() {
        //return moodGenerator.generateMoodMessage(petService.getPetName());
        String petName = petService.getPetName();
        return moodGenerator.generateMoodMessage(petName);
    }

}
