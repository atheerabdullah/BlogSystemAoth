package com.example.bolg.Controller;

import com.example.bolg.Model.MyUser;
import com.example.bolg.Service.AuthMyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class MyUserController {


    private final AuthMyUserService authMyUserService;

    @GetMapping("/getUsers")
    private ResponseEntity AllUsers() {
        List<MyUser> AllUsers = authMyUserService.getAllUsers();
        return ResponseEntity.status(200).body(AllUsers);
    }

    @PostMapping("/registerForUser")
    public ResponseEntity register(@RequestBody MyUser myUser) {
        authMyUserService.register(myUser);
        return ResponseEntity.status(200).body("User Register");
    }

    @PostMapping("/getUserBy/{id}")
        public ResponseEntity getBlogByUser(@PathVariable Integer id){
            authMyUserService.getBlogByUser(id);
            return ResponseEntity.status(200).body("User founded");
        }

    }
