package io.internal.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.internal.modules.sys.entity.SysRolePositionEntity;

import java.util.List;


public interface SysRolePositionService extends IService<SysRolePositionEntity> {

    void saveOrUpdate(Long roleId, List<Long>PositionIdList);

    List<Long>qureyPositionList( Long[] roleIds);

    int deleteBatch(Long[] roleIds);
}
