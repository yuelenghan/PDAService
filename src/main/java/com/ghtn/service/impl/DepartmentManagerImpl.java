package com.ghtn.service.impl;

import com.ghtn.dao.DepartmentDao;
import com.ghtn.service.DepartmentManager;
import com.ghtn.vo.DepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihe on 14/9/15.
 */
@Service("departmentManager")
public class DepartmentManagerImpl extends GenericManagerImpl implements DepartmentManager {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentManagerImpl(DepartmentDao departmentDao) {
        super(departmentDao);
        this.departmentDao = departmentDao;
    }


    @Override
    public List<DepartmentVO> getAllMainDeptOracleDataSource3() {
        List<Object[]> list = departmentDao.getAllMainDept();
        List<DepartmentVO> returnList = new ArrayList<>();

        if (list != null && list.size() > 0) {
            for (Object[] o : list) {
                DepartmentVO vo = new DepartmentVO();
                vo.setDeptNumber(String.valueOf(o[0]));
                vo.setDeptName(String.valueOf(o[1]));

                returnList.add(vo);
            }
        }

        return returnList;
    }
}
