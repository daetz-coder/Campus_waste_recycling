package com.example.cshand.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author daetz
 * @creat 2023/5/5
 **/
@RestController
@RequestMapping("/file")
public class FileController {
		@Value("${files.upload.path}")
		private String fileUploadPath;
		@PostMapping("/upload/img")
		public String upload(@RequestParam("file") MultipartFile file) throws IOException {
				String originalFilename = file.getOriginalFilename();
				String type = FileUtil.extName(originalFilename);
				long size = file.getSize();
				File uploadParentFile = new File(fileUploadPath);
				if (!uploadParentFile.exists()) {
						uploadParentFile.mkdirs();
				}
				String uuid = IdUtil.fastSimpleUUID();
				String fileUUID = uuid + StrUtil.DOT + type;
				File uploadFile = new File(fileUploadPath + fileUUID);
				String url = "http://localhost:8081/file/" + fileUUID;
				file.transferTo(uploadFile);
				return url;
		}
}
