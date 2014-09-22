package com.ghtn.dao;

import java.util.List;

/**
 * Created by lihe on 14/9/15.
 */
public interface DepartmentDao extends GenericDao {

    List<Object[]> getAllMainDept();

}
