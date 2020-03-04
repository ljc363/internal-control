/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.internal.common.aspect;


import io.internal.common.annotation.DataFilter;
import io.internal.common.exception.RRException;
import io.internal.common.utils.Constant;
import io.internal.common.utils.ShiroUtils;
import io.internal.modules.sys.entity.SysRolePositionEntity;
import io.internal.modules.sys.entity.SysUserEntity;
import io.internal.modules.sys.service.SysPositionServier;
import io.internal.modules.sys.service.SysUserRoleService;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * 数据过滤，切面处理类
 *
 * @author Mark sunlightcs@gmail.com
 */
@Aspect
@Component
public class DataFilterAspect {

}
