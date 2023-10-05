package com.persoonlijk.backendpersoonlijk.controllers;

import com.persoonlijk.backendpersoonlijk.models.CharacterSheet;
import com.persoonlijk.backendpersoonlijk.services.CharacterSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterSheetController {

    private final CharacterSheetService characterSheetService;

    @Autowired
    public CharacterSheetController(CharacterSheetService characterSheetService) {
        this.characterSheetService = characterSheetService;
    }

    @GetMapping("/{id}")
    public CharacterSheet getCharacterSheetById(@PathVariable Long id) {
        return characterSheetService.getCharacterSheetById(id);
    }
}
