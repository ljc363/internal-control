package io.internal.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.entity.SysProjectManagementEntity;

import java.util.Map;

public interface SysProjectManagementService extends IService<SysProjectManagementEntity> {
    PageUtils queryPage(Map<String,Object>params);
}
