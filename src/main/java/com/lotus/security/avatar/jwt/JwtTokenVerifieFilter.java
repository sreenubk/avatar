package com.lotus.security.avatar.jwt;

import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtTokenVerifieFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if(Strings.isNullOrEmpty(authorizationHeader) || !authorizationHeader.startsWith("bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorizationHeader.replace("bearer", "");

        String key = "successsucesssucessdfhkdfhkdjshfksdhkhsfkhdskfhkhfskhsdkhkghks";
//
//        Jws<Claims>  claims = Jwts.parserBuilder()
//                .setSigningKey(Keys.hmacShaKeyFor(key.getBytes()))
//                 .build().parseClaimsJws(token);

        Jws<Claims>  claims = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(key.getBytes()))
                .parseClaimsJws(token);
        Claims body = claims.getBody();
        String username = body.getSubject();
        var authorities = (List<Map<String,String>>)body.get("authorities");

        Set<SimpleGrantedAuthority> grantedAuthorities = authorities.stream()
                .map(m -> new SimpleGrantedAuthority(m.get("authority"))).collect(Collectors.toSet());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                username,
                null,
                grantedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);


        filterChain.doFilter(request,response);

    }
}
