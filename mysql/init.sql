CREATE DATABASE IF NOT EXISTS resume_db;
USE resume_db;

CREATE TABLE IF NOT EXISTS profile (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(50), -- Added from Version 2
    location VARCHAR(255),
    summary TEXT
);

CREATE TABLE IF NOT EXISTS education ( -- Added from Version 2
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    degree VARCHAR(255),
    specialization VARCHAR(255),
    institution VARCHAR(255),
    year VARCHAR(50),
    profile_id BIGINT,
    FOREIGN KEY (profile_id) REFERENCES profile(id)
);

CREATE TABLE IF NOT EXISTS experience (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company VARCHAR(255),
    role VARCHAR(255),
    tenure VARCHAR(100),
    description TEXT,
    profile_id BIGINT,
    FOREIGN KEY (profile_id) REFERENCES profile(id)
);

CREATE TABLE IF NOT EXISTS projects ( -- Added from Version 2
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(255),
    description TEXT,
    technologies VARCHAR(255),
    duration VARCHAR(100),
    profile_id BIGINT,
    FOREIGN KEY (profile_id) REFERENCES profile(id)
);

-- Insert Professional Profile [cite: 5, 2, 7, 13]
INSERT INTO profile (full_name, email, phone, location, summary) 
VALUES ('Rohit Rawat', 'rawatrohit.wrk.25@gmail.com', '+91-XXXXXXXXXX', 'Ghaziabad, Uttar Pradesh, India', 
'DevOps Engineer with 10+ years of leadership experience, focused on Cloud Infrastructure, Automation, and CI/CD.');

-- Insert Professional Experience [cite: 20, 21, 22]
INSERT INTO experience (company, role, tenure, description, profile_id) 
VALUES ('Enveu', 'DevOps/Cloud Engineer (Trainee)', 'January 2026 - Present', 
'Implemented Jenkins Master-Agent architecture, Dockerized Java apps, and managed AWS infrastructure via Terraform.', 1);
