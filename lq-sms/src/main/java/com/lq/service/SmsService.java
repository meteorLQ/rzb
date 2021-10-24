package com.lq.service;

import java.util.Map;

public interface SmsService {
    /**
     * 发送短信
     * @param mobile 手机号
     * @param templateCode 模板编码
     * @param map
     */
    void send(String mobile, String templateCode, Map<String,Object> map);
}
