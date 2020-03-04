package io.internal.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.internal.modules.sys.entity.SysPositionEntity;

import java.util.List;
import java.util.Map;

public interface SysPositionServier extends IService<SysPositionEntity> {
//    /**
//     * 获取岗位ID，用于数据过滤
//     */
// List<Long>getSubDeptIdList(Long postionId);

    List<SysPositionEntity> queryList(Map<String,Object> params);

    List<Long> queryPositionIdList(Long params);

}
