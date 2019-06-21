package casia.isiteam.jpademo.model.po.sysuser.rep;

import casia.isiteam.jpademo.model.po.sysuser.tab.SysGrade;
import casia.isiteam.jpademo.model.po.sysuser.tab.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;

/**
 * sys_role 实体操作类
 * Fri Sep 28 17:40:25 CST 2018
 * @casia
 */ 
public interface SysRoleRepository extends JpaRepository<SysRole,Integer> {
    @Lock(LockModeType.READ) //锁定
    List<SysRole> findAllById(Integer id);
    List<SysRole> findAllByIdNot(Integer id);
    List<SysRole> findAllByIdIn(Integer[] id);
    List<SysRole> findAllByIdAndName(Integer id,String name);
    List<SysRole> findAllByNameLike(String name);
//    @Query("select u from SysRole u where u.name is not null")
    List<SysRole> findAllByNameIsNotNull();
    List<SysRole> findAllByIdBetween(int sid,int eid);
    @Query("select u from SysRole u group by u.name")
    List<SysRole> findAllByNameGroup();
//    @Query("select d from SysRole u ,SysPerm s where u.rval=s.val")
//    List querySysperm();
    List<SysRole> findAllByIdLessThanEqual(int sid);
    @Transactional(timeout = 10) // 事务
    Long countAllByIdIsNotNull();


    @Query("update SysRole s set s.name=?0 where s.id=?1")
    @Modifying
    @Transactional
    int updateSysRole(String name, Integer id);
}

