package org.hireu.jobs.dao;


import org.hireu.jobs.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by bacherj on 1/10/16.
 */

@Repository
public class JobsDaoImpl implements JobsDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Job> get_jobs_from_campus(String campus) {
        String sql = "select * from jobs where url = :campus_url";

        Map<String, String> nameParameters = Collections.singletonMap("campus_url",campus);

        return namedParameterJdbcTemplate.query(sql, nameParameters, JobsDaoImpl.jobMapper());
    }

    @Override
    public List<Job> get_jobs_from_company(String company) {
        String sql = "select * from jobs where dept_name = :dept_name";

        Map<String, String> namedParameters = Collections.singletonMap("dept_name",company);

        return namedParameterJdbcTemplate.query(sql, namedParameters, JobsDaoImpl.jobMapper());
    }

    @Override
    public List<Job> get_research_jobs(String company) {
        String sql = "select * from jobs where ";

        return null;
    }

    @Override
    public List<Job> get_top_jobs(String campus, int num) {
        return null;
    }

    private static RowMapper<Job> jobMapper() {

        return new RowMapper<Job>() {
            public Job mapRow(ResultSet rs, int rowNum) {
                try {
                    return new Job(rs.getString("url"),
                            rs.getString("dept_name"),
                            rs.getString("description"),
                            rs.getBoolean("is_hiring"),
                            rs.getString("uid"),
                            rs.getString("contact"),
                            rs.getString("name"));
                } catch (java.sql.SQLException s) {
                    s.printStackTrace();
                }

                return null;
            }
        };

    }
}
