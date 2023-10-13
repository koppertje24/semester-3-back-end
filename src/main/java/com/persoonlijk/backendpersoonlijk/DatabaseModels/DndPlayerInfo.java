package com.persoonlijk.backendpersoonlijk.DatabaseModels;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

// een database model zijn entries in de database, en word gebruikt voor simpele dingen.
@Entity
@Data
public class DndPlayerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PlayerName")
    private String PlayerName;

    @OneToMany
    @JoinColumn(name = "playerId", referencedColumnName = "id")
    private List<CharacterSheet> PlayerCharacters;

}
