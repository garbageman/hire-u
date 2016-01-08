package org.hireu.jobs.model;

/**
 * Created by bacherj on 1/7/16.
 */
public class Job {

    /*url, dept_name, description, is_hiring, uid, contact, name*/
    private final String url;
    private final String deptName;
    private final String description;
    private final boolean is_hiring;
    private final String uid;
    private final String contact;
    private final String jobTitle;


    public Job(String url, String deptName, String description, boolean is_hiring, String uid, String contact,
               String jobTitle) {
        this.url = url;
        this.deptName = deptName;
        this.description = description;
        this.is_hiring = is_hiring;
        this.uid = uid;
        this.contact = contact;
        this.jobTitle = jobTitle;
    }

    public String getUrl() {
        return url;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDescription() {
        return description;
    }

    public boolean is_hiring() {
        return is_hiring;
    }

    public String getUid() {
        return uid;
    }

    public String getContact() {
        return contact;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
