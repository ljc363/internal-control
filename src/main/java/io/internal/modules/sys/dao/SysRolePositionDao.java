package io.internal.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.internal.modules.sys.entity.SysRolePositionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRolePositionDao extends BaseMapper<SysRolePositionEntity> {

    /**
     * 根据角色ID，获取岗位ID
     */
    List<Long>qureyPositionList(Long[] roleIds);

    /**
     * 根据角色ID，批量删除
     * @param roleIds
     * @return
     */
   int deleteBatch(Long[] roleIds);
}
