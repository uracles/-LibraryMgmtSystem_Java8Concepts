package com.Library.MeraLib.entities;


import com.Library.MeraLib.enums.Gender;
import com.Library.MeraLib.enums.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Librarian extends People {
    private String staffIdNumber;
    private Role role = Role.STAFF;

    public Librarian(String name, Gender gender, String staffIdNumber, Role role) {
        super(name, gender);
        this.staffIdNumber = staffIdNumber;
        this.role = role;
    }
}
