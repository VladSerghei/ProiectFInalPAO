package model;


import java.util.Objects;

public abstract class Patient implements Comparable<Patient>{

    private static int SSNindex;
    private final int SSN;
    private int doctorIdNo;
    private String firstName;
    private String lastName;
    private int age;
    private  int weight;
    private double height;

    static{
        SSNindex = 1;
    }

    public Patient(int doctorIdNo, String firstName, String lastName, int age, int weight, double height){
        SSN = SSNindex;
        SSNindex++;

        this.doctorIdNo = doctorIdNo;

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
        this.height = height;

    }

    public int getSSN(){
        return SSN;
    }

    public int getDoctorIdNo(){
        return doctorIdNo;
    }

    public void setDoctorIdNo(int doctorIdNo){
        this.doctorIdNo = doctorIdNo;
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

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

   public double getHeight(){
        return height;
   }

   public void setHeight(double height){
        this.height = height;
   }

    @Override
    public int hashCode(){
        return Objects.hash(SSN);
    }

    @Override
    public abstract boolean equals(final Object ob);
}
