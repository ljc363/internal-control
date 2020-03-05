package io.internal.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.modules.sys.dao.SysRolePositionDao;
import io.internal.modules.sys.entity.SysRolePositionEntity;
import io.internal.modules.sys.service.SysRolePositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sysRolePositionService")
public class SysRolePositionImpl extends ServiceImpl<SysRolePositionDao, SysRolePositionEntity> implements SysRolePositionService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(Long roleId, List<Long> positionIdList) {

        //先删除角色与部门关系
        deleteBatch(new Long[]{roleId});

        if(positionIdList.size() == 0){
            return ;
        }

        //保存角色与菜单关系
        for(Long positionId : positionIdList){
            SysRolePositionEntity sysRolePositionEntity = new SysRolePositionEntity();
            sysRolePositionEntity.setPositionId(positionId);
            sysRolePositionEntity.setRoleId(roleId);

            this.save(sysRolePositionEntity);
        }
    }

    @Override
    public List<Long> qureyPositionList(Long[] roleIds) {
        return baseMapper.qureyPositionList(roleIds);
    }

    @Override
    public int deleteBatch(Long[] roleIds) {
        return baseMapper.deleteBatch(roleIds);
    }
}
