package com.workintech.zoo.zooOrganization.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kangaroo {
    private int id;
    private String name;
    private int weight;
    private int sleepHour;
    private String gender;
    private boolean isAggressive;
}
