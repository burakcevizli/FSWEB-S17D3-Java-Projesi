package com.workintech.zoo.zooOrganization.exceptions;

import com.workintech.zoo.zooOrganization.entity.Kangaroo;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class KangarooValidation {
    public static void isKangarooIdNotValid(int id) {
        if (id <= 0) {
            throw new KangarooException("This id is not valid : " + id, HttpStatus.BAD_REQUEST);
        }
    }
    public static void isKangarooNotExist(Map<Integer , Kangaroo> kangaroos ,int id){
        if(!kangaroos.containsKey(id)){
            throw new KangarooException("Kangaroo which is given id is not exist : " + id , HttpStatus.NOT_FOUND);
        }
    }
    public static void isKangarooExist(Map<Integer, Kangaroo> kangaroos, int id){
        if(kangaroos.containsKey(id)){
            throw new KangarooException("Kangaroo with given id is already exist: " + id,
                    HttpStatus.BAD_REQUEST);
        }
    }

    public static void isKangarooCredentialsValid(Kangaroo kangaroo){
        if((kangaroo.getName() == null || kangaroo.getName().isEmpty()) ||
                kangaroo.getGender() == null || kangaroo.getGender().isEmpty()) {
            throw new KangarooException("Kangaroo credentials are not valid. Please check name and gender",
                    HttpStatus.BAD_REQUEST);
        }
    }

}
