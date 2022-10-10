package pl.niepracuj.exception.exceptions;

import pl.niepracuj.exception.messages.ExceptionMessages;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String userName) {

        super(String.format(ExceptionMessages.USER_FOR_PROVIDED_USERNAME_NOT_FOUND.getMessage(),userName));}
}
