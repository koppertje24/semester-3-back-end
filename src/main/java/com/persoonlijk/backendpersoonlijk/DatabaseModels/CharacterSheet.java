package com.persoonlijk.backendpersoonlijk.DatabaseModels;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CharacterSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CharacterName")
    private String CharacterName;

    public Long GetId() {
        return id;
    }

    public String getCharacterName() {
        return CharacterName;
    }

}
