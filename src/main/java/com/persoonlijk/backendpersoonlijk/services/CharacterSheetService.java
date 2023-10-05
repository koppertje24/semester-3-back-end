package com.persoonlijk.backendpersoonlijk.services;

import com.persoonlijk.backendpersoonlijk.DAO.CharacterSheetRepository;
import com.persoonlijk.backendpersoonlijk.models.CharacterSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CharacterSheetService {

    private final CharacterSheetRepository characterSheetRepository;

    @Autowired
    public CharacterSheetService(CharacterSheetRepository characterSheetRepository) {
        this.characterSheetRepository = characterSheetRepository;
    }

    public CharacterSheet getCharacterSheetById(Long id) {
        Optional<CharacterSheet> characterSheetOptional = characterSheetRepository.findById(id);

        // Check if the CharacterSheet exists in the database
        if (characterSheetOptional.isPresent()) {
            return characterSheetOptional.get();
        } else {
            // Handle the case where the CharacterSheet does not exist
            return null;
        }
    }
}
