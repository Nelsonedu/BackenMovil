/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import com.mycompany.backendmovil2.Backendmovil2;
import com.mycompany.backendmovil2.dao.DirectionDao;
import com.mycompany.backendmovil2.dao.MailDao;
import com.mycompany.backendmovil2.dao.PersonDao;
import com.mycompany.backendmovil2.dao.PhoneDao;
import com.mycompany.backendmovil2.enums.EstadoCivil;
import com.mycompany.backendmovil2.enums.Sexo;
import com.mycompany.backendmovil2.model.Direccion;
import com.mycompany.backendmovil2.model.Mail;
import com.mycompany.backendmovil2.model.Person;
import com.mycompany.backendmovil2.model.Phone;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order.Direction;
import java.util.Calendar;
import org.hibernate.validator.constraints.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 *
 * @author macbookpro
 */
@SpringBootTest
@ContextConfiguration(classes = Backendmovil2.class)
public class Tests {
    
   @Autowired
   private PersonDao PersonDao;
   
   @Autowired
   private MailDao MailDao;
   
   @Autowired
   private PhoneDao PhoneDao;
   
   @Autowired
   private DirectionDao DirectionDao;
   
   
   @Test
   public void testing(){
       Calendar fecha = Calendar.getInstance();
       fecha.set(1981, 1, 1);
       
       Person persona = new Person();
       persona.setCedula("1900764897");
       persona.setNombre("Nelsiton Eduardo");
       persona.setFechaNacimiento(fecha.getTime());
       persona.setEstadoCivil(EstadoCivil.SOLTERO);
       persona.setSexo(Sexo.MASC);
       
       persona= PersonDao.save(persona);
       
       Phone phone = new Phone();
       phone.setPhone("09876543");
       phone.setPerson(persona);
       phone.setPerson(persona);
       
       phone= PhoneDao.save(phone);
       
       Mail mail = new Mail();
       mail.setMail("nelson@gmail.com");
       mail.setPerson(persona);
       mail= MailDao.save(mail);
       
       Direccion direction = new Direccion();
       
       direction.setDireccion("Dubai");
       direction.setPerson(persona);
       direction= DirectionDao.save(direction);
       
       
       
   }
}