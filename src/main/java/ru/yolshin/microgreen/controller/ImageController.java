package ru.yolshin.microgreen.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.yolshin.microgreen.entity.Image;
import ru.yolshin.microgreen.repository.ImageRepository;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("image")
public class ImageController {
    private ImageRepository imageRepository;
    @Value("${upload.path}")
    private String uploadPath;

    public ImageController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @PostMapping
    public Image save(@RequestParam("image") MultipartFile file) throws IOException {
        Image img = imageRepository.findByOriginFileName(file.getOriginalFilename());
        if (img != null) {
            return img;
        }

        if (file != null) {
            File uploadDir = new File(this.uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String fileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + fileName));

            Image image = new Image();
            image.setFileName(fileName);
            image.setOriginFileName(file.getOriginalFilename());

            return imageRepository.save(image);
        }

        return null;
    }
}
