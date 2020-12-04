package com.lotus.security.avatar.sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestPerson {


    @Test
    public void    testPerson(){
        Person person = new Person("SINU", "srini@yahoo.com");
        String email =        person.getEmail().map(String :: trim).get();

        assertEquals("srini@yahoo.com", email);
    }
}
