package model;

import java.util.Objects;

public abstract class Doctor implements Comparable<Doctor>{

    private static int crtIdNo;
    private final int idNo;
    private String firstName;
    private String lastName;

    static {
        crtIdNo = 1;
    }

    public Doctor(String firstName, String lastName)
    {
        idNo = crtIdNo;
        crtIdNo++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIdNo(){
        return idNo;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Override
    public int hashCode(){
        return Objects.hash(idNo);
    }

    @Override
    public abstract boolean equals(final Object ob);

}
