package casia.isiteam.jpademo.controller;

import casia.isiteam.jpademo.model.po.sysuser.tab.SysGrade;
import casia.isiteam.jpademo.model.po.sysuser.tab.SysRole;
import casia.isiteam.jpademo.service.SaveServer;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by casia.wzy on 2018/11/2.
 */
@RestController
@RequestMapping("/save")
public class SaveController {
    @Autowired
    private SaveServer saveServer;

    @ApiOperation(value="批量添加角色", notes="批量添加角色")
    @PostMapping("/addRoles")
    public Object addRoles() throws Exception{
        Object result = saveServer.addRoles();
        return result;
    }
    @ApiOperation(value="添加单条数据", notes="添加单条数据")
    @PostMapping("/addRolePerm")
    public Object addRolePerm(Integer roleId, String val) throws Exception{
        Object result = saveServer.addRolePerm(roleId , val);
        return result;
    }
    @ApiOperation(value="更新单条数据", notes="更新单条数据")
    @PatchMapping("/updateRole")
    public Object updateRole(String name,Integer id) throws Exception{
        Object result = saveServer.updateRole(id , name);
        return result;
    }
    @ApiOperation(value="保存IP数据", notes="保存IP数据")
    @PatchMapping("/saveIp")
    public Object saveIp(String ip,Integer userId) throws Exception{
        Object result = saveServer.addIp(userId , ip);
        return result;
    }
}
