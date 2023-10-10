package com.persoonlijk.backendpersoonlijk.services;

import com.persoonlijk.backendpersoonlijk.DAO.CharacterSheetRepository;
import com.persoonlijk.backendpersoonlijk.DatabaseModels.CharacterSheet;
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

    public CharacterSheet createCharacterSheet(CharacterSheet newCharacterSheet) {
        // Save the new character sheet to the database using the repository's save method
        return characterSheetRepository.save(newCharacterSheet);
    }

    public CharacterSheet updateCharacterSheet(Long id, CharacterSheet updatedCharacterSheet) {
        CharacterSheet existingCharacterSheet = characterSheetRepository.findById(id)
                .orElse(createCharacterSheet(updatedCharacterSheet));

        // Update the fields of the existing character sheet with the new data
        existingCharacterSheet.setCharacterName(updatedCharacterSheet.getCharacterName());

        // Save the updated character sheet to the database
        return characterSheetRepository.save(existingCharacterSheet);
    }
}
