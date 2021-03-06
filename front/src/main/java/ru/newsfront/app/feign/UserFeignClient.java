package ru.newsfront.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.newsfront.app.model.User;

import java.util.List;
@FeignClient(name = "MSUser", value = "MSUser")
public interface UserFeignClient {
    @GetMapping("/")
    List<User> getUserList();
    @GetMapping("/find-by-login/{login}")
    User findByLogin(@PathVariable String login);

}
