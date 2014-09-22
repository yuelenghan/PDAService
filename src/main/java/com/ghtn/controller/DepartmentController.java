package com.ghtn.controller;

import com.ghtn.service.DepartmentManager;
import com.ghtn.vo.DepartmentVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lihe on 14/9/15.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController {

    private DepartmentManager departmentManager;

    @Resource
    public void setDepartmentManager(DepartmentManager departmentManager) {
        this.departmentManager = departmentManager;
    }

    @RequestMapping("/mainDept")
    @ResponseBody
    public List<DepartmentVO> getAllMainDept() {
        return departmentManager.getAllMainDeptOracleDataSource3();
    }

}
