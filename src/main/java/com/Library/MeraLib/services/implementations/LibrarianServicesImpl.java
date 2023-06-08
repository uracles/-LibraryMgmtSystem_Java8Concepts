package com.Library.MeraLib.services.implementations;


import com.Library.MeraLib.entities.Book;
import com.Library.MeraLib.entities.Borrowers;
import com.Library.MeraLib.enums.LevelsOfBorrower;
import com.Library.MeraLib.repository.Library;
import com.Library.MeraLib.services.LibrarianService;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LibrarianServicesImpl implements LibrarianService {

    @Override
    public String giveOutBooks(Library library) {
        Borrowers borrowers = library.getQueueInLibrary().peek();

        boolean bookFound = library.getBooksInLibrary().stream()
                .anyMatch(book -> book.getBookTitle().equals(borrowers.getBookTitleRequest()));

        if (bookFound) {
            removeBookFromLibrary(borrowers, library);
            return borrowers.getName() + " borrowed " + borrowers.getBookTitleRequest();
        }

        return borrowers.getName() + ", " + borrowers.getBookTitleRequest() + " is unavailable";

    }

    @Override
    public String givingOutBookOnPriority(Library library){

    PriorityQueue<Borrowers> priorityBasedQueue = new PriorityQueue<>(Comparator.
            comparing(Borrowers::getLevelsOfBorrower));

    priorityBasedQueue.addAll(library.getQueueInLibrary());
    library.setQueueInLibrary(priorityBasedQueue);

        return giveOutBooks(library);


    }

    //        library.getQueueInLibrary().stream().sorted(Comparator
//                .comparing(Borrowers::getLevelsOfBorrower)).forEach(System.out::println);

//        library.setQueueInLibrary(library.getQueueInLibrary().stream()
//                .sorted(Comparator.comparing(Borrowers::getLevelsOfBorrower))
//                .collect(Collectors.toCollection(PriorityQueue::new)));



    @Override
    public Boolean findBook(Borrowers borrowers, Library library) {
        return library.getBooksInLibrary().stream()
                .anyMatch(book -> book.getBookTitle().equals(borrowers.getBookTitleRequest())
                        && book.getCopiesOfBook() > 0);
    }


    @Override
    public void removeBookFromLibrary(Borrowers borrowers, Library library) {
        library.getBooksInLibrary().stream()
                .filter(book -> book.getBookTitle().equals(borrowers.getBookTitleRequest()))
                .findFirst()
                .ifPresent(book -> book.setCopiesOfBook(book.getCopiesOfBook() - 1));
    }
}



