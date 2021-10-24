package com.lq.service.impl;

import com.lq.common.utils.JacksonUtil;
import com.lq.service.SmsService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public void send(String mobile, String templateCode, Map<String, Object> map) {

    }
}
