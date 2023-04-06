package com.controller;

import com.model.Smartphone;
import com.repository.ISmartRepository;
import com.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
@CrossOrigin("*")
public class SmartphoneController {
    @Autowired
    private ISmartPhoneService smartPhoneService;
    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(smartPhoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhone(){
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> findSmartphoneById(@PathVariable Long id){
        Optional<Smartphone> smartphone = smartPhoneService.findById(id);
        return smartphone.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> updateSmartphone(@PathVariable Long id, @RequestBody Smartphone smartphone){
        Optional<Smartphone> smartphoneOptional = smartPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            smartphone.setId(smartphoneOptional.get().getId());
            return new ResponseEntity<>(smartPhoneService.save(smartphone), HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartPhone(@PathVariable Long id){
        Optional<Smartphone> smartphoneOptional = smartPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            smartPhoneService.remove(id);
            return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
        }
    }
}
