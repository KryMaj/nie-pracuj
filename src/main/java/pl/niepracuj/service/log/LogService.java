package pl.niepracuj.service.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import pl.niepracuj.model.dto.LogDto;

import java.io.IOException;

public interface LogService {

    void sendLog(LogDto logDto) throws IOException, InterruptedException;
}
