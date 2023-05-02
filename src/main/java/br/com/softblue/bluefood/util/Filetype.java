package br.com.softblue.bluefood.util;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Filetype {

    PNG("image/png","png"),
    JPEG("image/jpeg","jpg");

    String mimeType;
    String extension;

    Filetype(String mimeType , String extension){
        this.mimeType = mimeType;
        this.extension = extension;
    }
    public boolean sameOf(String mimeType){
        return this.mimeType.equalsIgnoreCase(mimeType);
    }

    public static Filetype of(String mimeType){
        for (Filetype filetype : values()){
            if (filetype.sameOf(mimeType)){
                return filetype;
            }
        }
        return null;
    }
}
