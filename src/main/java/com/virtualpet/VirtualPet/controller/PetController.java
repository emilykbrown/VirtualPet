package com.virtualpet.VirtualPet.controller;

import com.virtualpet.VirtualPet.component.MoodGenerator;
import com.virtualpet.VirtualPet.service.FormatterService;
import com.virtualpet.VirtualPet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetController {

    @Autowired
    private MoodGenerator moodGenerator;

    @Autowired
    private PetService petService;

    @Autowired
    private FormatterService formatterService;

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
        String petName = petService.getPetName();
        return moodGenerator.generateMoodMessage(petName);
    }

    @PostMapping("/pet/play")
    public String playWithPet(@RequestBody String toy) {
        return petService.getPetName() + " is playing with the " + toy;
    }

    @GetMapping("/pet/feed")
    public String feedPet(@RequestParam double amount) {
        return "You fed " + petService.getPetName() + " a treat worth " + formatterService.format(amount);
    }


}
