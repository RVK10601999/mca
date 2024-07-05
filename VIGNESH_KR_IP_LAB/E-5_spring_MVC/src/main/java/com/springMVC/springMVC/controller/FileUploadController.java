package com.springMVC.springMVC.controller;

import com.springMVC.springMVC.model.FileUploadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class FileUploadController implements ServletContextAware {

    private ServletContext servletContext;

    @Autowired
    private CustomFileValidator customFileValidator;

    @GetMapping("/uploadFile")
    public String uploadFileFormDisplay(Model model) {
        model.addAttribute("fileUploadModel", new FileUploadModel());
        return "uploadFile";
    }

    @PostMapping("/uploadFile")
    public String uploadFileHandler(Model model, @ModelAttribute @Valid FileUploadModel fileUploadModel,
                                    BindingResult bindingResult) {
        MultipartFile file = fileUploadModel.getFile();
        customFileValidator.validate(fileUploadModel, bindingResult);

        if (bindingResult.hasErrors()) {
            return "uploadFile";
        }

        String fileName = file.getOriginalFilename();
        model.addAttribute("fileName", fileName);

        try {
            byte[] bytes = file.getBytes();
            String uploadPath = servletContext.getRealPath("/") + fileName;

            try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(uploadPath)))) {
                stream.write(bytes);
            }

            return "fileUploadSuccess";
        } catch (Exception e) {
            return "fileUploadFailure";
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
