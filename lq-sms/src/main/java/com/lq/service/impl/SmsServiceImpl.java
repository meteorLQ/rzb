package com.lq.service.impl;

import com.lq.common.utils.JacksonUtil;
import com.lq.common.utils.JsonUtils;
import com.lq.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class SmsServiceImpl implements SmsService {
    protected final static Logger log = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void send(String mobile, String templateCode, Map<String, Object> map) {
        Object code = map.get("code");
        // TODO 调用第三方发送短信验证码到手机
        log.info("调用第三方发送短信验证码到手机成功");
        String redKey = "rzb:sms:code" + mobile;
        String redKeyNum = "rzb:sms:num" + mobile;
        // 判断发送次数
        Long num = redisTemplate.boundValueOps(redKeyNum).increment();
        redisTemplate.expire(redKeyNum, 12, TimeUnit.HOURS);
        if (num == 5) {
            throw new RuntimeException("验证码发送一天不能超过5次,请12小时后重试！");
        }
        if (redisTemplate.hasKey(redKey)) {
            Long expire = redisTemplate.getExpire(redKey, TimeUnit.MINUTES);
            log.error("剩余失效时间:{}", expire);
            throw new RuntimeException("验证码发送频繁，请稍后重试！");
        }
        redisTemplate.opsForValue().set(redKey, code, 5, TimeUnit.MINUTES);

    }
}
