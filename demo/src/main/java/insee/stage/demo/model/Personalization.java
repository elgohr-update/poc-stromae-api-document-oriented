package insee.stage.demo.model;

import java.util.Date;

public class Personalization {

    private String idStateData;
    private Date date;
    private String state;
    private int currentPage;

    public Personalization(String idStateData, Date date, String state, int currentPage) {
        this.idStateData = idStateData;
        this.date = date;
        this.state = state;
        this.currentPage = currentPage;
    }

    public String getIdStateData() {
        return idStateData;
    }

    public void setIdStateData(String idStateData) {
        this.idStateData = idStateData;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
