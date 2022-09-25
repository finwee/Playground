package com.hubertdostal.tmobile.homework.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "User")
@Table(name = "USERS", schema = "SCHEMA1")
public class User {

    /**
     * Unique identifier of instance of User
     * Its value is automatically generated
     */
    @Id
    // TODO check column and strategy type
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_")
    private Long id;


    @Column(name = "LOGIN_NAME_",
            unique = true,
            nullable = false)
    private String loginName;

    @Column(name = "FIRST_NAME_",
            nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME_",
            nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "acquiredByUser")
    private List<Task> acquiredTasks;

    @OneToMany(mappedBy = "createdByUser")
    private List<Task> createdTasks;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
