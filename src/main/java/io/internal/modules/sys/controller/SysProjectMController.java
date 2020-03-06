package io.internal.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.internal.common.utils.PageUtils;
import io.internal.common.utils.R;
import io.internal.modules.sys.entity.SysProjectMEntity;
import io.internal.modules.sys.service.SysProjectMService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 项目记录
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 11:23:13
 */
@RestController
@RequestMapping("sys/projectM")
public class SysProjectMController {
    @Autowired
    private SysProjectMService sysProjectMService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:projectM:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysProjectMService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:projectM:info")
    public R info(@PathVariable("id") Long id){
		SysProjectMEntity sysProjectM = sysProjectMService.getById(id);

        return R.ok().put("sysProjectM", sysProjectM);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:projectM:save")
    public R save(@RequestBody SysProjectMEntity sysProjectM){
		sysProjectMService.save(sysProjectM);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:projectM:update")
    public R update(@RequestBody SysProjectMEntity sysProjectM){
		sysProjectMService.updateByIds(sysProjectM);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:projectM:delete")
    public R delete(@RequestBody Long[] ids){
		sysProjectMService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
