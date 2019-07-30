package com.leanokhttpmockserver.domain;


public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String uniqueId;

    public User(Integer id, String name, Integer age, String uniqueId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.uniqueId = uniqueId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
