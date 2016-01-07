package org.hireu.campus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import org.hireu.campus.service.CampusService;
import org.hireu.campus.model.Campus;
import org.hireu.campus.model.JobCount;

@RestController
public class CampusController {

  @Autowired
  CampusService campusService;

  @RequestMapping("/campus")
  public Campus campus(@RequestParam(value="url", defaultValue="umd") String url) {
      return campusService.getCampusFromUrl(url);
  }

  @RequestMapping("/jobcount")
  public JobCount jobcount(@RequestParam(value="url", defaultValue="umd") String url) {
      return campusService.getJobCount(url);
  }


}
