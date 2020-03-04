package io.internal.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.annotation.DataFilter;
import io.internal.modules.sys.dao.SysPositionDao;
import io.internal.modules.sys.entity.SysPositionEntity;
import io.internal.modules.sys.service.SysPositionServier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("sysPositionService")
public class SysPositionImpl extends ServiceImpl<SysPositionDao, SysPositionEntity> implements SysPositionServier{
    @Override
    public List<Long> getSubDeptIdList(Long positionId) {
        //部门及岗位ID列表
        List<Long> positionIdList = new ArrayList<>();

        //获取岗位ID
        List<Long> subIdList = queryPositionIdList(positionId);
        getPositionTreeList(subIdList, positionIdList);

        return positionIdList;
    }

    @Override
    @DataFilter(subDept = true, user = false, tableAlias = "t1")
    public List<SysPositionEntity> queryList(Map<String, Object> params) {
        return baseMapper.queryList(params);
    }

    @Override
    public List<Long> queryPositionIdList(Long params) {
        return baseMapper.queryPositionIdList(params);
    }

    /**
     * 递归
     */
    private void getPositionTreeList(List<Long> subIdList, List<Long> positionIdList){
        for(Long positionId : subIdList){
            List<Long> list = queryPositionIdList(positionId);
            if(list.size() > 0){
                getPositionTreeList(list, positionIdList);
            }

            positionIdList.add(positionId);
        }
    }
}
