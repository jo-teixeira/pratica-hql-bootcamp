package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u")
    List<User> findAllUsers();

    @Query("select u from User u where u.userName like concat('%', :name, '%') order by u.userName")
    List<User> findUserByUserName(@Param("name") String name);

    @Query("select u from User u where u.id = :id")
    User findUserById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("delete from User u where u.id = :id")
    void deleteUser(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update User u set u.password = :password where u.id = :id")
    void updateUserByPass(@Param("id") Long id, @Param("password") String password);
}



