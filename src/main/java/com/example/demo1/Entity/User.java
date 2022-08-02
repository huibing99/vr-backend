package com.example.demo1.Entity;

public class User {
    private String userName;
    private String jobNumber;
    private String password;

    public User() {
    }

    public User(String userName, String jobNumber, String password) {
        this.userName = userName;
        this.jobNumber = jobNumber;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
