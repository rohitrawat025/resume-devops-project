package com.rohit.resume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;
import java.util.List;

@SpringBootApplication
public class ResumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResumeApplication.class, args);
    }
}

@Entity
@Table(name = "profile")
class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "full_name")
    private String fullName;
    private String email;
    private String phone; // Added from Version 2
    private String location;
    
    @Column(columnDefinition = "TEXT")
    private String summary;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private List<Experience> experiences;

    // Getters and Setters
    public Long getId() { return id; }
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
    public List<Experience> getExperiences() { return experiences; }
    public void setExperiences(List<Experience> experiences) { this.experiences = experiences; }
}

@Entity
class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String role;
    private String tenure;
    @Column(columnDefinition = "TEXT")
    private String description;

    // Getters and Setters
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getTenure() { return tenure; }
    public void setTenure(String tenure) { this.tenure = tenure; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

@Repository
interface ProfileRepository extends JpaRepository<Profile, Long> {}

@RestController
@RequestMapping("/app") // Kept Version 1 Path
@CrossOrigin(origins = "*")
class ProfileController {
    private final ProfileRepository repo;
    public ProfileController(ProfileRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Profile> getProfile() {
        return repo.findAll();
    }

    @PostMapping // Added from Version 2
    public Profile createProfile(@RequestBody Profile profile) {
        return repo.save(profile);
    }
}
