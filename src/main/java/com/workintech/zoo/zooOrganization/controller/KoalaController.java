package com.workintech.zoo.zooOrganization.controller;


import com.workintech.zoo.zooOrganization.entity.Kangaroo;
import com.workintech.zoo.zooOrganization.entity.Koala;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
@Slf4j
public class KoalaController {
    private Map<Integer, Koala> koalaList;

    @PostConstruct
    public void init(){
        koalaList = new HashMap<>();
        koalaList.put(1, new Koala(1,"Mahmut",50,11,"Male"));
        log.info("Calısıyor Koala.");
    }

    @GetMapping("/")
    public List<Koala> getAll(){
        return koalaList.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Koala getOne(@PathVariable int id){
        return koalaList.get(id);
    }
    @PostMapping("/")
    public Koala save(@RequestBody Koala koala){
        koalaList.put(koala.getId(), koala);
        return koala;
    }
    @PutMapping("/{id}")
    public Koala update(@PathVariable int id , @RequestBody Koala koala){
        if(koalaList.containsKey(id)){
            koalaList.put(id,koala);
        }
        return koala;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        koalaList.remove(id);
    }
}
