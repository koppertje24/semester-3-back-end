package com.persoonlijk.backendpersoonlijk.DatabaseModels;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CharacterSheet {

    enum EnumCharacterlass {
        NoneSelecter,
        Barbarian,
        Bard,
        Cleric,
        Druid,
        Fighter,
        Monk,
        Paladin,
        Ranger,
        Rogue,
        Sorcerer,
        Warlock,
        Wizard,
        Artificer,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "characterName")
    private String CharacterName;

    @Column(name = "characterClass")
    private EnumCharacterlass CharacterClass;

    @Column(name = "playerId")
    private Long playerId;
}
