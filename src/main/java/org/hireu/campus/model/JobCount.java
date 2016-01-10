package org.hireu.campus.model;

/* This is also a very simple model the Json returned looks like: */
/* { count : 5 } if the number of available jobs is 5 */
public class JobCount {

  private int count;

  public JobCount(int count) {
    this.count = count;
  }

  public int getCount() {
    return count;
  }

}
