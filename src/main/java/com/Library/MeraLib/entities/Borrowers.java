package com.Library.MeraLib.entities;

import com.Library.MeraLib.enums.Gender;
import com.Library.MeraLib.enums.LevelsOfBorrower;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString


public class Borrowers {

    private String name;
    Gender gender;
    private String bookTitleRequest;
    private LevelsOfBorrower levelsOfBorrower;

    //let there be a field like an arraylist that when one borrows book, it adds
    // to the borrowers list and subtract from the library

    public Borrowers() {
    }

    public Borrowers(String name, Gender gender, String bookTitleRequest, LevelsOfBorrower levelsOfBorrower) {
        this.name = name;
        this.gender = gender;
        this.bookTitleRequest = bookTitleRequest;
        this.levelsOfBorrower = levelsOfBorrower;
    }
}


