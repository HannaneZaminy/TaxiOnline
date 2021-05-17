package ir.maktab.data.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User {
    private String userName;
    private String name;
    private String lastName;
    private int age;
    private String phone;
    private Location location;

    public User(String userName, String name, String lastName, int age, String phone) {
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.location = new Location(0, 0);
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public User setLocation(Location location) {
        this.location = location;
        return this;
    }

    @Override
    public String toString() {
        return userName + " " + name + " " + lastName + " " + age + " " + phone;
    }
}
