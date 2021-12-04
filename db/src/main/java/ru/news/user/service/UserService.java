package ru.news.user.service;

import ru.news.user.model.User;

import java.util.Optional;

public interface UserService extends MyNewsService<User, Long> {
    User findByLogin(String login);
}

