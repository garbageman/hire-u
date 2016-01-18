package org.hireu.deparments.dao;

import org.hireu.deparments.model.Department;

import java.util.List;

/**
 * Created by bacherj on 1/18/16.
 */
public interface DepartmentsDao {

    public List<Department> getAll(String url);
}
