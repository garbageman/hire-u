package org.hireu.campus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.hireu.campus.dao.CampusDao;
import org.hireu.campus.model.Campus;

@Service
public class CampusServiceImpl implements CampusService {

  @Autowired
  CampusDao campusDao;

  @Override
  public Campus getCampusFromUrl(String url) {
    return campusDao.getCampusFromUrl(url);
  }

}
