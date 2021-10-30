package com.lq.service;

import java.util.Map;

public interface SmsService {
    /**
     * 发送短信
     * 短语验证码5分钟内有效,每天最多可以发5次,每次间隔时间需要超过1分钟
     *
     * @param mobile       手机号
     * @param templateCode 模板编码
     * @param map
     */
    void send(String mobile, String templateCode, Map<String, Object> map);
}
