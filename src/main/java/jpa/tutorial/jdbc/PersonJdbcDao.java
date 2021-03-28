package jpa.tutorial.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Repository
public class PersonJdbcDao {

    @Autowired
    private JdbcTemplate connection;
    //select * from person
    public List<PersonJDBC> findAll(){
        return connection.query("select * from person_tutorial", new BeanPropertyRowMapper<>(PersonJDBC.class));
    }
    public Optional<PersonJDBC> findById(Long id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return connection.queryForObject(
                "select * from person_tutorial where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional
                                .of( new PersonJDBC(
                                        rs.getInt("id"),
                                        rs.getString("name"),
                                        rs.getString("location"),
                                        LocalDateTime.parse(rs.getString("birth_data"),formatter)
                                )
                        )
        );
    }
    public int deleteById(Long id) {
        return connection.update("delete from person_tutorial where id=?", new Object[] { id });
    }
    public int insert(PersonJDBC person) {
        return connection.update("insert into person_tutorial (id, name, location, birth_date) " + "values(?,  ?, ?, ?)",
                person.getId(),person.getName(),person.getLocation(),person.getBirth_data()
                );
    }

    public int update(PersonJDBC person) {
        return connection.update("update person " + " set name = ?, location = ?, birth_date = ? " + " where id = ?",
             person.getName(),person.getLocation(),person.getBirth_data(),   person.getId())
                ;
    }

}
