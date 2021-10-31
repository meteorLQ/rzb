package com.lq.service;

import java.io.InputStream;

public interface FileService {

    /**
     * 文件上传
     * @param inputStream
     * @param module
     * @param fileName
     * @return
     */
    String upload(InputStream inputStream,String module,String fileName);

    /**
     * 删除文件
     * @param url
     */
    void ossRemove(String url);
}
