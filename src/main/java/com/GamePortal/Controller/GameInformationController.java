package com.GamePortal.Controller;

import com.GamePortal.Entity.GameInformation;
import com.GamePortal.Service.GameInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameInformationController {

    @Autowired
    private GameInformationService gameInformationService;

    @PostMapping("/add/game")
    public String addGameInformation(@RequestBody GameInformation gameInformation) {
        return gameInformationService.addGameInformation(gameInformation);
    }

    @PutMapping("/update/game")
    public String updateGameInformation(@RequestBody GameInformation gameInformation) {
        return gameInformationService.updateGameInformation(gameInformation);
    }

    @DeleteMapping("/delete/game/{id}")
    public String deleteGameInformation(@PathVariable Long id) {
        return gameInformationService.deleteGameInformation(id);
    }

    @RequestMapping("/get/game/{id}")
    public GameInformation getGameInformation(@PathVariable Long id) {
        return gameInformationService.getGameInformation(id);
    }


}
