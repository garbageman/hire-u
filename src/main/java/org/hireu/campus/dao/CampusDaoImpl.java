package org.hireu.campus.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Map;

import org.hireu.campus.model.Campus;
import org.hireu.campus.model.JobCount;

/**
 * This is the Dao implementation. A DAO is short for Data Access Object, this is the Object
 * that will get all of the data and parse it from a sql entry to a model. This shouldn't do
 * much "processing" that will happen in the services.
 */
 /* This is marked as @Repository so that spring will create a bean for it */
@Repository
public class CampusDaoImpl implements CampusDao {

  /* jdbcTemplate is spring's jdbc implementation, it will interface with the sql server */
  /* This JdbcTemplate is @Autowired and spring will create a bean for it from the spring-context.xml */
  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  /**
   * This is a basic query into the db using our NamedParamerJDBCTemplate
   * this uses parameter binding to help prevent sql injection
   */
  public Campus getCampusFromUrl(String url) {
    /* Here :campus_url means that the sql statement will be completed */
    /* when the variable :campus_url is filled */
    String sql = "select * from campus where url = :campus_url";

    /* Here campus_url is mapped to the url parameter */
    Map<String, String> namedParameters = Collections.singletonMap("campus_url", url);

    /* This returns the object found from the query using a row mapper that is written below */
    return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, CampusDaoImpl.campusMapper());
  }

  /* This is another service that gets the total number of jobs of the campus */
  public JobCount getJobCount(String url) {
    String sql = "select count(*) as count from jobs where url = :campus_url and is_hiring = true";

    Map<String, String> namedParameters = Collections.singletonMap("campus_url", url);

    return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, CampusDaoImpl.jobCountMapper());
  }

  /* This method returns an anonymous rowMapper that maps a resultset row*/
  /* to a jobcount model instance */
  private static RowMapper<JobCount> jobCountMapper() {

    return new RowMapper<JobCount>() {
      public JobCount mapRow(ResultSet rs, int rowNum) {
        try {
          return new JobCount(rs.getInt("count"));
        } catch (java.sql.SQLException s) {
                s.printStackTrace();
        }

        return null;
      }
    };

  }

  /* This method returns an anonymous rowMapper that maps a resultset row*/
  /* to a campus model instance */
  private static RowMapper<Campus> campusMapper() {

    return new RowMapper<Campus>() {
      public Campus mapRow(ResultSet rs, int rowNum) {
        try {
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
