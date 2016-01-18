package org.hireu.campus.service;

import org.hireu.campus.dao.CampusDao;
import org.hireu.campus.model.Campus;
import org.hireu.campus.model.JobCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* This class is again marked with @Service so that spring knows to create a bean */
@Service
public class CampusServiceImpl implements CampusService {

  /* Use the campusDao bean that has been created for accessing the database */
  @Autowired
  CampusDao campusDao;

  @Override
  public Campus getCampusFromUrl(String url) {
    /* This simply returns the campus information from the dao */
    /* There can always be post processing done in the services */
    return campusDao.getCampusFromUrl(url);
  }

  @Override
  public JobCount getJobCount(String url) {
    return campusDao.getJobCount(url);
  }

  @Override
  public List<Campus> getAll() {
    return campusDao.getAllCampus();
  }

}
