package sample.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
    private @Id @GeneratedValue
    Long id;
    private String name;
    private String surname;

    public Employee(){}

    public Employee(String name, String surname){
        this.name=name;
        this.surname=surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    //Alt+Ins to add Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    //Ctrl+O to add

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.format("Employee{id='%s', name='%s', surname='%s'}", id,name,surname);
    }
}
