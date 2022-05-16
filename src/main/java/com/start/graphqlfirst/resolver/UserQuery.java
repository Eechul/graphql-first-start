package com.start.graphqlfirst.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.start.graphqlfirst.entity.User;
import com.start.graphqlfirst.repository.UserRepository;
import com.start.graphqlfirst.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
@Transactional(readOnly = true)
public class UserQuery implements GraphQLQueryResolver {

    private final UserRepository userRepository;

    public User getUser(final long id) {
        if(id <= 0) {  return null; }

        return this.userRepository.getById(id);
    }
}
