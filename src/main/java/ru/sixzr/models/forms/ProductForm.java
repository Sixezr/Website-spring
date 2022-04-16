package ru.sixzr.models.forms;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ProductForm {

    private Long id;

    @NotBlank(message = "Не может быть пустым")
    private String name;

    @NotBlank(message = "Не может быть пустым")
    @Pattern(regexp = "[0-9]{1,13}([.,][0-9]*)?", message = "Может быть только числом")
    private String price;

    private MultipartFile file;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
