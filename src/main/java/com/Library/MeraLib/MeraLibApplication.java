package com.Library.MeraLib;


import com.Library.MeraLib.entities.Book;
import com.Library.MeraLib.entities.Borrowers;
import com.Library.MeraLib.enums.Gender;
import com.Library.MeraLib.enums.LevelsOfBorrower;
import com.Library.MeraLib.repository.Library;
import com.Library.MeraLib.services.implementations.BorrowersServiceImpl;
import com.Library.MeraLib.services.implementations.LibrarianServicesImpl;

import javax.sound.midi.Soundbank;
import java.util.*;

public class MeraLibApplication {

	public static void main(String[] args) {

		Library library = new Library();

		//HashSet<Integer> hasing = new HashSet<>(100,1.23, 3.14, 1.1111.);

		//books in the library
		Book book = new Book("Arrow of the gods", "Chinua Achebe", "A010", 20);
		Book book2 = new Book("Without a silver spoon", "Andrew Okafor", "B020", 0);
		Book book3 = new Book("Chike goes to the river", "Sylvanus Mbah", "C030", 10);
		Book book4 = new Book("Harvest of corruption", "Theresa Mane", "D040", 5);
		Book book5 = new Book("Things fall apart", "Cyprian Ekwensi", "E050", 5);

		List<Book> createLibrary = new ArrayList<>();
		createLibrary.add(book);
		createLibrary.add(book2);
		createLibrary.add(book3);
		createLibrary.add(book4);
		createLibrary.add(book5);

		library.setBooksInLibrary(createLibrary);


		//List of people borrowing books

		Borrowers borrowers = new Borrowers("Daniel", Gender.MALE, "Without a silver spoon", LevelsOfBorrower.JUNIOR_STUDENT);
		//Borrowers borrowers2 = new Borrowers("Samuel", Gender.MALE, "Home Alone", LevelsOfBorrower.TEACHER);
		Borrowers borrowers2 = new Borrowers("Samuel", Gender.MALE, "Without a silver spoon", LevelsOfBorrower.TEACHER);
		Borrowers borrowers3 = new Borrowers("Esther", Gender.FEMALE, "Things fall apart", LevelsOfBorrower.JUNIOR_STUDENT);
		Borrowers borrowers4 = new Borrowers("John", Gender.MALE, "Harvest of corruption", LevelsOfBorrower.SENIOR_STUDENT);
		Borrowers borrowers5 = new Borrowers("Peter", Gender.MALE, "Come Along", LevelsOfBorrower.TEACHER);
		Borrowers borrowers6 = new Borrowers("Ruth", Gender.FEMALE, "Chike goes to the river", LevelsOfBorrower.SENIOR_STUDENT);
		Borrowers borrowers7 = new Borrowers("Naomi", Gender.FEMALE, "Akin the drummer", LevelsOfBorrower.SENIOR_STUDENT);


		BorrowersServiceImpl borrowersService = new BorrowersServiceImpl();
		borrowersService.addToQueue(borrowers, library);
		borrowersService.addToQueue(borrowers2, library);
		borrowersService.addToQueue(borrowers3, library);
		borrowersService.addToQueue(borrowers4, library);
		borrowersService.addToQueue(borrowers5, library);
		borrowersService.addToQueue(borrowers6, library);
		borrowersService.addToQueue(borrowers7, library);


		System.out.println(library.getQueueInLibrary());
		System.out.println("............................");

//       for loop to return data.
		LibrarianServicesImpl libraryImpl = new LibrarianServicesImpl();

		int sizeOfLibrary = library.getQueueInLibrary().size();
		for (int lib = 0; lib < sizeOfLibrary; lib++) {

			//System.out.println(libraryImpl.giveOutBooks(library));
			System.out.println(libraryImpl.givingOutBookOnPriority(library));

			library.getQueueInLibrary().poll();
		}

//		library.getQueueInLibrary()
//				.stream()
//				.forEach(b -> {
//					System.out.println(libraryImpl.giveOutBooks(library));
//					//System.out.println(libraryImpl.givingOutBookOnPriority(library));
//					library.getQueueInLibrary().poll();
//				});
	}
}











//		I SHOULD IMPLEMENT FOR EACH LOOP AND WHILE LOOP HERE TO GET ALL ELEMENTS IN THE QUEUE

//		PriorityQueue<Borrowers> priorityQueue = new PriorityQueue<>();
//		Iterator itr = priorityQueue.iterator();
//		while(itr.hasNext()){
//			System.out.println(itr.next());
//		}
//		for (Object element: priorityQueue) {
//			System.out.println(element);
//		}


