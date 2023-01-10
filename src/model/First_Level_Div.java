package model;

public class First_Level_Div extends Countries{
    protected int divisionID;
    private String division;

    public First_Level_Div() {
        super();
        this.divisionID = getDivisionID();
    }

    public int getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
