package pl.niepracuj.service.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Service
public class FileServiceImpl implements FileService {

    @Value("${filepath}")
            private String path;

    @Override
    public String saveFile(MultipartFile file) throws IOException {
        File file1 =  new File(path + file.getOriginalFilename());
        file.transferTo(file1);
        return file1.getPath();
    }
}
