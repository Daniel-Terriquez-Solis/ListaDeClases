package com.computomovil.inflationfetish;

public class Clase {
    private int id;
    private String name;
    private int hourStart;
    private int hourEnd;
    private boolean attended;
    private boolean happened;

    public Clase(){

    }

    public Clase(int id, String name, int hourStart, int hourEnd,boolean attended, boolean happened){
        this.id = id;
        this.name = name;
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
        this.attended = attended;
        this.happened = happened;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHourStart() {
        return hourStart;
    }

    public void setHourStart(int hourStart) {
        this.hourStart = hourStart;
    }

    public int getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(int hourEnd) {
        this.hourStart = hourEnd;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public boolean isHappened() {
        return happened;
    }

    public void setHappened(boolean happened) {
        this.happened = happened;
    }
}
