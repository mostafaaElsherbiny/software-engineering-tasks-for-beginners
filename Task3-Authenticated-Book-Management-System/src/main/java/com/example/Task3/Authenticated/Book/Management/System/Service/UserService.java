package com.example.Task3.Authenticated.Book.Management.System.Service;


import com.example.Task3.Authenticated.Book.Management.System.Entity.MyUser;
import com.example.Task3.Authenticated.Book.Management.System.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public MyUser createUser(String username, String password){
        MyUser user = new MyUser(username,password);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return user;
    }
    public MyUser updateUser(MyUser user){
        if(userRepo.exists(Example.of(user))){
            MyUser user1 = userRepo.findById(user.getId()).get();
            if(user.getEmail()!=null)
                user1.setEmail(user.getEmail());
            if(user.getFullname()!=null)
                user1.setFullname(user.getFullname());
            if(user.getPassword()!=null)
                user1.setPassword(user.getPassword());
            return userRepo.save(user1);
        }
        else return null;
    }





}
