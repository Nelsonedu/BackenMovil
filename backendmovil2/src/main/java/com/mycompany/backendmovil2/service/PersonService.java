/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.backendmovil2.service;

import com.mycompany.backendmovil2.dao.PersonDao;
import com.mycompany.backendmovil2.model.Person;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookpro
 */
@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonDao personRepository;
    
    public List<Person> getPersons(){
       return  personRepository.findAll();
        
    }
public Person getPerson(String cedula){
    return personRepository.getById(cedula);
}
    
    
}
