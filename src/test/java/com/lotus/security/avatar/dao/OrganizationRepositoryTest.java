package com.lotus.security.avatar.dao;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class OrganizationRepositoryTest {

    @Autowired
    private OrganizationRepository organizationRepository;

    public void testSave(){



    }

}