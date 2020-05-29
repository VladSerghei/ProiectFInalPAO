package model;

public class CivilPatient extends Patient {

    public CivilPatient(int doctorIdNo, String firstName, String lastName, int age, int weight, double height){
        super(doctorIdNo, firstName, lastName, age, weight, height);
    }

    @Override
    public int compareTo(final Patient patient) throws NullPointerException {
        if(patient == null)
            throw new NullPointerException();
        return Integer.compare(getSSN(), patient.getSSN());
    }

    @Override
    public boolean equals(final Object ob){
        if(this == ob)
            return true;
        if(ob == null || getClass() != ob.getClass())
            return false;
        final Patient patient = (Patient) ob;
        return getSSN() == patient.getSSN();
    }

    @Override
    public String toString(){
        return "Civil patient {" + "SSN: " + getSSN() +
                ", first name: " + getFirstName() + ", last name: " +
                getLastName() + ", age: " + getAge() + ", weight: " +
                getWeight() + ", height: " + getHeight() + ", doctorIdNo: " +
                getDoctorIdNo() + "}";
    }
}
