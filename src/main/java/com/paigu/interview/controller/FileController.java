package com.paigu.interview.controller;

import cn.hutool.core.io.FileUtil;
import com.paigu.interview.config.FileConfig;
import com.paigu.interview.service.FileTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 文件控制器
 *
 * @author LiaoXM
 * @date 2021/10/14
 */
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

	private final FileConfig fileConfig;
    private final FileTaskService fileTaskService;
	@PostMapping("/upload")
	public String upload(MultipartFile file) throws IOException{
		if (file.isEmpty()) {
			return "请选择需要上传的文件";
		}
		InputStream inputStream = file.getInputStream();
		String suffix = FileUtil.getSuffix(file.getOriginalFilename());
		FileUtil.writeFromStream(inputStream, fileConfig.getFilePath() + UUID.randomUUID() + "." + suffix);
		return fileConfig.getFilePath();
	}

	@GetMapping("/filetask")
	public String addFileTask(String fileTask){
		fileTaskService.addTask(fileTask);
		return fileTask+"添加成功";
	}
}
