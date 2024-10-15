package com.example.crud.service;

import com.example.crud.model.User;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 모든 사용자를 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 특정 ID로 사용자를 조회
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // 새로운 사용자를 생성
    public User createUser(User user) {
        return userRepository.save(user); // JPA save 메서드로 사용자 저장
    }

    // 기존 사용자를 업데이트
    public User updateUser(Long id, User userDetails) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(userDetails.getName()); // 이름 업데이트
            user.setEmail(userDetails.getEmail()); // 이메일 업데이트
            return userRepository.save(user); // 업데이트된 사용자 저장
        }
        return null; // 사용자가 없을 경우 null 반환
    }

    // 특정 ID의 사용자를 삭제
    public void deleteUser(Long id) {
        userRepository.deleteById(id); // JPA delete 메서드로 사용자 삭제
    }
}
