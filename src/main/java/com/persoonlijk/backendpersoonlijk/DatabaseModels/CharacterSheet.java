package com.persoonlijk.backendpersoonlijk.DatabaseModels;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class CharacterSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "characterName")
    private String CharacterName;

    @Column(name = "characterClass")
    private EnumCharacterClass CharacterClass;

    @Column(name = "abilityScores")
    private CharacterAbilityScores AbilityScores;

    @Column(name = "skillProficiency")
    private boolean[] SkillProficiency;

    @Column(name = "characterLevel")
    private short CharacterLevel = 0;

    @Column(name = "playerId")
    private Long playerId;
}

