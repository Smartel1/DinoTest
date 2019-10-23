package ru.smartel.dinotest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import ru.smartel.dinotest.entity.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    @Null
    private Long id;

    @NotNull
    @Length(min = 3)
    private String name;

    @NotNull
    @Length(min = 3)
    private String surname;

    @NotNull
    @Length(min = 3)
    private String address;

    @NotNull
    private LocalDate birthdate;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.address = user.getAddress();
        this.birthdate = user.getBirthdate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
