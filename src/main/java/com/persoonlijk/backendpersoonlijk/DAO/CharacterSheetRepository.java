package com.persoonlijk.backendpersoonlijk.DAO;

import com.persoonlijk.backendpersoonlijk.DatabaseModels.CharacterSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterSheetRepository extends JpaRepository<CharacterSheet, Long> {
    // Define custom query methods if needed
}
