package io.internal.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 任务计划表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 10:55:24
 */
@Data
@TableName("sys_task_schedule")
public class SysTaskScheduleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 任务名称
	 */
	private String taskName;
	/**
	 * 子任务
	 */
	private String subTask;
	/**
	 * 计划开始时间
	 */
	private Date planneStartTime;
	/**
	 * 计划结束时间
	 */
	private Date plannedEndTime;
	/**
	 * 实际结束时间
	 */
	private Date actualEndTime;
	/**
	 * 实际结束时间
	 */
	private Date tualStartTime;
	/**
	 * 进度
	 */
	private String paecs;
	/**
	 * 负责人
	 */
	private String personInCharge;
	/**
	 * 审核人
	 */
	private String auditor;

}
