
package io.internal.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * 岗位管理
 *
 * @author
 */
@Data
@TableName("sys_position")
public class SysPositionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 岗位ID
	 */
	@TableId
	private Long positionId;
	/**
	 * 部门ID，一级部门为0
	 */
	private Long parentId;
	/**
	 * 岗位名称
	 */
	private String name;
	/**
	 * 部门名称
	 */
	@TableField(exist=false)
	private String parentName;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 是否删除  -1：已删除  0：正常
	 */
	@TableLogic
	private Integer delFlag;
	/**
	 * ztree属性
	 */
	@TableField(exist=false)
	private Boolean open;
	@TableField(exist=false)
	private List<?> list;
}
