package model;

public class FamilyDoctor extends Doctor{

    public FamilyDoctor(String firstName, String lastName){
        super(firstName, lastName);
    }

    @Override
    public int compareTo(final Doctor doctor) throws NullPointerException {
        if(doctor == null)
            throw new NullPointerException();
        return Integer.compare(getIdNo(), doctor.getIdNo());
    }

    @Override
    public boolean equals(final Object ob){
        if(this == ob)
            return true;
        if(ob == null || getClass() != ob.getClass())
            return false;
        final Doctor doctor = (Doctor) ob;
        return getIdNo() == doctor.getIdNo();
    }

    @Override
    public String toString(){
        return "Family doctor {" + "idNo: " + getIdNo() +
                ", first name: " + getFirstName() + ", last name: " +
                getLastName() + "}";
    }


}
