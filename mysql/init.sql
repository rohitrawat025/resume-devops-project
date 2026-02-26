CREATE DATABASE resume_db;
USE resume_db;

CREATE TABLE profile (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(50),
    location VARCHAR(255),
    summary TEXT
);

CREATE TABLE education (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    degree VARCHAR(255),
    specialization VARCHAR(255),
    institution VARCHAR(255),
    year VARCHAR(50),
    profile_id BIGINT,
    FOREIGN KEY (profile_id) REFERENCES profile(id)
);

CREATE TABLE experience (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company VARCHAR(255),
    role VARCHAR(255),
    tenure VARCHAR(100),
    description TEXT,
    profile_id BIGINT,
    FOREIGN KEY (profile_id) REFERENCES profile(id)
);

CREATE TABLE projects (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(255),
    description TEXT,
    technologies VARCHAR(255),
    duration VARCHAR(100),
    profile_id BIGINT,
    FOREIGN KEY (profile_id) REFERENCES profile(id)
);
