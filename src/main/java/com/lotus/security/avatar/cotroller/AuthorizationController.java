package com.lotus.security.avatar.cotroller;

import com.lotus.security.avatar.dao.AuthorizationRepository;
import com.lotus.security.avatar.model.AuthorizationGroup;
import org.apache.tomcat.util.http.parser.Authorization;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/auth/")
public class AuthorizationController {


    @Autowired
    private AuthorizationRepository authorizationRepository;

    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('read')")
    public Optional<AuthorizationGroup> getAuthorization(@RequestParam(required = true, defaultValue = "1.0") BigDecimal authorizationgroupid){

        return authorizationRepository.findById(authorizationgroupid).stream().findFirst();
    }

    @PostMapping
//        @PreAuthorize("hasAuthority('write')")
    public HttpStatus create(@RequestBody AuthorizationGroup authorizationGroup){
        System.out.println(String.format("Created Organization:%s", authorizationGroup.getAuthGroupName()));
        return HttpStatus.OK;
    }

    @PutMapping
//    @PreAuthorize("hasAuthority('update')")
    public HttpStatus update(@RequestBody AuthorizationGroup authorizationGroup){
        System.out.println(String.format("Updated Organization:%s", authorizationGroup.getAuthGroupName()));
        return HttpStatus.OK;
    }
    @DeleteMapping
//    @PreAuthorize("hasAuthority('delete')")
    public HttpStatus delete(@RequestBody AuthorizationGroup authorizationGroup){
        System.out.println(String.format("Deleted Organization:%s", authorizationGroup.getAuthGroupName()));
        return HttpStatus.OK;
    }


}
