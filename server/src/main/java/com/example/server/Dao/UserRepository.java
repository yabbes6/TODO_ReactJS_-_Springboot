package com.example.server.Dao;

import com.example.server.POJO.User;
import com.example.server.wrapper.UserMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmailId(@Param("email") String email);

    List<UserMapper> getAllUser();

    List<String> getAllAdmin();


   /* @Transactional
    @Modifying
    Integer updateStatus (@Param("status") String status,@Param("id") Integer id);*/

    User findByEmail(String email);
}
