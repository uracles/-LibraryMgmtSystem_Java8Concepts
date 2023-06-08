package com.Library.MeraLib.entities;

import com.Library.MeraLib.enums.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public abstract class People {
    private String name;
    Gender gender;


    public People(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
}
