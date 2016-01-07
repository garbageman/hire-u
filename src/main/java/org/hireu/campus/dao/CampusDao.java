package org.hireu.campus.dao;

import org.hireu.campus.model.Campus;
import org.hireu.campus.model.JobCount;

public interface CampusDao {

  Campus getCampusFromUrl(String url);

  JobCount getJobCount(String url);
}
