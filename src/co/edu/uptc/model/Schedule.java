package co.edu.uptc.model;

public class Schedule {
    private String days;
    private String initialTime;
    private String finalTime;

    
    public Schedule(String days, String initialTime, String finalTime) {
        this.days = days;
        this.initialTime = initialTime;
        this.finalTime = finalTime;
    }

    public String getDays() {
        return days;
    }
    public void setDays(String days) {
        this.days = days;
    }
    public String getInitialTime() {
        return initialTime;
    }
    public void setInitialTime(String initialTime) {
        this.initialTime = initialTime;
    }
    public String getFinalTime() {
        return finalTime;
    }
    public void setFinalTime(String finalTime) {
        this.finalTime = finalTime;
    }

    @Override
    public String toString() {
        return "Horario [days=" + days + ", initialTime=" + initialTime + ", finalTime=" + finalTime + "]";
    }

    
    

}
