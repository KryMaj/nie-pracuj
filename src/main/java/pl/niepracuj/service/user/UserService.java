package pl.niepracuj.service.user;

import pl.niepracuj.model.dto.UserDto;
import pl.niepracuj.model.entity.User;

public interface UserService {

    UserDto getLoggedInUser();
}
