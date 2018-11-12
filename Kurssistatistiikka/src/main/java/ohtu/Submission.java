package ohtu;

import java.util.ArrayList;

public class Submission {
    private int week;
    private int hours;
    private ArrayList <Integer> exercises = new ArrayList<>();
    private String course;

    public void setWeek(int week) {
        this.week = week;
    }
    
    public void setHours(int hours) {
        this.hours = hours;
    }
    
    public void setExercises(ArrayList exercises) {
        this.exercises = exercises;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public int getWeek() {
        return week;
    }
    
    public int getHours() {
        return hours;
    }
    
    public int getExercises() {
        return exercises.size();
    }
    
    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return course+", viikko " +week+ " tehtyjä tehtäviä yhteensä " +exercises.size()+ " aikaa kului " +hours+ " tehdyt tehtävät: " +exercises.toString().replace("[","").replace("]","");
    }
    
}