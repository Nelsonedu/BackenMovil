/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.backendmovil2.ws;

import com.mycompany.backendmovil2.dto.Inputs;
import com.mycompany.backendmovil2.model.Person;
import com.mycompany.backendmovil2.service.PersonService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author macbookpro
 */
@RestController
public class PersonWS {
    @Autowired
    private PersonService personService;
    
    
    @GetMapping(path = "persons")
    public ResponseEntity<List<Person>> getPerson(){
        return new ResponseEntity<>(personService.getPersons(),HttpStatus.OK);
    }
    
    
    
    @PostMapping(path="person",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPerson(@Valid @RequestBody Inputs inputs){
        Person person= personService.getPerson(inputs.getCedula());
        return new ResponseEntity<>(person,HttpStatus.OK);


    }
    
}
