/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author manhn
 */
public class Student {
    private int idStudent;
    private String name;
    private boolean gender;
    
    public Student(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
    }
    
    public Student(int id, String name, boolean gender) {
        this.idStudent = id;
        this.name = name;
        this.gender = gender;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
