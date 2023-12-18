package com.excelFileUpload.fileUpload.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.excelFileUpload.fileUpload.model.ExcelFile;
import com.excelFileUpload.fileUpload.service.FileService;

@RestController
@RequestMapping("/api")
public class FileUploadController {

	@Autowired
	private FileService fileService;

	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
		return ResponseEntity.ok(fileService.uploadFile(file));
	}

	@GetMapping("/files")
	public List<ExcelFile> getAllFiles() {
		return fileService.getAllFiles();
	}

	@GetMapping("/files/{id}")
	public ExcelFile getFileById(@PathVariable Long id) {
		return fileService.getFileById(id);
	}

	
	@DeleteMapping("/files/{id}")
	public ResponseEntity<?> deleteFile(@PathVariable Long id) {
		fileService.deleteFile(id);
		return ResponseEntity.noContent().build();
	}
}