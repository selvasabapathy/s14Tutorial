package com.sabapathy.tutorial.model;

public class Account {
    private String name;
    private String email;
    private String username;
    private String password;
    private String repassword;
    private String captcha;

    public Account() {
    }

    public Account(String name, String email, String username, String password, String repassword, String captcha) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.repassword = repassword;
        this.captcha = captcha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                ", captcha='" + captcha + '\'' +
                '}';
    }
}
