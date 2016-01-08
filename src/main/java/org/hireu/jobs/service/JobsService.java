package org.hireu.jobs.service;

import org.hireu.jobs.dao.JobsDao;
import org.hireu.jobs.model.Job;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created by bacherj on 1/7/16.
 */
public interface JobsService {

    public ArrayList<Job> get_jobs_from_campus(String campus);

    public ArrayList<Job> get_jobs_from_company(String company);

    public ArrayList<Job> get_research_jobs(String company);

    public ArrayList<Job> get_top_jobs(String campus, )
}
