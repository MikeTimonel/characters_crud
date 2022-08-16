package com.ourgame.charactercrud.controller;

import com.ourgame.charactercrud.dto.CharacterDTO;
import com.ourgame.charactercrud.entity.CharacterEntity;
import com.ourgame.charactercrud.error.CharacterNotFoundException;
import com.ourgame.charactercrud.repository.CharacterRepository;
import com.ourgame.charactercrud.serviceCharac.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    /*private final CharacterRepository characterRepository;*/

    /*public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }*/
    @GetMapping("/charactersR")

    List<CharacterDTO> all() {
        return characterService.findAllCharacters();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/charactersC")
    @ResponseStatus(HttpStatus.CREATED)
    public void newCharacter(@RequestBody CharacterDTO newCharacter) throws Exception {
        characterService.addCharacter(newCharacter);
    }

    @GetMapping("/charactersReadone")
    CharacterDTO oneCharacter(@RequestParam String id) {
        if(Objects.isNull(characterService.findOneCharacter(id))){
            throw new CharacterNotFoundException(id);
        }
        return characterService.findOneCharacter(id);
    }

    @RequestMapping(method = RequestMethod.POST, value= "/charactersU")
    public void replaceCharacter(@RequestBody CharacterDTO characterDTO, @RequestParam String id){
            characterService.replaceCharacter(characterDTO, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/charactersD")
    public void deleteCharacter(@RequestParam String id){
        characterService.deleteCharacter(id);
    }
}
