package io.internal.modules.sys.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.utils.PageUtils;

import io.internal.common.utils.Query;
import io.internal.modules.sys.dao.SysProjectManagementDao;
import io.internal.modules.sys.entity.SysProjectManagementEntity;
import io.internal.modules.sys.service.SysProjectManagementService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sysProjectManagementService")
public class SysProjectManagementImpl extends ServiceImpl<SysProjectManagementDao, SysProjectManagementEntity> implements SysProjectManagementService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String projectName = (String)params.get("projectName"); //项目名称
        String number = (String)params.get("number");//项目编号
        String personInCharge = (String) params.get("personInCharge");
        IPage<SysProjectManagementEntity> page = this.page(
                new Query<SysProjectManagementEntity>().getPage(params),
                new QueryWrapper<SysProjectManagementEntity>()
                .like(StringUtils.isNotBlank(projectName),"projectName",projectName)
                .like(StringUtils.isNotBlank(number),"number",number)
                .like(StringUtils.isNotBlank(personInCharge),"personInCharge",personInCharge)

        );
        return null;
    }
}
