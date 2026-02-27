package com.rohit.resume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;
import java.util.List;

@SpringBootApplication
public class ResumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResumeApplication.class, args);
    }
}

// --- DATABASE MODEL ---
@Entity
@Table(name = "profiles")
class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String location;

    @Column(columnDefinition="TEXT")
    private String summary;

    // Getters and Setters (Required for Spring to handle data)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }
}

// --- DATABASE REPOSITORY ---
@Repository
interface ProfileRepository extends JpaRepository<Profile, Long> {
}

// --- API CONTROLLER ---
@RestController
@RequestMapping("/api/profile")
class ProfileController {

    @Autowired
    private ProfileRepository repo;

    @GetMapping
    public List<Profile> getAll() {
        return repo.findAll();
    }
}
