package org.models;

public class GhostRecord {

    private String title;
    private String location;
    private String coord;
    private String author;
    private String recordType;
    private String record;
    private String source;

    // CONs
    public GhostRecord() {
    }

    public GhostRecord(String title, String location, String coord, String author, String recordType, String record, String source) {
        this.title = title;
        this.location = location;
        this.coord = coord;
        this.author = author;
        this.recordType = recordType;
        this.record = record;
        this.source = source;
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
    public String getSource() {
        return source;
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
    public void setSource(String source){
        this.source = source;
    }
}
