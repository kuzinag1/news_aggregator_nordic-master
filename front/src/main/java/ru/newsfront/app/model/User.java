package ru.newsfront.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.newsfront.app.config.security.Role;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String login;
    private String password;
    private Boolean isActive;
    private Boolean accountNonLocked;
    private Role role;
}
