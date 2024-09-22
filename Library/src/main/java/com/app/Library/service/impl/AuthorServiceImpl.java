package com.app.Library.service.impl;

import com.app.Library.model.Author;
import com.app.Library.repo.AuthorRepo;
import com.app.Library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public void save(Author author) {
        authorRepo.save(author);
    }
}
