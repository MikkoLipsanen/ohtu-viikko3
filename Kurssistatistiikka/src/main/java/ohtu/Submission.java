package ohtu;

import java.util.ArrayList;

public class Submission {
    private int week = 0;
    private int hours = 0;
    private int sum = 0; 
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
    
    public ArrayList getExercises() {
        return exercises;
    }
    
    public int exercisesDone(){
        return exercises.size();
    }
    
    public String getCourse() {
        return course;
    }

    //@Override
    //public String toString() {
    //    return "viikko " +week+":\n\t tehtyjä tehtäviä " +exercises.size()+ "/"  course+", viikko " " tehtyjä tehtäviä yhteensä "  " aikaa kului " +hours+ " tehdyt tehtävät: " +exercises.toString().replace("[","").replace("]","");
    //}
    
}