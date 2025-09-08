package com.aman.digitalLibrary.repository;

import com.aman.digitalLibrary.modal.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int findBookById(String id) {
        int bookId = Integer.parseInt(id);
        String query = "SELECT BOOK_ID FROM book where BOOK_ID=?";
        int row = jdbcTemplate.queryForObject(query, Integer.class, bookId);
        return row;
    }

    public int createBookInDatabase(String bookId, String bookName, String bookType, String authorId) {
        int bookInt = Integer.parseInt(bookId);
        String query = "INSERT INTO book(BOOK_ID,BOOK_NAME,BOOK_TYPE,AUTHOR_ID)VALUES(?,?,?,?)";
        int row = jdbcTemplate.update(query, bookId, bookName, bookType, authorId);
        return row;
    }

    public Book findBookById(int id) {
        String query = "SELECT * FROM book WHERE BOOK_ID=?";
        Book book = jdbcTemplate.queryForObject(query, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book b = new Book();
                b.setBookName(rs.getString("BOOK_NAME"));
                return b;
            }
        });
        return book;
    }
}