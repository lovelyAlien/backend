package com.sparta.backend.controller;

import com.sparta.backend.dto.UserRequestDto;
import com.sparta.backend.model.User;
import com.sparta.backend.repository.UserRepository;
import com.sparta.backend.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SignupRestController {

    private final SignupService signupService;
    private final UserRepository userRepository;


    @PostMapping("/api/signup")
    public User createUser(@RequestBody UserRequestDto userRequestDto){
        User user = new User(userRequestDto);
        signupService.checkName(user);
        signupService.checkPassword(user);
        signupService.checkNameDuplication(user);
        return userRepository.save(user);

    }
}
