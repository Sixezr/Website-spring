package ru.sixzr.managers;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

@Component
public class FileManager {
    private static final String EXTENSION = ".jpeg";
    private static final Path PATH_TO_WEB = Paths.get("src")
            .resolve("main").resolve("webapp").resolve("WEB-INF")
            .resolve("assets").resolve("img").resolve("products");

    private final SecureRandom secureRandom;

    public FileManager() {
        this.secureRandom = new SecureRandom();
    }

    public String uploadImage(InputStream inputStream) {
        File file = new File(PATH_TO_WEB.resolve(generateRandomName()) + EXTENSION);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try {
            Files.copy(inputStream, file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getName();
    }

    private String generateRandomName() {
        return new BigInteger(130, secureRandom).toString(32);
    }
}
