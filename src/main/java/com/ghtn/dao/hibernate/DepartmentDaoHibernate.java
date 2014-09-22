package com.ghtn.dao.hibernate;

import com.ghtn.dao.DepartmentDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lihe on 14/9/15.
 */
@Repository("departmentDao")
public class DepartmentDaoHibernate extends GenericDaoHibernate implements DepartmentDao {


    @Override
    public List<Object[]> getAllMainDept() {
        String sql = "select deptnumber, deptname from view_department where dlevel = 175";
        sql += " order by dsort";
        return querySql(sql);
    }
}
