package com.Library.MeraLib.services.implementations;

import com.Library.MeraLib.entities.Book;
import com.Library.MeraLib.entities.Borrowers;
import com.Library.MeraLib.enums.LevelsOfBorrower;
import com.Library.MeraLib.repository.Library;
import com.Library.MeraLib.services.BorrowersServices;
import com.Library.MeraLib.enums.LevelsOfBorrower;

public class BorrowersServiceImpl implements BorrowersServices {

    @Override
    public String addToQueue(Borrowers borrowers, Library library) {
        library.getQueueInLibrary().add(borrowers);
        return null;
    }

}



