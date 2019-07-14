package com.company.df.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.company.df.model.User;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping( value = "/upload")
	@CrossOrigin
	public String handleFileUpload(
			HttpServletRequest request, 
//			@RequestPart MultipartFile files
			@RequestParam(value = "file") MultipartFile file

			) throws IllegalStateException, IOException {
		
		System.out.println("data1 = " + request.getParameter("data1"));
		System.out.println("data2 = " + request.getParameter("data2"));
		System.out.println("data3 = " + request.getParameter("data3"));
		System.out.println("data4 = " + request.getParameter("data4"));
		
		
		
		String sourceFileName = file.getOriginalFilename(); 
        String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase(); 
        File destinationFile; 
        String destinationFileName;
        String fileUrl = "./";

        do { 
            destinationFileName = sourceFileName + "." + sourceFileNameExtension; 
            String filePath = fileUrl + destinationFileName;
            destinationFile = new File(filePath); 
        } while (destinationFile.exists()); 
        
        destinationFile.getParentFile().mkdirs(); 
        file.transferTo(destinationFile); 

		System.out.println("upload success");
      
        return "redirect:/";
    }
	

	
	
	//
	@GetMapping("/index")
    public String getUser(HttpServletRequest request, Locale locale, Model model) {
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
    }
}
