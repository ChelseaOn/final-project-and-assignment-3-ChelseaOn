package com.example.Onyeokeziri_Phase2.Models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.Email = ?1")
    public User findByEmail(String Email);
}
