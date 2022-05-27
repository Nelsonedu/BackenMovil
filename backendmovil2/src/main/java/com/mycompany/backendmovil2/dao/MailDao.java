/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.backendmovil2.dao;

import com.mycompany.backendmovil2.model.Direccion;
import com.mycompany.backendmovil2.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macbookpro
 */
@Repository
public interface MailDao extends JpaRepository<Mail, String> {
    
}
