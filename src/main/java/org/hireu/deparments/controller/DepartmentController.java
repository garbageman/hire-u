package org.hireu.deparments.controller;

import org.hireu.deparments.model.Department;
import org.hireu.deparments.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by bacherj on 1/18/16.
 */
@RestController
@RequestMapping("/services/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/campus")
    public List<Department> getAllDepartments(@RequestParam(value = "url",defaultValue = "umd") String url) {
        return departmentService.getAllDepartment(url);
    }
}
