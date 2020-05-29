package model;


import java.util.Objects;

public class Prescription implements Comparable<Prescription>{
    private static int crtIndex;
    private final int index;
    private final String medication;
    private final int prescribingDoctorIdNo;

    static {
        crtIndex = 1;
    }

    public Prescription(String medication, int prescribingDoctorIdNo){
        index = crtIndex;
        crtIndex++;
        this.medication = medication;
        this.prescribingDoctorIdNo = prescribingDoctorIdNo;
    }

    public int getIndex(){
        return index;
    }

    public String getMedication(){
        return medication;
    }

    public int getPrescribingDoctorIdNo(){
        return prescribingDoctorIdNo;
    }

    @Override
    public int hashCode(){
        return Objects.hash(index);
    }


    @Override
    public int compareTo(final Prescription prescription) throws NullPointerException{
        if(prescription == null)
            throw new NullPointerException();
        return Integer.compare(index, prescription.getIndex());
    }

    @Override
    public boolean equals(final Object ob){
        if(this == ob)
            return true;
        if(ob == null || getClass() != ob.getClass())
            return false;
        final Prescription prescription = (Prescription) ob;
        return index == prescription.getIndex();
    }

    @Override
    public String toString(){
        return "Prescription {" + "index: " + index +
                ", medication: " + medication + ", prescribing doctorIdNo: " +
                prescribingDoctorIdNo + "}";
    }
}
