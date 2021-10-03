package com.lq.system.service.impl;

import com.lq.system.entity.UserInfo;
import com.lq.system.mapper.UserInfoMapper;
import com.lq.system.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author LQ
 * @since 2021-09-20
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
