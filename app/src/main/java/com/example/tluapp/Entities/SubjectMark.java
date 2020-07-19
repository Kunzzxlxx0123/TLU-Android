package com.example.tluapp.Entities;

import java.io.Serializable;

public class SubjectMark implements Serializable {
    private String subName;
    private String subMark;
    private String strMark;

    public SubjectMark() {
    }

    public SubjectMark(String subName, String subMark, String strMark) {
        this.subName = subName;
        this.subMark = subMark;
        this.strMark = strMark;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubMark() {
        return subMark;
    }

    public void setSubMark(String subMark) {
        this.subMark = subMark;
    }

    public String getStrMark() {
        return strMark;
    }

    public void setStrMark(String strMark) {
        this.strMark = strMark;
    }

    @Override
    public String toString() {
        return "SubjectMark{" +
                "subName='" + subName + '\'' +
                ", subMark='" + subMark + '\'' +
                ", strMark='" + strMark + '\'' +
                '}';
    }
}
