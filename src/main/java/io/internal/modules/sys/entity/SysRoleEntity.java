

package io.internal.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色
 *
 * @author
 */
@Data
@TableName("sys_role")
public class SysRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 角色ID
	 */
	@TableId
	private Long roleId;

	/**
	 * 角色名称
	 */
	@NotBlank(message="角色名称不能为空")
	private String roleName;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 岗位ID
	 */
	@NotNull(message="岗位不能为空")
	private Long positionId;

	/**
	 * 岗位名称
	 */
	@TableField(exist=false)
	private String positionName;

	/**
	 * 创建者ID
	 */
	@TableField(exist=false)
	private Long createUserId;

	@TableField(exist=false)
	private List<Long> menuIdList;

	@TableField(exist=false)
	private List<Long> positionIdList;
	/**
	 * 创建时间
	 */
	private Date createTime;

	
}
