package com.example.crud.repository;

import com.example.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 이 인터페이스가 JPA 리포지토리임을 나타냄
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository를 확장하여 기본적인 CRUD 메서드를 제공
}
