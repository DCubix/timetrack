package br.com.teknet.controller;

import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.teknet.dto.DTOCreateUser;
import br.com.teknet.model.User;
import br.com.teknet.repository.UserRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.AllArgsConstructor;

@ExecuteOn(TaskExecutors.IO)
@Controller("/users")
@AllArgsConstructor
public class UserController {
    
    private final UserRepository userRepository;

    @Post
    public HttpResponse<User> create(@Body @Valid DTOCreateUser data) {
        var res = userRepository.save(User.builder()
            .name(data.name())
            .email(data.email())
            .password(DigestUtils.md5Hex(data.password()).toUpperCase())
            .status("A")
            .build()
        );
        return HttpResponse.created(res);
    }

}
