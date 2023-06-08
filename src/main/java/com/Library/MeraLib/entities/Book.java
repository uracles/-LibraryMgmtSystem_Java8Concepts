package com.Library.MeraLib.entities;


import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor

public class Book {
    private String bookTitle;
    private String bookAuthor;
    private String bookCatalogId;
    private int copiesOfBook;


}
