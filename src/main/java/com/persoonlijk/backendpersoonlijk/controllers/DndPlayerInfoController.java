package com.persoonlijk.backendpersoonlijk.controllers;

import com.persoonlijk.backendpersoonlijk.DatabaseModels.CharacterSheet;
import com.persoonlijk.backendpersoonlijk.DatabaseModels.DndPlayerInfo;
import com.persoonlijk.backendpersoonlijk.services.DndPlayerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// een controller is gemaakt om ervoor te zorgen dat iemand met HTML code een opdracht kan uitvoeren,
// deze opdracht geeft json code terug.

@RestController
@RequestMapping("/players")
public class DndPlayerInfoController {

    private final DndPlayerInfoService playerInfoService;

    @Autowired
    public DndPlayerInfoController(DndPlayerInfoService playerInfoService) {
        this.playerInfoService = playerInfoService;
    }

    @GetMapping("/get/{id}")
    public DndPlayerInfo getCharacterSheetsByPlayerId(@PathVariable Long id) {
        DndPlayerInfo answer = playerInfoService.getCharacterSheetsByPlayerId(id);

        return answer;
    }

    @PutMapping("/put/{id}/Character/{characterId}")
    public DndPlayerInfo updateCharacterSheet(@PathVariable Long id, @PathVariable int characterId, @RequestBody CharacterSheet updatedCharacterSheet) {
        return playerInfoService.updateDndPlayerInfo(id, characterId, updatedCharacterSheet);
    }


    @PostMapping("/post/{id}/Character")
    public DndPlayerInfo createCharacterSheet(@PathVariable Long id, @RequestBody CharacterSheet updatedCharacterSheet) {
        return playerInfoService.createDndCharacter(id, updatedCharacterSheet);
    }

    @PostMapping("/post/{id}")
    public DndPlayerInfo createPlayerInfo(@RequestBody DndPlayerInfo newCharacterSheet) {
        return playerInfoService.createDndPlayerInfo(newCharacterSheet);
    }
}
