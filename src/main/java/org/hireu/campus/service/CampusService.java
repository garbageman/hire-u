package org.hireu.campus.service;

import org.hireu.campus.model.Campus;
import org.hireu.campus.model.JobCount;

import java.util.List;

/* This is the interface for the campus services */
public interface CampusService {

  /**
   * Returns the campus information for the given url
   */
  Campus getCampusFromUrl(String url);

  /**
   * Returns the job count for the given url
   */
  JobCount getJobCount(String url);

  List<Campus> getAll();

}
