package com.Library.MeraLib.services;

import com.Library.MeraLib.entities.Book;
import com.Library.MeraLib.entities.Borrowers;
import com.Library.MeraLib.enums.LevelsOfBorrower;
import com.Library.MeraLib.repository.Library;

import java.util.function.Consumer;

public interface LibrarianService {

    //give out book

    //collect book back from people
    String giveOutBooks(Library library);
    String givingOutBookOnPriority(Library library);
    Boolean findBook(Borrowers borrowers, Library library);

    void removeBookFromLibrary(Borrowers borrowers, Library library);





}
