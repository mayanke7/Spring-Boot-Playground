package com.mayanke7.SpringJpa.TestUtil;

import com.mayanke7.SpringJpa.domain.Author;
import com.mayanke7.SpringJpa.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class SampleClasses {

    public static Author createSampleAuthor(){
        return Author.builder()
                .email("abc@abc.com")
                .name("veda mosses")
                .build();
    }

    public static Book createSampleBook(final Author author){
        return Book.builder()
                .title("here i am")
                .isbn("ISBN546754634346546")
                .author(author)
                .build();
    }

    public static List<Author> createSampleAuthorList(){
        List<Author> authorList= new ArrayList<>();
        authorList.add(Author.builder()
                .email("abcd@abc.com")
                .name("vedad mosss")
                .build());
        authorList.add(Author.builder()
                .email("abce@abc.com")
                .name("vedae mosss")
                .build());
        authorList.add(Author.builder()
                .email("abcf@abc.com")
                .name("vedaf mosss")
                .build());

        return authorList;
    }
}
