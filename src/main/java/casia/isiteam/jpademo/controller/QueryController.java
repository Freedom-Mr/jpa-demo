package casia.isiteam.jpademo.controller;

import casia.isiteam.jpademo.model.po.sysuser.tab.SysRole;
import casia.isiteam.jpademo.service.QueryServer;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by casia.wzy on 2018/11/2.
 */
@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private QueryServer queryServer;

    @ApiOperation(value="查询所有角色", notes="查询所有角色")
    @GetMapping("/all")
    public Object all() throws Exception{
        Object result = queryServer.queryAll();
        return result;
    }
    @ApiOperation(value="根据ID查询所有角色", notes="根据ID查询所有角色")
    @GetMapping("/allById")
    public Object allById(Integer id) throws Exception{
        Object result = queryServer.queryAllById(id);
        return result;
    }
    @ApiOperation(value="根据非ID查询所有角色", notes="根据非ID查询所有角色")
    @GetMapping("/allByIdNot")
    public Object allByIdNot(Integer id) throws Exception{
        Object result = queryServer.queryAllByIdNot( id);
        return result;
    }
    @ApiOperation(value="根据ID与name查询所有角色", notes="根据ID与name查询所有角色")
    @GetMapping("/allByIdAndName")
    public Object allByIdAndName(Integer id,String name) throws Exception{
        Object result = queryServer.queryAllByIdAndName(id,name);
        return result;
    }
    @ApiOperation(value="根据name模糊查询所有角色", notes="根据name模糊查询所有角色")
    @GetMapping("/allByNameLike")
    public Object allByNameLike(String name) throws Exception{
        Object result = queryServer.queryAllByNameLike("%"+name+"%");
        return result;
    }
    @ApiOperation(value="分页查询所有角色", notes="分页查询所有角色")
    @GetMapping("/allPage")
    public Object allPage(Integer page,Integer size) throws Exception{
        Object result = queryServer.queryAll(page , size);
        return result;
    }
    @ApiOperation(value="根据多个ID查询所有角色", notes="根据多个ID查询所有角色")
    @GetMapping("/allByIdIn")
    public Object allByIdIn(Integer[] ids) throws Exception{
        Object result = queryServer.queryAllByIdIn( ids);
        return result;
    }
    @ApiOperation(value="根据name不为null查询所有角色", notes="根据name不为null查询所有角色")
    @GetMapping("/allByNameNotNull")
    public Object allByNameNotNull() throws Exception{
        Object result = queryServer.queryAllByNameNotNull();
        return result;
    }
    @ApiOperation(value="根据id范围查询所有角色", notes="根据id范围查询所有角色")
    @GetMapping("/allByIdBetween")
    public Object allByIdBetween(int sid, int eid) throws Exception{
        Object result = queryServer.queryAllByIdBetween(sid ,eid);
        return result;
    }
    @ApiOperation(value="根据id分组查询所有角色", notes="根据id分组查询所有角色")
    @GetMapping("/allByNameGroup")
    public Object allByNameGroup() throws Exception{
        Object result = queryServer.queryAllByNameGroup();
        return result;
    }
    @ApiOperation(value="根据<=id查询所有角色", notes="根据<=id分组查询所有角色")
    @GetMapping("/allByIdLessThanEqual")
    public Object allByIdLessThanEqual(Integer sid) throws Exception{
        Object result = queryServer.queryAllByIdLessThanEqual(sid);
        return result;
    }
    @ApiOperation(value="统计查询", notes="统计查询")
    @GetMapping("/allCount")
    public Object allCount() throws Exception{
        Object result = queryServer.queryAllCount();
        return result;
    }
}
