package com.arunan.joblisting.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

@Document(collection = "JobPost")
public class JobPost {
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;
    public JobPost() {
    }



    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "profile='" + profile + '\'' +
                ", description='" + desc + '\'' +
                ", experience=" + exp +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }






}
