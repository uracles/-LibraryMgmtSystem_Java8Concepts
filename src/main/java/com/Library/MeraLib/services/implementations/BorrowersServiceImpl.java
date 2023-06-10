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

    public String giveOutBooks(Library library) {
        if (Objects.isNull(library))
            throw new CustomException("library cannot be empty");

        Borrowers borrowers;
        while ((borrowers = library.getQueueInLibrary().poll()) != null) {
            if (findBook(borrowers, library)) {
                removeBookFromLibrary(borrowers, library);
                return borrowers.getLevelsOfBorrower() + " " + borrowers.getName() + ", borrowed " + borrowers.getBookTitleRequest();
            }
            return borrowers.getLevelsOfBorrower() + " " + borrowers.getName() + ", " + borrowers.getBookTitleRequest() + " is unavailable";
        }
        return "No borrowers in the library queue.";
    }

    public class StreamExample {
        public static void main(String[] args) {
            List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");

            Optional<String> peekedName = names.stream().peek(System.out::println).findFirst();

            if (peekedName.isPresent()) {
                System.out.println("Peeked name: " + peekedName.get());
            } else {
                System.out.println("Stream is empty.");
            }
        }
    }
}



