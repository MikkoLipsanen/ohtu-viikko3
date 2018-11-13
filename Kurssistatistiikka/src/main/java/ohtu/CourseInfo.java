/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import java.util.ArrayList;

/**
 *
 * @author mclipsan
 */
public class CourseInfo {
    private String name;
    private String fullName;
    private int sum = 0;
    private ArrayList <Integer> exercises = new ArrayList<>();
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public void setExercises(ArrayList exercises) {
        this.exercises = exercises;
    }
    
    public String getName(){
        return name;
    }
    
    public String getFullName(){
        return fullName;
    }
    
    public int getExercises(int week) {
        return exercises.get(week);
    }
    
    public int getTotalExercises(){
        
        for(int i = 1; i < exercises.size(); i++)
            sum += exercises.get(i);
            return sum;
    }
    
}
