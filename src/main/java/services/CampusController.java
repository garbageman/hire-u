package services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.hireu.campus.service.CampusService;
import org.hireu.campus.model.Campus;

@RestController
public class CampusController {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @RequestMapping("/campus")
  public Campus campus(@RequestParam(value="url", defaultValue="umd") String url) {
      String sql = "select * from campus where url=\'" + url + "\';";

      return jdbcTemplate.query(sql, CampusService.campusMapper());
  }

}
