package ru.mk.models;

public class Group {

    private long id;
    private String groupNumber;
    private String groupName;

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id;  }

    public String getNumber() {
        return groupNumber;
    }

    public void setNumber(String number) {
        this.groupNumber = number;
    }

    public String getName() {
        return groupName;
    }

    public void setName(String groupName) {
        this.groupName = groupName;
    }
}
