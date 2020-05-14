package com.example.demo.form;

public class UserRegisterForm {

    private String login;
    private String password;
    private String repeatedPassword;
    private String userName;

    @Override
    public String toString() {
        return "UserRegisterForm{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", repeatedPassword='" + repeatedPassword + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
