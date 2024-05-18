package com.astrie.model;
import jakarta.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "customers")
public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private int id;
        private String name;
        private int age;
        private String  email;

    public Customer(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && age == customer.age && Objects.equals(name, customer.name) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, age, email);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
