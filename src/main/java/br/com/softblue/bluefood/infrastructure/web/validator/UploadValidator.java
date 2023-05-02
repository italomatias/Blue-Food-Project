package br.com.softblue.bluefood.infrastructure.web.validator;

import br.com.softblue.bluefood.util.Filetype;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class UploadValidator implements ConstraintValidator <UploadConstraint , MultipartFile> {

    private List<Filetype> acceptedFileTypes;

    @Override
    public void initialize(UploadConstraint constraintAnnotation) {
        acceptedFileTypes = Arrays.asList(constraintAnnotation.acceptedTypes());
    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
        if(multipartFile ==null){
            return true;
        }
        for (Filetype filetype  : acceptedFileTypes){
           if (filetype.sameOf(multipartFile.getContentType())){
               return true;
           }
        }
        return false;
    }

}
