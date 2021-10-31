package com.lq.controller;

import com.lq.common.core.controller.BaseController;
import com.lq.common.core.domain.ResponseEntity;
import com.lq.service.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;

@RestController
@CrossOrigin
@RequestMapping("/oss")
public class OssController extends BaseController {
    @Resource
    FileService fileService;

    @PostMapping("/ossUpload")
    public ResponseEntity ossUpload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("module") String module) {

        try {
            InputStream inputStream = multipartFile.getInputStream();
            String filename = multipartFile.getOriginalFilename();
            String url = fileService.upload(inputStream, module, filename);
            logger.info("url:{}",url);
            return ResponseEntity.success(url);
        } catch (Exception e) {
            logger.error("oss上传异常",e);
            return ResponseEntity.error("文件上传异常");

        }
    }

    @DeleteMapping("/ossRemove")
    public ResponseEntity ossRemove(@RequestParam("url") String url) {

        try {
            fileService.ossRemove(url);
            logger.info("url:{}",url);
            return ResponseEntity.success(url);
        } catch (Exception e) {
            logger.error("oss删除异常",e);
            return ResponseEntity.error("文件删除失败！");

        }
    }
}
