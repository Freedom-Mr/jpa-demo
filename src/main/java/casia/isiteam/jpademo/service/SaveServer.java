package casia.isiteam.jpademo.service;

import casia.isiteam.jpademo.model.po.sysuser.rep.*;
import casia.isiteam.jpademo.model.po.sysuser.tab.SysGrade;
import casia.isiteam.jpademo.model.po.sysuser.tab.SysLoginIp;
import casia.isiteam.jpademo.model.po.sysuser.tab.SysRole;
import casia.isiteam.jpademo.model.po.sysuser.tab.SysRolePerm;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by casia.wzy on 2018/11/2.
 */
@Service
public class SaveServer {
    @Resource
    private SysGradeRepository sysGradeRepository;
    @Resource
    private SysRoleRepository sysRoleRepository;
    @Resource
    private SysLoginIpRepository sysLoginIpRepository;
    @Resource
    private SysRolePermRepository sysRolePermRepository;

    //批量保存
    @Transactional
    public Object addRoles(){
        List<SysRole> list = new ArrayList<>();
        for(int i=1;i<3;i++){
            SysRole sysRole = new SysRole();
            sysRole.setName("测试1");
            sysRole.setRdesc("测试1");
            sysRole.setRval("xxxx");
            SysGrade sysGrade= new SysGrade();
            sysGrade.setId(i);
            sysRole.setSysGrade(sysGrade);
            sysRole.setCreateTime(new Date());
            sysRole.setUpdateTime(new Date());
            list.add(sysRole);
        }
        List<SysRole> a= sysRoleRepository.saveAll(list);
        String jsonString = JSON.toJSONString(a);
        System.out.println(jsonString);
        return jsonString;
    }

    //保存
    @Transactional
    public Object addRolePerm(Integer roleId, String val){
        SysRolePerm sysRolePerm = new SysRolePerm();
        sysRolePerm.setRoleId(roleId);
        sysRolePerm.setPermVal(val);
        sysRolePerm.setCreateTime(new Date());

        SysRolePerm a= sysRolePermRepository.save(sysRolePerm);
        String jsonString = JSON.toJSONString(a);
        System.out.println(jsonString);
        return jsonString;
    }
    //更新单条数据
    @Transactional
    public Object updateRole(Integer id, String name){
        int jsonString= sysRoleRepository.updateSysRole(name,id);
        System.out.println(jsonString);
        return jsonString;
    }

    //保存
    @Transactional
    public Object addIp(Integer userId, String ip){
        SysLoginIp sysLoginIp = new SysLoginIp();
        sysLoginIp.setIp(ip);
        sysLoginIp.setUserId(userId);
        sysLoginIp.setLoginTime(new Date());
        SysLoginIp a= sysLoginIpRepository.save(sysLoginIp);
        String jsonString = JSON.toJSONString(a);
        System.out.println(jsonString);
        return jsonString;
    }
}
