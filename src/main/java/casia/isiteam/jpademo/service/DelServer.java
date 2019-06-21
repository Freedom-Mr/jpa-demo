package casia.isiteam.jpademo.service;

import casia.isiteam.jpademo.model.po.sysuser.rep.*;
import casia.isiteam.jpademo.model.po.sysuser.tab.SysName;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by casia.wzy on 2018/11/2.
 */
@Service
public class DelServer {
    @Resource
    private SysGradeRepository sysGradeRepository;
    @Resource
    private SysRoleRepository sysRoleRepository;
    @Resource
    private SysPermRepository sysPermRepository;
    @Resource
    private SysRolePermRepository sysRolePermRepository;
    @Resource
    private SysNameRepository sysNameRepository;

    //删除perm
    public void delPerm(String val){
        sysPermRepository.deleteByValIs(val);
    }
    //全部删除
    public void delAll(){
        sysNameRepository.deleteAll();//先查询后删除再提交
        sysNameRepository.deleteAllInBatch();//直接全部删除
    }

    //批量删除
    public void delBatch(List<Integer> ids){
        List<SysName> list = new ArrayList<>();
        ids.forEach( s->{
            SysName sysName = new SysName();
            sysName.setId(s);
            list.add(sysName);
        });
//        sysNameRepository.deleteAllByIdIsIn(ids);//内部一条条删除
        sysNameRepository.deleteInBatch(list);//拼接一句sql后全部删除
    }
}
