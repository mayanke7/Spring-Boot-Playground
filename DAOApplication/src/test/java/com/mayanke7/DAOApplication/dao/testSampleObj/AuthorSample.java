package com.mayanke7.DAOApplication.dao.testSampleObj;

import com.mayanke7.DAOApplication.domain.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorSample {

    private AuthorSample(){

    }

    public static Author createSampleAuthor(){
        return Author.builder()
                .id(11L)
                .email("abc@abc.com")
                .name("veda mosss")
                .build();
    }

    public static List<Author> createSampleAuthorList(){
        List<Author> authorList= new ArrayList<>();
        authorList.add(Author.builder()
                .id(4L)
                .email("abcd@abc.com")
                .name("vedad mosss")
                .build());
        authorList.add(Author.builder()
                .id(5L)
                .email("abce@abc.com")
                .name("vedae mosss")
                .build());
        authorList.add(Author.builder()
                .id(6L)
                .email("abcf@abc.com")
                .name("vedaf mosss")
                .build());

        return authorList;
    }
}
