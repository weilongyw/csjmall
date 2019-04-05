package com.csj.framework.mall.service;

import com.csj.framework.mall.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 账号信息 服务类
 * </p>
 *
 * @author yewei
 * @since 2019-04-05
 */
public interface ISysUserService extends IService<SysUser> {

     SysUser cacheUser(String id);


}
