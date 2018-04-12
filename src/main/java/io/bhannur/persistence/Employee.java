package io.bhannur.persistence;

import org.eclipse.persistence.annotations.CompositeMember;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table //creates table with name of class. // (name="USER") to explicity create a table with name USER.
@NamedQueries(
        @NamedQuery(name="Employee.findByEmail", query="SELECT e FROM Employee e WHERE e.email =:pEmail")
)
public class Employee { // Entity class
    @Id // primary key
    private String id;
    // for making composite key @CompositeMember()
    // Eclipse link can create tables automatically.
    private String name;
    private String city;
    private String salary;

    @Column(unique = true)// columnDefinition = "VARCHAR(125)")
    private String email;

    public Employee()
    {
        this.id = UUID.randomUUID().toString();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", salary='" + salary + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
