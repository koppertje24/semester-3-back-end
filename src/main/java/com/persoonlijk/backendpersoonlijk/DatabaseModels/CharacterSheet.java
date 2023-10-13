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

    @Column(name = "playerId")
    private Long playerId;
}
