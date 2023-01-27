package com.orangeandbronze.enlistment;

import org.apache.commons.lang3.Validate;

import java.util.*;

public class Student {
    private final int studentNumber;
    private final Collection<Section> sections = new HashSet<>();

    Student(int studentNumber, Collection<Section> sections){
        if(studentNumber < 0){
            throw new IllegalArgumentException("studentNumber should be non-negative, was: " + studentNumber);
        }
        this.studentNumber=studentNumber;
        this.sections.addAll(sections);
        this.sections.removeIf(Objects::isNull);
    }

    void enlist(Section newSection){
        Validate.notNull(newSection);
        this.sections.forEach((currSection)-> currSection.checkForConflict(newSection));
        this.sections.add(newSection);
    }

    Collection<Section> getSections(){
        return new ArrayList<>(sections);
    }

    Student(int studentNumber){
        if(studentNumber < 0){
            throw new IllegalArgumentException("studentNumber should be non-negative, was: " + studentNumber);
        }
        this.studentNumber=studentNumber;
        this.sections.addAll(Collections.emptyList());
    }

    @Override
    public String toString(){
        return "Student#" + studentNumber;
    }

    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if (o== null || getClass()!= o.getClass()) return false;
        Student student = (Student) o;
        return studentNumber == student.studentNumber;
    }

    @Override
    public int hashCode(){
        return studentNumber;
    }
}
