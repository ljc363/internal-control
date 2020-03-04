package io.internal.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色与岗位对应关系
 */
@Data
@TableName("sys_role_position")
public class SysRolePositionEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;

    /**
     * 角色ID
     */
    private Long RoleId;

    /**
     * 岗位ID
     */
    private Long PositionId;
}
