package casia.isiteam.jpademo.model.po.sysuser.rep;

import casia.isiteam.jpademo.model.po.sysuser.tab.SysGrade;
import casia.isiteam.jpademo.model.po.sysuser.tab.SysName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * sys_grade 实体操作类
 * Fri Sep 28 17:40:25 CST 2018
 * @casia
 */ 
public interface SysNameRepository extends JpaRepository<SysName,Integer> {
    @Override
    @Transactional
    void deleteAllInBatch();

    @Transactional
    void deleteAllByIdIsIn(List<Integer> ids);

}

