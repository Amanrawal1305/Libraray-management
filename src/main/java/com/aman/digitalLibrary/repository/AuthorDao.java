//package com.aman.digitalLibrary.repository;
//
//import com.aman.digitalLibrary.modal.Author;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Repository
//public class authorDao {
//    @Autowired
//    static JdbcTemplate jdbcTemplate;
//
//    public static Author findAuthorById(String id) {
//        String query = "SELECT * FROM author WHERE AUTHOR_EMAIL='" + id;
//        Author res = jdbcTemplate.queryForObject(query, new RowMapper<Author>() {
//            @Override
//            public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Author author = new Author();
//                author.setName(rs.getString("AUTHOR_EMAIL"));
//                return author;
//            }
//        });
//        return res;
//    }
//    public static int createAuthor(Author author){
//        String query ="INSERT INTO author(AUTHOR_NAME,AUHTOR_EMAIL,AUTHOR_PHONE) VALUES (?,?,?)";
//        int row =jdbcTemplate.update(query,author.getName(),author.getEmail(),author.getPhoneNo());
//    }
//
//
//
//
//}
package com.aman.digitalLibrary.repository;

import com.aman.digitalLibrary.modal.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AuthorDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Author findAuthorById(String id) {
        String query = "SELECT * FROM author WHERE AUTHOR_EMAIL = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Author>() {
            @Override
            public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
                Author author = new Author();
                author.setName(rs.getString("AUTHOR_NAME"));
                author.setEmail(rs.getString("AUTHOR_EMAIL"));
                author.setPhoneNo(rs.getString("AUTHOR_PHONE"));
                return author;
            }
        });
    }

    public int createAuthor(Author author) {
        String query = "INSERT INTO author(AUTHOR_NAME, AUTHOR_EMAIL, AUTHOR_PHONE) VALUES (?,?,?)";
        return jdbcTemplate.update(query, author.getName(), author.getEmail(), author.getPhoneNo());
    }
}

