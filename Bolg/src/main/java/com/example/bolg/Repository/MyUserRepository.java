package com.example.bolg.Repository;

import com.example.bolg.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository <MyUser , Integer> {

    MyUser findMyUserByUsername(String username);
    MyUser findMyUserById(Integer id);
}
