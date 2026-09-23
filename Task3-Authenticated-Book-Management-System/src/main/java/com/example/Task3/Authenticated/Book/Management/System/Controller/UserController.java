package com.example.Task3.Authenticated.Book.Management.System.Controller;

import com.example.Task3.Authenticated.Book.Management.System.Entity.MyUser;
import com.example.Task3.Authenticated.Book.Management.System.JWT.JwtService;
import com.example.Task3.Authenticated.Book.Management.System.Service.MyUserDetailsService;
import com.example.Task3.Authenticated.Book.Management.System.DTOs.UserLoginDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;


    @Autowired
    MyUserDetailsService myUserDetailsService;

    @PostMapping("/register")
    public ResponseEntity<MyUser> insertUser(@Valid @RequestBody  UserLoginDto user){
        user.setPassword(user.getPassword());
        return new ResponseEntity<>(myUserDetailsService.createUser(user.getUsername(), user.getPassword()), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> logInUser(@Valid @RequestBody UserLoginDto user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return ResponseEntity.ok(jwtService.generateToken(userDetails));
        }
        else throw new UsernameNotFoundException("Invalid Credentials");

    }
    @GetMapping()
    public ResponseEntity<List<MyUser>> findAllUsers() {
        return ResponseEntity.ok(myUserDetailsService.findAllUsers());
    }
    @GetMapping("findById/{id}")
    public ResponseEntity<MyUser> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(myUserDetailsService.findById(id));
    }
    @GetMapping("findByUsername/{username}")
    public ResponseEntity<MyUser> findUserByUsername(String username) {
        return ResponseEntity.ok(myUserDetailsService.findByUsername(username));
    }

    @DeleteMapping("/deleteByUsername/{username}")
    public ResponseEntity<Long> deleteUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(myUserDetailsService.deleteByUsername(username));
    }
    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Long> deleteUserById(@PathVariable Long id){
        myUserDetailsService.deleteById(id);
        return ResponseEntity.ok(1L);
    }

}
