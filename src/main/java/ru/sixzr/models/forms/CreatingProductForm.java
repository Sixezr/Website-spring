package ru.sixzr.models.forms;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CreatingProductForm {

    @NotBlank(message = "Не может быть пустым")
    private String name;

    @NotBlank(message = "Не может быть пустым")
    @Pattern(regexp = "[0-9]{1,13}([.,][0-9]*)?", message = "Может быть только числом")
    private String price;

    private MultipartFile file;

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
}
