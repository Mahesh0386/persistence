package io.bhannur.persistence.mapping;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class User {

    @Id
    private String id;

    private String name;

    public User()
    {
        this.id = UUID.randomUUID().toString();
    }
    // Home address
    // One user to one address
   // @OneToOne
   // private Address address;

/*    @ManyToOne // many users will have same address. => Address will have one row and there can be n users rows in user table.
    // Office address
    private Address address;*/

    /*@OneToMany // one user have many address // Creates a join table USER_ADDRESS which will have user_id and address_id
    private List<Address> addresses;*/

    @ManyToMany
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
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

    /*public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/

    /*@Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }*/
}
