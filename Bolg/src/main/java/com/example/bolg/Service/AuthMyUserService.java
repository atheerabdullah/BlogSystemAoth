package com.example.bolg.Service;


import com.example.bolg.Model.Blog;
import com.example.bolg.Model.MyUser;
import com.example.bolg.Repository.BlogRepository;
import com.example.bolg.Repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthMyUserService {


    private final MyUserRepository myUserRepository;
    private final BlogRepository blogRepository;

    public List<MyUser> getAllUsers(){
        List<MyUser> AllUsers=  myUserRepository.findAll();
        return AllUsers;
    }

    public void register(MyUser myUser){
        String hash=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hash);
        myUserRepository.save(myUser);
    }
    public  List<Blog> getBlogByUser(Integer id){
        return blogRepository.findBlogsByUserId(id);
    }

}
