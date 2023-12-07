package com.persoonlijk.backendpersoonlijk.controllers;

import com.persoonlijk.backendpersoonlijk.DatabaseModels.CharacterSheet;
import com.persoonlijk.backendpersoonlijk.services.CharacterSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
public class CharacterSheetController {

    private final CharacterSheetService characterSheetService;

    @Autowired
    public CharacterSheetController(CharacterSheetService characterSheetService) {
        this.characterSheetService = characterSheetService;
    }

    @GetMapping("/get/{id}")
    public CharacterSheet getCharacterSheetById(@PathVariable Long id) {
        return characterSheetService.getCharacterSheetById(id);
    }

    @DeleteMapping("/delete/{userId}/{characterIndexId}")
    public ResponseEntity<String> deleteCharacterSheetById(@PathVariable Long  userId , @PathVariable Long characterIndexId) {
        boolean deleted = characterSheetService.deleteCharacterSheet(userId, characterIndexId);

        if (deleted) {
            return new ResponseEntity<>("Character sheet with userId: " + userId + " and characterIndexId: " + characterIndexId + "  deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Character sheet with userId: " + userId + " and characterIndexId: " + characterIndexId + " not found", HttpStatus.NOT_FOUND);
        }
    }


}
