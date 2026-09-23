package com.example.Task3.Authenticated.Book.Management.System.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Task3.Authenticated.Book.Management.System.Entity.MyUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<MyUser,Long> {


    Optional<MyUser> findByUsername(String username);

    @Transactional
    long deleteByUsername(String username);

    

}
