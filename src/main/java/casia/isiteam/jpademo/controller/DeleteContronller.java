package casia.isiteam.jpademo.controller;

import casia.isiteam.jpademo.service.DelServer;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by casia.wzy on 2018/11/2.
 */
@RestController
@RequestMapping("/del")
public class DeleteContronller {
    @Autowired
    private DelServer delServer;

    @ApiOperation(value="删除perm", notes="删除perm")
    @DeleteMapping("/delPerm")
    public void delPerm(String val) throws Exception{
        delServer.delPerm(val);
    }

    @ApiOperation(value="删除全部", notes="删除全部")
    @DeleteMapping("delAll/")
    public void delAll() throws Exception{
        delServer.delAll();
    }
    @ApiOperation(value="批量删除", notes="批量删除")
    @DeleteMapping("delAllBatch/")
    public void delAllBatch(Integer[] ids) throws Exception{
        delServer.delBatch(Arrays.asList(ids));
    }
}
