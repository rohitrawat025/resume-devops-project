package com.rohit.resume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResumeApplication.class, args);
    }
}

@Entity
public class Profile {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String fullName;
 private String email;
 private String phone;
 private String location;

 @Column(columnDefinition="TEXT")
 private String summary;
}

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

 @Autowired
 private ProfileRepository repo;

 @GetMapping
 public List<Profile> getAll() {
     return repo.findAll();
 }
}

spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
server.port=8080
