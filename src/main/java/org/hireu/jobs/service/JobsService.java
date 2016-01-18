package org.hireu.jobs.service;

import org.hireu.jobs.model.Job;

import java.util.List;

/**
 * Created by bacherj on 1/7/16.
 */
public interface JobsService {

    public List<Job> get_jobs_from_campus(String campus);

    public List<Job> get_jobs_from_company(String company);

    public List<Job> get_research_jobs(String company);

    public List<Job> get_top_jobs(String campus, int num);
}
