package com.orangeandbronze.enlistment;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.Validate.*;
import java.util.Objects;

public class Section {
    private final String sectionId;

    Section(String sectionId){
        notBlank(sectionId);
        isTrue(isAlphanumeric(sectionId),"sectionId must be alphanumeric, was: "+sectionId);

        this.sectionId=sectionId;
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
