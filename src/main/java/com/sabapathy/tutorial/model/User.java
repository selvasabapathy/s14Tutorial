package com.sabapathy.tutorial.model;

public class User {

    private String name;
    private String email;
    private String username;
    private String password;
    private String captcha;
    private boolean isAdmin;

    public User() {
    }

    public User(String name, String email, String username, String password, String captcha, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.captcha = captcha;
        this.isAdmin = isAdmin;
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

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", captcha='" + captcha + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
