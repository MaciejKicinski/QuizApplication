package com.example.demo.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "user")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String login;
    @NonNull
    private String password;

    private LocalDateTime lastLoginDate;


}

