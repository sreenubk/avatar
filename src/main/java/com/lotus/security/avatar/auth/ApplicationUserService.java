package com.lotus.security.avatar.auth;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserDao applicationUserDao;

    @Autowired
    public ApplicationUserService(ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return applicationUserDao.getApplicationUserByName(s).orElseThrow( () -> new UsernameNotFoundException(String.format("User name :%s not found", s)));
    }
}
