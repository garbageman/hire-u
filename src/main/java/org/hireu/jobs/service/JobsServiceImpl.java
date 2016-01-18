package org.hireu.jobs.service;

import org.hireu.jobs.dao.JobsDao;
import org.hireu.jobs.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bacherj on 1/8/16.
 */
@Service
public class JobsServiceImpl implements JobsService{

    @Autowired
    JobsDao jobsDao;

    @Override
    public List<Job> get_jobs_from_campus(String campus) {
        return jobsDao.get_jobs_from_campus(campus);
    }

    @Override
    public List<Job> get_jobs_from_company(String company) {
        return null;
    }

    @Override
    public List<Job> get_research_jobs(String company) {
        return null;
    }

    @Override
    public List<Job> get_top_jobs(String campus, int num) {
        return null;
    }
}
