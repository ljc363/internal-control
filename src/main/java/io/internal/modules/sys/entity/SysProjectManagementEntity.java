package io.internal.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.internal.modules.sys.enums.PacesEnum;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("sys_project_M")
public class SysProjectManagementEntity implements Serializable {

    private Long id;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目编号
     */
    private String number;

    /**
     * 项目进度
     */
    private PacesEnum paces;

    /**
     * 负责人
     */
    private String personInCharge;

    /**
     * 描述
     */
    private String remark;

    /**
     * 开始时间
     */
    private Data startsTime;

    /**
     * 结束时间
     */
    private Data endTime;
}
