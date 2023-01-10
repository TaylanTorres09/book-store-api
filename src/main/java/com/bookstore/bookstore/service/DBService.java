package com.bookstore.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.models.Book;
import com.bookstore.bookstore.models.Category;
import com.bookstore.bookstore.repositories.BookRepository;
import com.bookstore.bookstore.repositories.CategoryRepository;

@Service
public class DBService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;
    
    public void instatiateDataBase() {
        Category cat1 = new Category(null, "Informática", "Books de TI");
        Category cat2 = new Category(null, "Ficcção Científica", "Ficcção científica");
        Category cat3 = new Category(null, "Biografias", "Books de Biografias");
                
        Book l1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
        Book l2 = new Book(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
        Book l3 = new Book(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
        Book l4 = new Book(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", cat2);
        Book l5 = new Book(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);
                
        cat1.getBooks().addAll(Arrays.asList(l1, l2));
        cat2.getBooks().addAll(Arrays.asList(l3, l4, l5));
                
        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.bookRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
    }

}
