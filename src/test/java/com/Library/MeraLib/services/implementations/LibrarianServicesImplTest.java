package com.Library.MeraLib.services.implementations;

import com.Library.MeraLib.entities.Book;
import com.Library.MeraLib.entities.Borrowers;
import com.Library.MeraLib.enums.Gender;
import com.Library.MeraLib.enums.LevelsOfBorrower;
import com.Library.MeraLib.repository.Library;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianServicesImplTest {

    @Test
    void giveOutBooks() {
        Library library = new Library();
        LibrarianServicesImpl librarianServicesTest = new LibrarianServicesImpl();

        Borrowers borrowers3 = new Borrowers("Esther", Gender.FEMALE,
                "go home", LevelsOfBorrower.JUNIOR_STUDENT);
        library.getQueueInLibrary().add(borrowers3);
        library.getBooksInLibrary().add(new Book("Things fall apart",
                "Cyprian Ekwensi", "E050", 1));
        String expected = ""+ borrowers3.getName()+ " borrowed "+ borrowers3.getBookTitleRequest();

        String actual = librarianServicesTest.giveOutBooks(library);

        assertEquals(expected,actual);
        //assertNotEquals(expected,actual);
    }


    @Test
    void givingOutBookOnPriority() {
        Library library = new Library();

        LibrarianServicesImpl librarianServicesTest = new LibrarianServicesImpl();
        Borrowers borrowers = new Borrowers("Daniel", Gender.MALE, "Without a silver spoon",
                LevelsOfBorrower.TEACHER);
        PriorityQueue<Borrowers> priorityBasedQueue = new PriorityQueue<>(Comparator.
                comparing(Borrowers::getLevelsOfBorrower));
        priorityBasedQueue.add(borrowers);
        library.setQueueInLibrary(priorityBasedQueue);

        library.getBooksInLibrary().add(new Book("Without a silver spoon", "Andrew Okafor",
                "B020", 2));

        String expected = ""+ borrowers.getName()+ " borrowed "+ borrowers.getBookTitleRequest();

        String actual = librarianServicesTest.giveOutBooks(library);

        assertEquals(expected,actual);
    }

    @Test
    void findBook_available() {
        Library library = new Library();
        LibrarianServicesImpl librarianServicesTest = new LibrarianServicesImpl();
        Borrowers borrowers = new Borrowers("Daniel", Gender.MALE, "Without a silver spoon",
                LevelsOfBorrower.TEACHER);
        //library.getBooksInLibrary().add(new Book("Things fall apart",
         //   "Cyprian Ekwensi", "E050", 1));
        library.getBooksInLibrary().add(new Book("Without a silver spoon", "Andrew Okafor",
                "B020", 2));

        boolean test = librarianServicesTest.findBook(borrowers,library);

        assertTrue(test);
    }
    @Test
    void findBook_unavailable() {
        Library library = new Library();
        LibrarianServicesImpl librarianServicesTest = new LibrarianServicesImpl();
        Borrowers borrowers = new Borrowers("Daniel", Gender.MALE, "Without a silver spoon",
                LevelsOfBorrower.TEACHER);
        library.getBooksInLibrary().add(new Book("Things fall apart",
                "Cyprian Ekwensi", "E050", 1));

        boolean test = librarianServicesTest.findBook(borrowers, library);

        assertFalse(test);
    }

}