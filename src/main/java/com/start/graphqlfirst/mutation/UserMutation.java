package com.start.graphqlfirst.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.start.graphqlfirst.dto.UserDto;
import com.start.graphqlfirst.entity.User;
import com.start.graphqlfirst.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
@Transactional(readOnly = true)
public class UserMutation implements GraphQLMutationResolver {

    private final UserRepository userRepository;

    public User createUser(UserDto userDto) {
        User save = new User();
        save.setName(userDto.getName());
        User user = userRepository.save(save);
        return user;
    }

}
