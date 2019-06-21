package casia.isiteam.jpademo.model.po.sysuser.rep;

import casia.isiteam.jpademo.model.po.sysuser.tab.SysPerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * sys_perm 实体操作类
 * Fri Sep 28 17:40:25 CST 2018
 * @casia
 */ 
public interface SysPermRepository extends JpaRepository<SysPerm,Integer> {
    @Transactional
    void deleteByValIs(String val);

}

