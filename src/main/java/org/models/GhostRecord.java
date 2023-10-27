package org.models;

public class GhostRecord {

    private String title;
    private String location;
    private String coord;
    private String author;
    private String recordType;
    private String record;

    // CONs
    public GhostRecord() {
    }

    public GhostRecord(String title, String location, String coord, String author, String recordType, String record) {
        this.title = title;
        this.location = location;
        this.coord = coord;
        this.author = author;
        this.recordType = recordType;
        this.record = record;
    }

    // GETs
    public String getTitle() {
        return title;
    }
    public String getLocation() {
        return location;
    }
    public String getCoord() {
        return coord;
    }
    public String getAuthor() {
        return author;
    }
    public String getRecordType() {
        return recordType;
    }
    public String getRecord() {
        return record;
    }

    // SETs
    public void setTitle(String title) {
        this.title = title;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setCoord(String coord) {
        this.coord = coord;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }
    public void setRecord(String record) {
        this.record = record;
    }
}
