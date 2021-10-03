package com.lq.system.service.impl;

import com.lq.system.entity.UserAccount;
import com.lq.system.mapper.UserAccountMapper;
import com.lq.system.service.IUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author LQ
 * @since 2021-09-20
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountService {

}
