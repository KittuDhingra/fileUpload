package com.excelFileUpload.fileUpload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.excelFileUpload.fileUpload.model.ExcelFile;

public interface FileRepository extends JpaRepository<ExcelFile, Long> {

	ExcelFile save(MultipartFile file);
}