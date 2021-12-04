package ru.newsfront.app.config.security.auth;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.newsfront.app.feign.UserFeignClient;
import ru.newsfront.app.model.User;

@Service
@RequiredArgsConstructor
public class UserDeatilsServiceImpl implements UserDetailsService {
    private final UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByLogin(username);
        return AuthUser.fromUser(user);
    }
}

