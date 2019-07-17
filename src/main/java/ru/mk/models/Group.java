package ru.mk.models;

public class Group {

    private int id;
    private String groupNumber;
    private String groupName;

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id;  }

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
