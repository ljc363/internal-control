package io.internal.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.modules.sys.dao.SysPositionDao;
import io.internal.modules.sys.entity.SysPositionEntity;
import io.internal.modules.sys.service.SysPositionServier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("sysPositionService")
public class SysPositionImpl extends ServiceImpl<SysPositionDao, SysPositionEntity> implements SysPositionServier{

    @Override
    public List<SysPositionEntity> queryList(Map<String, Object> params) {
        return baseMapper.queryList(params);
    }

    @Override
    public List<Long> queryPositionIdList(Long params) {
        return baseMapper.queryPositionIdList(params);
    }
}
