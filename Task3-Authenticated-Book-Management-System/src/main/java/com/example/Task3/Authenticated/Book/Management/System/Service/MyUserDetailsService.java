package com.example.Task3.Authenticated.Book.Management.System.Service;

import com.example.Task3.Authenticated.Book.Management.System.Entity.MyUser;
import com.example.Task3.Authenticated.Book.Management.System.Repository.UserRepo;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.apache.catalina.realm.UserDatabaseRealm.getRoles;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = userRepo.findByUsername(username);
        if(user.isPresent()){
            MyUser userObj = user.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(userObj.getRoles().toArray(new String[0]))
                    .build();
        }
        else throw new UsernameNotFoundException(username);
    }
}
