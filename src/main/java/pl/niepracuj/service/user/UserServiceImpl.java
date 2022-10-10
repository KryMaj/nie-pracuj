package pl.niepracuj.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.niepracuj.exception.exceptions.UserNotFoundException;
import pl.niepracuj.model.dto.UserDto;
import pl.niepracuj.model.entity.User;
import pl.niepracuj.model.mapper.UserMapper;
import pl.niepracuj.repository.UserRepository;
import pl.niepracuj.service.user.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDto getLoggedInUser() {

        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userMapper.toDto(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  userRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
    }
}
