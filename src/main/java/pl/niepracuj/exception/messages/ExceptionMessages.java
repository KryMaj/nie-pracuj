package pl.niepracuj.exception.messages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessages {

    ENTITY_FOR_PROVIDED_ID_NOT_FOUND("Encja %s dla podanego id:%s nie istnieje"),
    USER_FOR_PROVIDED_USERNAME_NOT_FOUND("Uzytkownik %s nie istnieje");

    private final String message;

}
