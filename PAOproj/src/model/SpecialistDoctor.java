package model;

public class SpecialistDoctor extends Doctor{

    private String specialization;
    public SpecialistDoctor(String firstName, String lastName, String specialization){
        super(firstName, lastName);
        this.specialization = specialization;
    }

    public String getSpecialization(){
        return specialization;
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
        return "Specialist doctor {" + "idNo: " + getIdNo() +
                ", first name: " + getFirstName() + ", last name: " +
                getLastName() + ", specialization: " + specialization + "}";
    }
}
