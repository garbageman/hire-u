package org.hireu.department.model;

public class Department {

  private final String campus;
  private final String name;
  private final String location;

  public Department(String campus, String name, String location) {
    this.campus = campus;
    this.name = name;
    this.location = location;
  }

  public String getCampus() {
    return campus;
  }

  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

}
