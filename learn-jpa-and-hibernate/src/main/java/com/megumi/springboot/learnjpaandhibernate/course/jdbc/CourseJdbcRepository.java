package com.megumi.springboot.learnjpaandhibernate.course.jdbc;

import com.megumi.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CourseJdbcRepository {

    private static String INSERT_QUERY =
            """
                INSERT INTO COURSE (id, name, author)
                values(?, ?, ?);        
            """;

    private static String DELETE_QUERY =
            """
                DELETE FROM COURSE
                WHERE id = ?
            """;

    private static String SELECT_QUERY =
            """
                SELECT * FROM COURSE
                WHERE id = ?
            """;

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id){
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    // ResultSet -> Bean -> RowMapper
    public Course findById(long id){
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
