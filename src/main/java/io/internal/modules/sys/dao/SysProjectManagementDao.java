package io.internal.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.internal.modules.sys.entity.SysProjectManagementEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目记录
 */
@Mapper
public interface SysProjectManagementDao extends BaseMapper<SysProjectManagementEntity> {

}
