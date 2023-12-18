package com.excelFileUpload.fileUpload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.excelFileUpload.fileUpload.model.ExcelFile;
import com.excelFileUpload.fileUpload.repository.FileRepository;

@Service
public class FileService {

	@Autowired
	private FileRepository fileRepository;

	public Long uploadFile(MultipartFile file) {
		ExcelFile savedFile = fileRepository.save(file);
		return savedFile.getId();
	}

	public List<ExcelFile> getAllFiles() {
		return fileRepository.findAll();
	}

	public ExcelFile getFileById(Long id) {
		return fileRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public void deleteFile(Long id) {
		ExcelFile file = fileRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		fileRepository.delete(file);
	}
}