package com.Library.MeraLib.repository;


import com.Library.MeraLib.entities.Book;
import com.Library.MeraLib.entities.Borrowers;
import com.Library.MeraLib.enums.LevelsOfBorrower;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode



public class Library {
    private List<Book> booksInLibrary;
    private Queue<Borrowers> queueInLibrary;



    public Library() {
        booksInLibrary = new ArrayList<>();
        queueInLibrary = new LinkedList<>();
    }

    public Library(List<Book> booksInLibrary, Queue<Borrowers> queueInLibrary) {
        this.booksInLibrary = booksInLibrary;
        this.queueInLibrary = queueInLibrary;
    }
}


