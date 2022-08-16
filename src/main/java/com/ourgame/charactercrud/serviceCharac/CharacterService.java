package com.ourgame.charactercrud.serviceCharac;

import com.ourgame.charactercrud.dto.CharacterDTO;
import com.ourgame.charactercrud.entity.CharacterEntity;
import com.ourgame.charactercrud.error.CharacterNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.*;

import java.rmi.AlreadyBoundException;
import java.util.*;

@Service
public class CharacterService {
    private List<CharacterDTO> characterList = new ArrayList<>(Arrays.asList(
            new CharacterDTO("1","Mike Timonel","Brown", "Brown", 18, 166),
            new CharacterDTO("2","Charles Darwin","Blond", "Brown", 20, 169),
            new CharacterDTO("3","Diego Nino","Black", "Black", 19, 158)
    ));
    public List<CharacterDTO> findAllCharacters(){
        return characterList;
    }
    public CharacterDTO findOneCharacter(String id){
        CharacterDTO characterDTO = characterList.stream().filter(characterDTO1 -> characterDTO1.getId()
                .equals(id)).findFirst()
                .orElseThrow(() -> new CharacterNotFoundException(id));
        return characterDTO;
    }
    public void addCharacter(CharacterDTO characterDTO) throws Exception {
        if (characterRep(characterDTO.getId())){
            throw new AlreadyBoundException("Character with that id is already created.");
        } else if (characterDTO.getName().length() > CharacterEntity.MAX_LENGTH){
            throw new IllegalArgumentException("The name of the Character is so long.");
        }
        else {
            characterList.add(characterDTO);
        }
    }

    private boolean characterRep(String id) {
        return characterList.stream().filter(characterDTO -> Objects.equals(characterDTO.getId(), id)).count()>0;
    }

    public void replaceCharacter(CharacterDTO characterDTO, String id){
        int cont =0;
        for (CharacterDTO characterDTO1 : characterList){
            if (characterDTO1.getId().equals(id)){
                    characterList.set(cont, characterDTO);
            }
            cont++;
        }
    }
    public void deleteCharacter(String id){
        characterList.removeIf(characterDTO -> characterDTO.getId().equals(id));
    }
}
