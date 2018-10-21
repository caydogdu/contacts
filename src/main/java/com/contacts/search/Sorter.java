package com.contacts.search;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sorter {

    private String key;

    private String dir;

    public Sorter() {
        // default cons
    }

    public Sorter(String key, String dir) {
        this.key = key;
        this.dir = dir;
    }

    public String getDir() {
        return dir;
    }

    public String getKey() {
        return key;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
