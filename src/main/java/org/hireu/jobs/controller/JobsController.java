package org.hireu.jobs.controller;

import org.hireu.jobs.model.Job;
import org.hireu.jobs.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by bacherj on 1/7/16.
 */
@RestController
@RequestMapping("/positions")
public class JobsController {

    @Autowired
    JobsService jobsService;

    @RequestMapping("/oncampus")
    public ArrayList<Job> campusJobs(@RequestParam (value="url", defaultValue = "umd") String campus) {
        return jobsService.get_jobs_from_campus(campus);
    }

    @RequestMapping("/company")
    public ArrayList<Job> companyJobs(@RequestParam(value="url",defaultValue = "HireU")String company) {
        return jobsService.get_jobs_from_company(company);
    }

    @RequestMapping("/research")
    public ArrayList<Job> researchJobs(@RequestParam(value="url",defaultValue = "umd")String campus) {
        return jobsService.get_jobs_from_company(campus);
    }

    @RequestMapping("/company")
    public ArrayList<Job> topCampusJobs(@RequestParam(value="url",defaultValue = "HireU")String campus,
                                        @RequestParam(value="num", defaultValue = "10") int num) {
        return jobsService.get_jobs_from_company(campus, num);
    }

}
