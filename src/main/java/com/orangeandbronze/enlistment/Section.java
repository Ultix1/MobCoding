package com.orangeandbronze.enlistment;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.Validate.*;
import java.util.Objects;

public class Section {
    private final String sectionId;
    private final Schedule schedule;


    Section(String sectionId, Schedule schedule){
        notBlank(sectionId);
        isTrue(isAlphanumeric(sectionId),"sectionId must be alphanumeric, was: "+sectionId);
        //validation for days
        //validation for startTime
        notNull(schedule);
        this.sectionId = sectionId;
        this.schedule = schedule;
    }

    boolean hasConflict(Section other){
        return this.schedule.equals(other.schedule);
    }

    void checkForConflict(Section other){
        if(this.schedule.equals(other.schedule)){
            throw new ScheduleConflictException("Current section "+ this
                    + "has same schedule as new section"+ other
                    +" at schedule "+ this);
        }
    }
    @Override
    public String toString(){
        return sectionId;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        return Objects.equals(sectionId, section.sectionId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(sectionId);
    }
}

