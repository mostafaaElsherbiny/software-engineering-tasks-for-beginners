package com.example.Task3.Authenticated.Book.Management.System.Controller;

import com.example.Task3.Authenticated.Book.Management.System.Entity.MyUser;
import com.example.Task3.Authenticated.Book.Management.System.JWT.JwtService;
import com.example.Task3.Authenticated.Book.Management.System.Service.MyUserDetailsService;
import com.example.Task3.Authenticated.Book.Management.System.Service.UserService;
import com.example.Task3.Authenticated.Book.Management.System.UserLoginDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @PostMapping("/register")
    public ResponseEntity<MyUser> insertUser(@Valid @RequestBody  UserLoginDto user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<>(userService.createUser(user.getUsername(), user.getPassword()), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> logInUser(@Valid @RequestBody UserLoginDto user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return new ResponseEntity<>(jwtService.generateToken(myUserDetailsService.loadUserByUsername(user.getUsername())),HttpStatus.ACCEPTED);
        }
        else throw new UsernameNotFoundException("Invalid Credentials");

    }

}
