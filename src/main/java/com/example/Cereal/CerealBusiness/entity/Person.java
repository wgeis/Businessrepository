package com.example.Cereal.CerealBusiness.entity;
import javax.persistence.*;
@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Column(name="fname")
    private String fname;
    @Column(name="lname")
    private String lname;

    @Column(name="age")
    private int age;

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getShoesizeEu() {
        return shoesizeEu;
    }

    public void setShoesizeEu(int shoesizeEu) {
        this.shoesizeEu = shoesizeEu;
    }

    @Column(name="shoesizeeu")
    private int shoesizeEu;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
