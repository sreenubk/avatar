package com.lotus.security.avatar.jwt;

public class ApplicationUserAndPasswordAuthentication {

    private String username;
    private String password;

    public ApplicationUserAndPasswordAuthentication() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
