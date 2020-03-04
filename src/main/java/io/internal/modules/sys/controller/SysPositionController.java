package io.internal.modules.sys.controller;

import io.internal.common.utils.Constant;
import io.internal.common.utils.R;
import io.internal.modules.sys.entity.SysPositionEntity;
import io.internal.modules.sys.service.SysPositionServier;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/sys/position")
public class SysPositionController extends AbstractController{

    @Resource
    private SysPositionServier sysPositionServier;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:position:list")
    public List<SysPositionEntity> list(){
        List<SysPositionEntity> list = new ArrayList<>();
        list = sysPositionServier.queryList(new HashMap<String,Object>());
        System.out.print(sysPositionServier.queryList(new HashMap<String,Object>()));
        return list;
    }

    /**
     * 选择部门(添加、修改菜单)
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:position:select")
    public R select(){
        List<SysPositionEntity> positionList = sysPositionServier.queryList(new HashMap<String, Object>());

        //添加部门
        if(getUserId() == Constant.SUPER_ADMIN){
            SysPositionEntity root = new SysPositionEntity();
            root.setPositionId(0L);
            root.setName("一级部门");
            root.setParentId(-1L);
            root.setOpen(true);
            positionList.add(root);
        }

        return R.ok().put("positionList", positionList);
    }

    /**
     * 部门Id(管理员则为0)
     */
    @RequestMapping("/info")
    @RequiresPermissions("sys:dept:list")
    public R info(){
       long positionId = 0;
       if(getUserId() != Constant.SUPER_ADMIN) {
           List<SysPositionEntity> positionList = sysPositionServier.queryList(new HashMap<String, Object>());
           Long parentId = null;
           for (SysPositionEntity positionEntity : positionList) {
              if (parentId == null){
                 parentId = positionEntity.getParentId();
                 continue;
              }

              if (positionId > positionEntity.getParentId().longValue()){
                  parentId = positionEntity.getParentId();
              }
           }
           positionId = parentId;
       }
       return R.ok().put("positionId",positionId);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{positionId}")
    @RequiresPermissions("sys:dept:info")
    public R info(@PathVariable("positionId") Long positionId){
        SysPositionEntity position = sysPositionServier.getById(positionId);
        return R.ok().put("position", position);
    }

    /**
     *保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:position:save")
    public R save(@RequestBody SysPositionEntity sysPosition){
        sysPositionServier.save(sysPosition);
        return R.ok();
    }

    /**
     *删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:position:delete")
    public R delete(Long positionId){
        //判断是否存在岗位名称
        List<Long> position = sysPositionServier.queryPositionIdList(positionId);
        if (position.size() > 0){
          return   R.error("请删除岗位");
        }
        sysPositionServier.removeById(positionId);
           return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:position:update")
    public R update(@RequestBody SysPositionEntity position){
        sysPositionServier.updateById(position);
        return R.ok();
    }


}
