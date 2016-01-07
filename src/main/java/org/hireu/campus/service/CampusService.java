package org.hireu.campus.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import java.sql.ResultSet;
import org.hireu.campus.model.Campus;

public class CampusService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * Returns a ResultSetExtractor that creates a campus from
   * the result set
   */
  public static ResultSetExtractor<Campus> campusMapper() {
    return new ResultSetExtractor<Campus>() {
      public Campus extractData(ResultSet rs) {
        try {
        rs.next();
        return new Campus(rs.getString("university"),
                          rs.getString("city"),
                          rs.getString("state"));
        } catch (java.sql.SQLException s) {
                s.printStackTrace();
        }

        return null;
      }
    };
  }

}
