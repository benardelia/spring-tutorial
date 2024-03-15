package com.swiftlearn.leaningproject.entity;


import jakarta.persistence.*;

//  the entity annotation specify this class should be used to create model (Table)
//  if it does not exist once the server run it will ignore if table already exist
@Entity
public class Student {
//    every property in this class treated as a column so when table created the present
//    properties will be used to define column (ie they are table structure)
//    @Id annotation specify when this model created this field should be primary key

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // for the safe ids generation type you can use UUID and the id type should be String
//    the UUID its almost impossible to collide if you generate 1 Billion UUID every second for the next 100 years the chance of
//    two UUID to collide is 50%
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
//    @Column used to specify properties of a column like nullable, unique, length... etc
    @Column(unique = true)
    private String email;
    private String grade;
    private String phone;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGrade() {
        return grade;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", grade='" + grade + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
