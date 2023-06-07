package com.example.bolg.Service;


import com.example.bolg.Model.MyUser;
import com.example.bolg.Repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserRepository.findMyUserByUsername(username);
        if (myUser == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return myUser;
    }
    }
