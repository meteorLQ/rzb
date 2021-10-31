package com.lq.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.lq.config.AliOssProperties;
import com.lq.service.FileService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String upload(InputStream inputStream, String module, String fileName) {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(AliOssProperties.ENDPOINT, AliOssProperties.AK, AliOssProperties.SK);
        // 判断bucket是否存在，如果不存在重新创建，并赋予公共读权限
        if (!ossClient.doesBucketExist(AliOssProperties.BUCKET_NAME)) {
            ossClient.createBucket(AliOssProperties.BUCKET_NAME);
            ossClient.setBucketAcl(AliOssProperties.BUCKET_NAME, CannedAccessControlList.PublicRead);
        }
        String timeFolder= LocalDate.now().format(DateTimeFormatter.ofPattern("/yyyy/MM/dd/"));
        String path = RandomUtil.randomString(8) +fileName.substring(fileName.lastIndexOf("."));
        String key=module+timeFolder+path;
        ossClient.putObject(AliOssProperties.BUCKET_NAME, key, inputStream);
        // https://sub-lq.oss-cn-beijing.aliyuncs.com/docker%E5%AE%89%E8%A3%85nginx.txt
        // 关闭OSSClient。
        ossClient.shutdown();
        String url="https://"+AliOssProperties.BUCKET_NAME+"."+AliOssProperties.ENDPOINT+"/"+key;
        return url;
    }

    @Override
    public void ossRemove(String url) {
        // 创建OSSClient实例。
        String host="https://"+AliOssProperties.BUCKET_NAME+"."+AliOssProperties.ENDPOINT+"/";
        OSS ossClient = new OSSClientBuilder().build(AliOssProperties.ENDPOINT, AliOssProperties.AK, AliOssProperties.SK);
        String objectName = url.substring(host.length());
        // 删除文件或目录。如果要删除目录，目录必须为空。
        ossClient.deleteObject(AliOssProperties.BUCKET_NAME, objectName);
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
