package com.example.file.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @program: file-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-11 19:48
 **/
@RestController
public class FileUploadController {

    LocalDate localDate = LocalDate.now();

    @PostMapping("upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws Exception {

        String format = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);

        String realPath = request.getServletContext().getRealPath("/upload/") + format;

        File folder = new File(realPath);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        String oldName = file.getOriginalFilename();

        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));

        file.transferTo(new File(folder, newName));

        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/upload/" + format + "/" + newName;

    }

    @PostMapping("uploadV2")
    public String uploadV2(MultipartFile file, HttpServletRequest request) throws Exception {
        String format = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);

       String realPath = "D:/image/" + format;

        File folder = new File(realPath);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        String oldName = file.getOriginalFilename();

        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));

        file.transferTo(new File(folder, newName));

        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/" + format + "/" + newName;

    }

}
