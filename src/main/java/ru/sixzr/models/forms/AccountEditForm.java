package ru.sixzr.models.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AccountEditForm {
    @NotNull(message = "Не может быть пустым")
    @NotBlank(message = "Не может быть пустым")
    @Pattern(regexp = "\\p{L}+", message = "Может содержать только буквы")
    private String firstName;

    @NotNull(message = "Не может быть пустым")
    @NotBlank(message = "Не может быть пустым")
    @Pattern(regexp = "\\p{L}+", message = "Может содержать только буквы")
    private String secondName;

    @NotNull(message = "Не может быть пустым")
    @NotBlank(message = "Не может быть пустым")
    private String phone;

    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
