package org.hireu.deparments.dao;

import org.hireu.deparments.model.Department;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by bacherj on 1/18/16.
 */
@Repository
public class DepartmentsDaoImpl implements DepartmentsDao{
    @Override
    public List<Department> getAll(String url) {
        String sql = "select * from departments where url = :campus";

        Map<String,String> nameParams = Collections.singletonMap("campus", url);

        return null;
    }
}
