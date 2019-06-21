package casia.isiteam.jpademo.model.po.sysuser.tab;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * sys_role_perm 实体类
 * Fri Oct 26 19:25:16 CST 2018
 * @casia
 */ 
@Entity
@Table(name = "sys_role_perm", schema = "sys_user", catalog = "")
public class SysRolePerm  implements Serializable {

	@Id
	@NotNull
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "role_id")
	private int roleId;

	@NotNull
	@Column(name = "perm_val")
	private String permVal;

	@NotNull
	@JSONField(name = "createTime", format="yyyy-MM-dd HH:mm:ss")
	@Column(name = "create_time")
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId(){
		return roleId;
	}

	public void setRoleId(int roleId){
		this.roleId=roleId;
	}

	public String getPermVal(){
		return permVal;
	}

	public void setPermVal(String permVal){
		this.permVal=permVal;
	}

	public Date getCreateTime(){
		return createTime;
	}

	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}

}

