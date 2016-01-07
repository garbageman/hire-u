package org.hireu.campus.model;

public class Campus {

    private final String university;
    private final String city;
    private final String state;

    public Campus(String university, String city, String state) {
        this.university = university;
        this.city = city;
        this.state = state;
    }

    public String getUniversity() {
        return this.university;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }
}
