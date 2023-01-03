/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raj3100.projects.certificategenerator;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Oasimul Hasan Raj
 * github.com/hasanraj3100
 * email: oasimulhasanraj@outlook.org
 */
public class IdGenerator {
    public static Formatter output;
    public static Scanner input;
    public static int id;
    public static String chars;
    private static Department dept;
    private static String finalId;
    
    private static void readPreviousID() {
        
        try {
            input= new Scanner(Paths.get("files/lastid.txt"));
            if(input.hasNext()) id= input.nextInt();
            input.close();
        } catch(IOException exception) {
            System.err.println("Error Opening lastid.txt");
        }
    }
    
    public static void generate(Department department) {
        readPreviousID();
        dept=department;
        switch(dept) {
            case SoftwareEngineering:
                chars="SE";
                break;
            case ComputerScienceEngineering:
                chars="CSE";
                break;
            case Architecture:
                chars="ARC";
                break;
            case ElectricalEngineering:
                chars="EEE";
                break;
            case LawAndJustice:
                chars="LLB";
        }
        id++;
        finalId= chars+id;
        writeID();
        
    }
    
    private static void writeID() {
        try {
            output= new Formatter("files/lastid.txt");
            output.format("%d", id);
            output.close();
            
        } catch(IOException exception) {
            System.err.println("error opening lastid.txt file");
        } catch(NoSuchElementException exception) {
            System.err.println("No such element");
        }
    }
    
    public static String getNewId() {
        return finalId;
    }
    
}
