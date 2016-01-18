package org.hireu.campus.dao;

import org.hireu.campus.model.Campus;
import org.hireu.campus.model.JobCount;

import java.util.List;

/**
 * This is the interface for the dao, it is good to create an interface so the
 * implementation can always be swapped out easily
 */
public interface CampusDao {

  Campus getCampusFromUrl(String url);

  JobCount getJobCount(String url);

  List<Campus> getAllCampus();
}
