package com.lq.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Maps;
import com.lq.common.core.controller.BaseController;
import com.lq.common.core.domain.ResponseEntity;
import com.lq.service.SmsService;
import org.apache.commons.lang3.RandomUtils;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/api/sms")
@CrossOrigin
public class SmsController extends BaseController {
    @Resource
    private SmsService smsService;

    @GetMapping("/sendSms/{mobile}")
    public ResponseEntity sendSms(@PathVariable String mobile) {
        Assert.isTrue(Validator.isMobile(mobile),"手机号不合法");
        HashMap<String, Object> map = Maps.newHashMap();
        String code = RandomUtil.randomNumbers(6);
        map.put("code", code);
        logger.info("mobile:【{}】,code:【{}】", mobile, code);
        smsService.send(mobile, "", map);
        return ResponseEntity.success();
    }
}
