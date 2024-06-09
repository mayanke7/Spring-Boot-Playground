package com.mayanke7.DAOApplication.dao.testSampleObj;

import com.mayanke7.DAOApplication.domain.Author;

public class AuthorSample {

    private AuthorSample(){

    }

    public static Author createSampleAuthor(){
        return Author.builder()
                .id(3L)
                .email("abc@abc.com")
                .name("veda mosss")
                .build();
    }
}
