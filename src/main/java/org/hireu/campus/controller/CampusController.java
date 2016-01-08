package org.hireu.campus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import org.hireu.campus.service.CampusService;
import org.hireu.campus.model.Campus;
import org.hireu.campus.model.JobCount;

/**
 * This is the controller for the campus endpoints. All this does is return
 * the model that is associated with that particular endpoint. The RequestMapping
 * dictates what the start of the url of the endpoints associated with this controller
 * will be, so they will look like localhost:8080/campus/_______
 */
 /* This is marked as @RestController so that when spring scans the package to create beans */
 /* It will create a bean for this class */
@RestController
@RequestMapping("/campus")
public class CampusController {

  /* The services are autowired so the same instance of services is shared */
  @Autowired
  CampusService campusService;

  /* This endpoint gets basic info about the campus. */
  /* The @RequestMapping annotation determines what the url looks like to get to this endpoint */
  /* In this situation the url will look like localhost:8080/campus/info if hosted locally */
  /* The @RequestParam annotation determines what parameters are allowed for this endpoint */
  /* The value is name of the variable and the defaultValue is what the variable's value will be if a value is not specified */
  /* If there is no defaultValue then if the variable is not specified it will cause an error */
  /* For this endpoint a url that is searching for info about umd would look like: */
  /* localhost:8080/campus/info?url=umd */
  @RequestMapping("/info")
  public Campus campus(@RequestParam(value="url", defaultValue="umd") String url) {
      /* Now that we have a url parameter we return what the service */
      /* finds when getting a campus from a url */
      return campusService.getCampusFromUrl(url);
  }

  @RequestMapping("/jobcount")
  public JobCount jobcount(@RequestParam(value="url", defaultValue="umd") String url) {
      return campusService.getJobCount(url);
  }


}
