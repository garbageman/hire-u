package org.hireu.campus.service;

import org.hireu.campus.model.Campus;
import org.hireu.campus.model.JobCount;

public interface CampusService {

  Campus getCampusFromUrl(String url);

  JobCount getJobCount(String url);

}
