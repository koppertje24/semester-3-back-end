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

    @Column(name = "CharacterName")
    private String PlayerName;

    @OneToMany
    @JoinColumn(name = "Sheet_Id", referencedColumnName = "id")
    private List<CharacterSheet> PlayerCharacters;

    public Long GetId() {
        return id;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public List<CharacterSheet> GetPlayerSheets(){
        return PlayerCharacters;
    }
}
