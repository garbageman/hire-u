package org.hireu.deparments.service;

import org.hireu.deparments.model.Department;

import java.util.List;

/**
 * Created by bacherj on 1/18/16.
 */
public interface DepartmentService {
    public List<Department> getAllDepartment(String url);
}
