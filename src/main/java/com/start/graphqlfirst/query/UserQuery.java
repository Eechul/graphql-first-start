package com.start.graphqlfirst.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.start.graphqlfirst.entity.User;
import com.start.graphqlfirst.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
@Transactional(readOnly = true)
public class UserQuery implements GraphQLQueryResolver {

    private final UserRepository userRepository;

    public List<User> users() {
        return this.userRepository.findAll();
    }

    public User getUser(final Long id) {
        return this.userRepository.findById(id).orElse(null);
    }


}
