package com.lotus.security.avatar.cotroller;

import com.lotus.security.avatar.dao.OrganizationRepository;
import com.lotus.security.avatar.model.OrganizationUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationUnitController {

    @Autowired
    OrganizationRepository repository;

    @GetMapping("/{organizationId}")
    public Optional<OrganizationUnit> getOrganization(@RequestParam(required = true, defaultValue = "1.0") BigDecimal organizationId){
        return repository.findById(organizationId).stream().findFirst();
    }

    @GetMapping("path=hello/{organizationId}")
    public String getMessage(@PathVariable("organizationId") BigDecimal organizationId){
        return organizationId.toString();
    }

    @PostMapping("path=hello/{organizationId}")
    public HttpStatus create(@PathVariable("organizationId") BigDecimal organizationId){
        System.out.println(String.format("Created Oragization:%s",organizationId));
        return HttpStatus.OK;
    }

    @PutMapping("path=hello/{organizationId}")
    public HttpStatus update(@PathVariable("organizationId") BigDecimal organizationId){
        System.out.println(String.format("Updated Oragization:%s",organizationId));
        return HttpStatus.OK;
    }

    @DeleteMapping("path=hello/{organizationId}")
    public HttpStatus deleted(@PathVariable("organizationId") BigDecimal organizationId){
        System.out.println(String.format("Updated Oragization:%s",organizationId));
        return HttpStatus.OK;
    }

}
