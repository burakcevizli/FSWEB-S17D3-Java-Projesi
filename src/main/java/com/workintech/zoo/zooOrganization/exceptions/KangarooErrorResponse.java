package com.workintech.zoo.zooOrganization.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KangarooErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

}
