/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raj3100.projects.certificategenerator;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Oasimul Hasan Raj
 * github.com/hasanraj3100
 * email: oasimulhasanraj@outlook.org
 */
public class Certificate implements Serializable{
    private final String id;
    private final String name;
    private final Department department;
    private final String course;
    private final String score;
    private final Date date;
    private final Gender gender;
    
    public Certificate(String id, String name, Department department,String course, String score, Date date, Gender gender) {
        this.id= id;
        this.name=name;
        this.department= department;
        this.course=course;
        this.score=score;
        this.date= date;
        this.gender= gender;
    }
    
    
    public String getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Department getDepartment() {
        return this.department;
    }
    
    public String getCourse() {
        return this.course;
    }
    
    public String getScore() {
        return this.score;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    
    public Gender getGender() {
        return this.gender;
    }
}
