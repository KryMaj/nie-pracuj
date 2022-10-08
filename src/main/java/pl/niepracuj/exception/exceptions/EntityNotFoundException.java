package pl.niepracuj.exception.exceptions;

import pl.niepracuj.exception.messages.ExceptionMessages;

public class EntityNotFoundException extends RuntimeException{


    public EntityNotFoundException(String entityName ,Long id) {

        super(String.format(ExceptionMessages.ENTITY_FOR_PROVIDED_ID_NOT_FOUND.getMessage(),entityName , id));
    }
}
