package net.javaSpring.springBoot.model.entity;

// import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
  
    @Column(unique = true, nullable = false)
    private String email;
  
    @Column(nullable = false)
    private String password;
  
    private LocalDateTime createdAt = LocalDateTime.now();
    private boolean isDeleted = false;

    // Constructor
    public User(String email, String password) {
      this.email = email;
      this.password = password;
    }
    
}