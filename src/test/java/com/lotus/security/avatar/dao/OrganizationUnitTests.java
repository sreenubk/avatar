package com.lotus.security.avatar.dao;

import com.lotus.security.avatar.model.AuthorizationGroup;
import com.lotus.security.avatar.model.OrganizationUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class OrganizationUnitTests {

    @Autowired
    private OrganizationRepository dao;

    @Test
    public void save(){

        OrganizationUnit ou = new OrganizationUnit();
        ou.setComments("Hello Hello");
        AuthorizationGroup ag = new AuthorizationGroup();
        ag.setAuthGroupName("SINU GRP");
        ou.setAuthorizationGroups(Set.of(ag));
        OrganizationUnit nou = dao.save(ou);

        assertNotNull(dao.findById(ou.getorganizationUnitid()));
        System.out.println(dao.findById(ou.getorganizationUnitid()));

//        assertNotNull(nou.getorganizationUnitid());
    }


}
