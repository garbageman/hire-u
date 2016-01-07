package services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.hireu.department.model.Department;

@RestController
public class DepartmentController {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @RequestMapping("/department")
  public Department greeting(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="campus", defaultValue="University of Maryland") String campus) {
      return new Department("UMD", "OIT", "Mitchell");
  }


}
