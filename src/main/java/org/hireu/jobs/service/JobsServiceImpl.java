package org.hireu.jobs.service;

import org.hireu.jobs.dao.JobsDao;
import org.hireu.jobs.model.Job;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created by bacherj on 1/8/16.
 */
public class JobsServiceImpl implements JobsService{

    @Autowired
    JobsDao jobsDao;

    @Override
    public ArrayList<Job> get_jobs_from_campus(String campus) {
        return null;
    }

    @Override
    public ArrayList<Job> get_jobs_from_company(String company) {
        return null;
    }

    @Override
    public ArrayList<Job> get_research_jobs(String company) {
        return null;
    }

    @Override
    public ArrayList<Job> get_top_jobs(String campus) {
        return null;
    }
}
