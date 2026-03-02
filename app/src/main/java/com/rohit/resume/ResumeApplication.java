package com.rohit.resume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;
import java.util.List;

@SpringBootApplication
public class ResumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeApplication.class, args);
    }
}

/* ================================
   ENTITY
================================ */

@Entity
@Table(name = "profile")
class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "location")
    private String location;

    @Column(name = "summary", columnDefinition = "TEXT")
    private String summary;

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}

/* ================================
   REPOSITORY
================================ */

@Repository
interface ProfileRepository extends JpaRepository<Profile, Long> {
}

/* ================================
   CONTROLLER
================================ */

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "*")
class ProfileController {

    private final ProfileRepository repo;

    public ProfileController(ProfileRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Profile> getAllProfiles() {
        return repo.findAll();
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return repo.save(profile);
    }
}
