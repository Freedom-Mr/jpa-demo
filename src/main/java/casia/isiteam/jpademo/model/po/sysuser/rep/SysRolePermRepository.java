package casia.isiteam.jpademo.model.po.sysuser.rep;

import casia.isiteam.jpademo.model.po.sysuser.tab.SysRolePerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * sys_role_perm 实体操作类
 * Fri Oct 26 19:25:16 CST 2018
 * @casia
 */ 
public interface SysRolePermRepository extends JpaRepository<SysRolePerm,Integer> {

}

