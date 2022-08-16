package com.ourgame.charactercrud.dto;

import com.ourgame.charactercrud.entity.CharacterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
    String id;
    String name;
    String color_hair;
    String color_eyes;
    int age;
    int height;

    /*@Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof CharacterDTO))
            return false;
        CharacterDTO characterDTO = (CharacterDTO) o;
        return Objects.equals(this.id, characterDTO.id) && Objects.equals(this.name, characterDTO.name)
                && Objects.equals(this.color_hair, characterDTO.color_hair) && Objects.equals(this.color_eyes, characterDTO.color_eyes)
                && Objects.equals(this.age, characterDTO.age) && Objects.equals(this.height, characterDTO.height);
    }*/
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.color_hair, this.color_eyes, this.age, this.height);
    }
    @Override
    public String toString() {
        return "Character{" + "id=" + this.id + ", name='" + this.name + '\'' + ", color_hair='" + this.color_hair + '\'' + ", color_eyes='" + this.color_eyes + '\'' + ", age='" + this.age + '\'' + ", height='" + this.height +'\'' + '}';
    }
}
