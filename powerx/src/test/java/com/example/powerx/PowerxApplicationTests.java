package com.example.powerx;

import com.example.powerx.Dao.BookDao;
import com.example.powerx.Dao.PublisherDao;
import com.example.powerx.entity.Book;
import com.example.powerx.entity.Publisher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PowerxApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    private PublisherDao publisherDao;

    @Autowired
    private BookDao bookDao;

    @Test
    @Transactional
    @Rollback()
    public void init() {

        Book book1 = new Book("spring");
        Book book2 = new Book("mvc");
        Book book3 = new Book("mybatis");
        Publisher publisher = new Publisher("zhonghua");
        Set<Book> set = new HashSet<Book>();
        set.add(book1);
        set.add(book2);
        set.add(book3);
        publisher.setBooks(set);
        publisherDao.save(publisher);

    }

    @After
    public void clear() {
        publisherDao.deleteAll();
    }

    @Test
    public void find() {
        Publisher publisher = publisherDao.findByName("zhonghua");
        System.out.println(publisher);
    }

}
