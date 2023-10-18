package com.workintech.zoo.zooOrganization.exceptions;

import com.workintech.zoo.zooOrganization.entity.Koala;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class KoalaValidation {
    public static void isKoalaIdNotValid(int id) {
        if (id <= 0) {
            throw new KoalaException("This id is not valid : " + id, HttpStatus.BAD_REQUEST);
        }
    }
    public static void isKoalaNotExist(Map<Integer , Koala> koalas ,int id){
        if(!koalas.containsKey(id)){
            throw new KoalaException("Koala which is given id is not exist : " + id , HttpStatus.NOT_FOUND);
        }
    }
    public static void isKoalaExist(Map<Integer, Koala> koalas, int id){
        if(koalas.containsKey(id)){
            throw new KoalaException("Koala with given id is already exist: " + id,
                    HttpStatus.BAD_REQUEST);
        }
    }

    public static void isKoalaCredentialsValid(Koala koala){
        if((koala.getName() == null || koala.getName().isEmpty()) ||
                koala.getGender() == null || koala.getGender().isEmpty()) {
            throw new KoalaException("Koala credentials are not valid. Please check name and gender",
                    HttpStatus.BAD_REQUEST);
        }
    }

}
