package com.lotus.security.avatar.auth;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserDaoService {
    private final ApplicationUserDao applicationUserDao;

    @Autowired
    public ApplicationUserDaoService(ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    public Optional<UserDetails> getApplicationUser(String username){
        return applicationUserDao.getApplicationUserByName(username);
    }
}
