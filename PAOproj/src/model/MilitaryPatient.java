package model;

public class MilitaryPatient extends Patient {

    private String grade;
    public MilitaryPatient(int doctorIdNo, String firstName, String lastName, int age, int weight, double height, String grade){
        super(doctorIdNo, firstName, lastName, age, weight, height);
        this.grade = grade;
    }

    public String getGrade(){
        return grade;
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
        return "Military patient {" + "SSN: " + getSSN() +
                ", first name: " + getFirstName() + ", last name: " +
                getLastName() + ", age: " + getAge() + ", weight: " +
                getWeight() + ", height: " + getHeight() + ", grade: " +
                grade + ", doctorIdNo: " + getDoctorIdNo() + "}";
    }
}
