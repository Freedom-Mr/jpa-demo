package casia.isiteam.jpademo.service;

import casia.isiteam.jpademo.model.po.sysuser.rep.SysGradeRepository;
import casia.isiteam.jpademo.model.po.sysuser.rep.SysPermRepository;
import casia.isiteam.jpademo.model.po.sysuser.rep.SysRolePermRepository;
import casia.isiteam.jpademo.model.po.sysuser.rep.SysRoleRepository;
import casia.isiteam.jpademo.model.po.sysuser.tab.SysRole;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by casia.wzy on 2018/11/2.
 */
@Service
public class QueryServer {
    @Resource
    private SysGradeRepository sysGradeRepository;
    @Resource
    private SysRoleRepository sysRoleRepository;
    @Resource
    private SysPermRepository sysPermRepository;
    @Resource
    private SysRolePermRepository sysRolePermRepository;

    //查询所有
    public Object queryAll(){
        List<SysRole> list = sysRoleRepository.findAll();
        list.forEach(s->{
            System.out.println(s.getId()+"\t"+s.getName());
        });

        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        return jsonString;
    }
    //分页查询所有
    public Object queryAll(Integer page,Integer size){
        Sort sort= new Sort(Sort.Direction.DESC, "id"); // 排序字段
        Pageable pageable = PageRequest.of(page-1,size,sort);

        Page<SysRole> list = sysRoleRepository.findAll(pageable);
        list.forEach(s->{
            System.out.println(s.getId()+"\t"+s.getName());
        });
        System.out.println("共计："+list.getTotalElements());

        String jsonString = JSON.toJSONString(list.getContent());
        System.out.println(jsonString);
        return jsonString;
    }
    //根据ID查询
    public Object queryAllById(Integer id){
        List<SysRole> list = sysRoleRepository.findAllById(id);
        list.forEach(s->{
            System.out.println(s.getId()+"\t"+s.getName());
        });

        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        return jsonString;
    }
    //不等ID查询
    public Object queryAllByIdNot(Integer id){
        List<SysRole> list = sysRoleRepository.findAllByIdNot(id);
        list.forEach(s->{
            System.out.println(s.getId()+"\t"+s.getName());
        });

        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        return jsonString;
    }
    //根据多个ID查询
    public Object queryAllByIdIn(Integer[] id){
        List<SysRole> list = sysRoleRepository.findAllByIdIn(id);
        list.forEach(s->{
            System.out.println(s.getId()+"\t"+s.getName());
        });

        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        return jsonString;
    }
    //根据ID与name查询
    public Object queryAllByIdAndName(Integer id,String name){
        List<SysRole> list = sysRoleRepository.findAllByIdAndName(id,name);
        list.forEach(s->{
            System.out.println(s.getId()+"\t"+s.getName());
        });

        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        return jsonString;
    }
    //根据name模糊查询
    public Object queryAllByNameLike(String name){
        List<SysRole> list = sysRoleRepository.findAllByNameLike(name);
        list.forEach(s->{
            System.out.println(s.getId()+"\t"+s.getName());
        });

        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        return jsonString;
    }
    //根据name不为空查询
    public Object queryAllByNameNotNull(){
        List<SysRole> list = sysRoleRepository.findAllByNameIsNotNull();
        list.forEach(s->{
            System.out.println(s.getId()+"\t"+s.getName());
        });

        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        return jsonString;
    }
    //根据id范围查询
    public Object queryAllByIdBetween(int sid,int eid){
        List<SysRole> list = sysRoleRepository.findAllByIdBetween(sid,eid);
        list.forEach(s->{
            System.out.println(s.getId()+"\t"+s.getName());
        });

        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        return jsonString;
    }
    //根据id分组查询
    public Object queryAllByNameGroup(){
        List<SysRole> list = sysRoleRepository.findAllByNameGroup();
        list.forEach(s->{
            System.out.println(s.getId()+"\t"+s.getName());
        });

        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        return jsonString;
    }
    //根据小于等于id查询
    public Object queryAllByIdLessThanEqual(Integer sid){
        List<SysRole> list = sysRoleRepository.findAllByIdLessThanEqual(sid);
        list.forEach(s->{
            System.out.println(s.getId()+"\t"+s.getName());
        });

        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        return jsonString;
    }
    //统计查询
    public Object queryAllCount(){
       long count = sysRoleRepository.countAllByIdIsNotNull();
        System.out.println(count);
        return count;
    }
    //关联查询
    public Object queryAllLeft(){
        long count = sysRoleRepository.countAllByIdIsNotNull();
        System.out.println(count);
        return count;
    }
}
