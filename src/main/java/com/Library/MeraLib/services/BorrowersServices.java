package com.Library.MeraLib.services;

import com.Library.MeraLib.entities.Book;
import com.Library.MeraLib.entities.Borrowers;
import com.Library.MeraLib.enums.LevelsOfBorrower;
import com.Library.MeraLib.repository.Library;

public interface BorrowersServices {


    String addToQueue(Borrowers borrowers, Library library);

}
