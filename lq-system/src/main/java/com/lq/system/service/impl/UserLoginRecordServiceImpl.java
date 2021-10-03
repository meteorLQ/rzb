package com.lq.system.service.impl;

import com.lq.system.entity.UserLoginRecord;
import com.lq.system.mapper.UserLoginRecordMapper;
import com.lq.system.service.IUserLoginRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录记录表 服务实现类
 * </p>
 *
 * @author LQ
 * @since 2021-09-20
 */
@Service
public class UserLoginRecordServiceImpl extends ServiceImpl<UserLoginRecordMapper, UserLoginRecord> implements IUserLoginRecordService {

}
