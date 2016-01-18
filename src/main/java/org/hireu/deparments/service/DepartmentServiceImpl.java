package org.hireu.deparments.service;

import org.hireu.deparments.dao.DepartmentsDao;
import org.hireu.deparments.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bacherj on 1/18/16.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentsDao departmentsDao;

    @Override
    public List<Department> getAllDepartment(String url) {
        return departmentsDao.getAll(url);
    }
}
