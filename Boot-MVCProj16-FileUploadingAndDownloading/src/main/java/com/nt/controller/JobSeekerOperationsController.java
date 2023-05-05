//JobSeekerOperationsController.java
package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeekerData;
import com.nt.service.IJobSeekerInfoService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class JobSeekerOperationsController {
	@Autowired
	private IJobSeekerInfoService service;
	
	@GetMapping("/")
	public String showHome() {
		//return LVN
		return "show_home";
	}//method
	
	@GetMapping("/register")
	public String showRegistrationForm(@ModelAttribute("js") JobSeekerData jsData) {
		//return LVN
		return "registration_form";
	}//class
	
	@Autowired
	private Environment env;
	
	@PostMapping("/register")
	public String registerJobSeeker(@ModelAttribute("js") JobSeekerData jsData, Map<String,Object> map) {
		//get the upload store location from properties file
		String location = env.getRequiredProperty("upload.store");
		// create the location if not available
		File file = new File(location);
		if(!file.exists())
			file.mkdir();
		//get InputStreams and OutputStreams representing the upload files content
		MultipartFile resumeFile = jsData.getResume();
		MultipartFile photoFile = jsData.getPhoto();
		try(InputStream resumeIS = resumeFile.getInputStream();
				InputStream photoIS = photoFile.getInputStream();
				OutputStream resumeOS = new FileOutputStream(file.getAbsolutePath()+"\\"+resumeFile.getOriginalFilename());
				OutputStream photoOS = new FileOutputStream(file.getAbsolutePath()+"\\"+photoFile.getOriginalFilename())){
			//perform copy operations
			IOUtils.copy(photoIS, photoOS);
			IOUtils.copy(resumeIS, resumeOS);
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		
		//prepare Entity class object from Model class object
		JobSeekerInfo info = new JobSeekerInfo();
		info.setJsName(jsData.getJsdName());
		info.setJsAddrs(jsData.getJsdAddrs());
		info.setResumePath(file.getAbsolutePath()+"/"+resumeFile.getOriginalFilename());
		info.setPhotoPath(file.getAbsolutePath()+"/"+photoFile.getOriginalFilename());
		//use Service to register
		String resultMsg = service.registerJobSeekerInfo(info);
		//add result to Model Attributes
		map.put("resultMsg", resultMsg);
		//return LVN
		return "show_result";
		
	}//method
	
	@GetMapping("/js_list")
	public String showAllJobSeekerData(Map<String, Object> map) {
		//use service
		List<JobSeekerInfo> jsList = service.getAllJobSeekerData();
		//add result ot Model Attributes
		map.put("jsList", jsList);
		//return LVN
		return "show_list";
	}//method
	
	@Autowired
	private ServletContext sc;
	
	@GetMapping("/download")
	public String fileDownload(HttpServletResponse res, 
														@RequestParam("jsId") Integer id,
														@RequestParam("type") String type) throws Exception {
		//get the path of the file to be downloaded
		String filePath = null;
		if(type.equalsIgnoreCase("resume"))
			filePath = service.getResumePathById(id);
		else
			filePath = service.getPhotoPathById(id);
		System.out.println(filePath);
		//create File object representing files to be downloaded
		File file = new File(filePath);
		//get the length of the file and make it as length of the response content length
		res.setContentLengthLong(file.length());
		//get the MIME of the file and make it as the response content type
		String mimeType = sc.getMimeType(filePath);
		mimeType = mimeType==null?"application/octet-stream":mimeType;
		res.setContentType(mimeType);
		//create InputStream pointing to the file
		InputStream is = new FileInputStream(file);
		//create OutputStream pointing to the response obj
		OutputStream os = res.getOutputStream();
		//instruct the browser to give file content as downloadable file
		res.setHeader("Content-Disposition","attachment;fileName="+file.getName());
		//write fileContent to response obj
		IOUtils.copy(is, os);
		//makes the handler method to send the output directly to browser
		return null;
	}//method

}//class
