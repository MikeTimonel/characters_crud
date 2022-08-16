package com.ourgame.charactercrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterEntity {
    @Id
    String id;
    public final static int MAX_LENGTH = 14;
    String name;
    String color_hair;
    String color_eyes;
    int age;
    int height;
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof CharacterEntity))
            return false;
        CharacterEntity characterEntity = (CharacterEntity) o;
        return Objects.equals(this.id, characterEntity.id) && Objects.equals(this.name, characterEntity.name)
                && Objects.equals(this.color_hair, characterEntity.color_hair) && Objects.equals(this.color_eyes, characterEntity.color_eyes)
                && Objects.equals(this.age, characterEntity.age) && Objects.equals(this.height, characterEntity.height);
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.color_hair, this.color_eyes, this.age, this.height);
    }
    @Override
    public String toString() {
        return "Character{" + "id=" + this.id + ", name='" + this.name + '\'' + ", color_hair='" + this.color_hair + '\'' + ", color_eyes='" + this.color_eyes + '\'' + ", age='" + this.age + '\'' + ", height='" + this.height +'\'' + '}';
    }
}
