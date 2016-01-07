package org.hireu.campus.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;

import org.hireu.campus.model.Campus;
import org.hireu.campus.model.JobCount;

@Repository
public class CampusDaoImpl implements CampusDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public Campus getCampusFromUrl(String url) {
    String sql = "select * from campus where url=\'" + url + "\';";

    return jdbcTemplate.query(sql, CampusDaoImpl.campusMapper());
  }

  public JobCount getJobCount(String url) {
    String sql = "select count(*) as count from jobs where url=\'" + url + "\' and is_hiring=true;";

    return jdbcTemplate.query(sql, CampusDaoImpl.jobCountMapper());
  }

  private static ResultSetExtractor<JobCount> jobCountMapper() {

    return new ResultSetExtractor<JobCount>() {
      public JobCount extractData(ResultSet rs) {
        try {
        rs.next();
        return new JobCount(rs.getInt("count"));
        } catch (java.sql.SQLException s) {
                s.printStackTrace();
        }

        return null;
      }
    };

  }

  /**
   * Returns a ResultSetExtractor that creates a campus from
   * the result set
   */
  private static ResultSetExtractor<Campus> campusMapper() {

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
