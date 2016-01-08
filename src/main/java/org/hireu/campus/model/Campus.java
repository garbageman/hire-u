package org.hireu.campus.model;

/**
 * This is the model for campus information
 * the accessor methods when written like getVariablename()
 * will cause the returned json to contain variablename : variableValue
 * so in this campus there could be an entry like: university : "University of Maryland - College Park"
 */
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
