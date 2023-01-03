/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raj3100.projects.certificategenerator;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Oasimul Hasan Raj
 * github.com/hasanraj3100
 * email: oasimulhasanraj@outlook.org
 */
public class FileHandler {
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ArrayList<Certificate> list;
    
    public void addRecord(Certificate record) {
        readRecord();
        list.add(record);
        try {
            output= new ObjectOutputStream(Files.newOutputStream(Paths.get("files/certificatedata.bin")));
            output.writeObject(list);
            if(output!=null) output.close();
        } catch(IOException exception) {
            
        } 
    }
    
    private void readRecord() {
        list= new ArrayList<>();
        try {
            input= new ObjectInputStream(Files.newInputStream(Paths.get("files/certificatedata.bin")));
            list= (ArrayList<Certificate>) input.readObject();
            if(input!=null) input.close();
        } catch(IOException exception) {
            
        } catch(ClassNotFoundException exception) {
            
        }
    }
    
    public ArrayList<Certificate> getArrayList() {
        readRecord();
        return list;
    }
    
    public ArrayList<String> getAllId() {
        readRecord();
        ArrayList<String> idList= new ArrayList<>();
        for(Certificate c: list) {
            idList.add(c.getId());
        }
        
        return idList;
    }
    
    public Certificate findById(String id) {
        readRecord();
        Certificate c= new Certificate("", "", Department.Architecture, "", "", new Date(), Gender.MALE);
        for(Certificate item: list) {
            if(item.getId().equals(id)) {
                c= item;
                break;
            }
        }
        return c;
    }
}
