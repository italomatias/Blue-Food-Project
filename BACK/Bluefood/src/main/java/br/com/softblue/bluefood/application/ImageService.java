package br.com.softblue.bluefood.application;

import br.com.softblue.bluefood.util.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Value("${bluefood.files.logotipo}")
    private String logostiposDir;
    public void uploadLogotipo(MultipartFile multipartFile , String fileName){

        try {
            IOUtils.copy(multipartFile.getInputStream(),fileName,logostiposDir);
        } catch (IOException e) {
           throw new AplicationServiceException(e);
        }

    }
}
