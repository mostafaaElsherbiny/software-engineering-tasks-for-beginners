package com.example.Task3.Authenticated.Book.Management.System.Service;


import com.example.Task3.Authenticated.Book.Management.System.Entity.MyUser;
import com.example.Task3.Authenticated.Book.Management.System.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
                user1.setPassword(passwordEncoder.encode(user.getPassword()));
            if(user.getRoles()!=null)
                user1.setRoles(user.getRoles());

            return userRepo.save(user1);
        }
        else return null;
    }


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        MyUser user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(String.valueOf(user.getRoles()))
                .build();
    }
    public List<MyUser> findAllUsers(){
        return userRepo.findAll();
    }
    public MyUser findById(Long id){
        return userRepo.findById(id).get();
    }
    public MyUser findByUsername(String username){
        return userRepo.findByUsername(username).get();
    }
    public Long deleteByUsername(String username){
        return userRepo.deleteByUsername(username);
    }
    public void deleteById(Long id){
         userRepo.deleteById(id);
    }
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<MyUser> user = userRepo.findByUsername(username);
//        if(user.isPresent()){
//            MyUser userObj = user.get();
//            System.out.println("USERNAME FROM LOGIN: " + username);
//            System.out.println("DB PASSWORD: " +userObj.getPassword());
//            return User.builder()
//                    .username(userObj.getUsername())
//                    .password(userObj.getPassword())
//                    .roles(userObj.getRoles().toArray(new String[0]))
//                    .build();
//        }
//        else throw new UsernameNotFoundException(username);
//    }
    	private static List<GrantedAuthority> getAuthorities(MyUser user) {

		List<GrantedAuthority> authorities = new ArrayList<>();

		 if(!user.getRoles().isEmpty()) {
		        	user.getRoles().forEach(role -> {
		        		authorities.add(new SimpleGrantedAuthority(role));
		        	});
		        }
		     return authorities;
		}
}
