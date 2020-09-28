package com.lotus.security.avatar.auth;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.Set.of;

@Repository
public class ApplicationUserDaoImpl implements ApplicationUserDao {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationUserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<UserDetails> getApplicationUserByName(String username) {

         return getApplicationUsers().stream().filter(userDetail -> username.equals(userDetail.getUsername())).findFirst();
    }

    private Set<UserDetails> getApplicationUsers(){

        Set<UserDetails> userDetails = Sets.newHashSet(
                new ApplicationUser(SecurityRoles.ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "srinivasaBokka",
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(SecurityRoles.STUDENT.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "meenaBokka",
                        true,
                        true,
                        true,
                         true),
                new ApplicationUser(SecurityRoles.OPT.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "anishBokka",
                        true,
                        true,
                        true,
                        true)
        );
        return userDetails;
     }
}
