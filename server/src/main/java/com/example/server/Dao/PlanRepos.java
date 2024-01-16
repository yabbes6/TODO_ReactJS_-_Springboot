package com.example.server.Dao;

import com.example.server.POJO.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Repository
public interface PlanRepos extends JpaRepository<Plan,Integer> {

    /*@Transactional
    @Modifying
    Integer updatePlan (@RequestBody String comment, @Param("id") Integer id);*/

    //List<Plan> getAllPlan();


}
