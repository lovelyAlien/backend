package com.sparta.backend.model;

import com.sparta.backend.dto.UserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class User extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String passwordNen;

    @Column(nullable = false)
    private String passwordConfirm;

    public User(UserRequestDto userRequestDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); //암호화

        this.username = userRequestDto.getUsername();
        this.password = encoder.encode(userRequestDto.getPassword());
        this.passwordNen = userRequestDto.getPasswordNen();
        this.passwordConfirm = userRequestDto.getPasswordConfirm();

    }
}