package com.workintech.zoo.zooOrganization.controller;
import com.workintech.zoo.zooOrganization.entity.Kangaroo;
import com.workintech.zoo.zooOrganization.exceptions.KangarooValidation;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
@Slf4j
public class KangarooController {
    private Map<Integer, Kangaroo> kangaroosList;

    @PostConstruct
    public void init(){
        kangaroosList = new HashMap<>();
        kangaroosList.put(1, new Kangaroo(1,"Süleyman",40,10,"Male",true));
        log.info("Calısıyor.");
    }

    @GetMapping("/")
    public List<Kangaroo> getAll(){
        return kangaroosList.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Kangaroo getOne(@PathVariable int id){
        KangarooValidation.isKangarooIdNotValid(id);
        KangarooValidation.isKangarooNotExist(kangaroosList,id);
        return kangaroosList.get(id);
    }
    @PostMapping("/")
    public Kangaroo save(@RequestBody Kangaroo kangaroo){
        KangarooValidation.isKangarooExist(kangaroosList, kangaroo.getId());
        KangarooValidation.isKangarooCredentialsValid(kangaroo);
        kangaroosList.put(kangaroo.getId(), kangaroo);
        return kangaroosList.get(kangaroo.getId());
    }
    @PutMapping("/{id}")
    public Kangaroo update(@PathVariable int id , @RequestBody Kangaroo kangaroo){
        if(kangaroosList.containsKey(id)){
            kangaroosList.put(id,kangaroo);
        }
        return kangaroosList.get(kangaroo.getId());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        kangaroosList.remove(id);
    }

}
