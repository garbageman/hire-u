package org.hireu.jobs.controller;

import org.hireu.jobs.model.Job;
import org.hireu.jobs.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by bacherj on 1/7/16.
 */
@RestController
@RequestMapping("/positions")
public class JobsController {

    @Autowired
    JobsService jobsService;

    @RequestMapping("/oncampus")
    public List<Job> campusJobs(@RequestParam (value="url", defaultValue = "umd") String campus) {
        return jobsService.get_jobs_from_campus(campus);
    }

    @RequestMapping("/company")
    public List<Job> companyJobs(@RequestParam(value="url",defaultValue = "HireU")String company) {
        return jobsService.get_jobs_from_company(company);
    }

    @RequestMapping("/research")
    public List<Job> researchJobs(@RequestParam(value="url",defaultValue = "umd")String campus) {
        return jobsService.get_research_jobs(campus);
    }

    @RequestMapping("/topJobs")
    public List<Job> topCampusJobs(@RequestParam(value="url",defaultValue = "HireU")String campus,
                                        @RequestParam(value="num", defaultValue = "10") int num) {
        return jobsService.get_top_jobs(campus, num);
    }

}
