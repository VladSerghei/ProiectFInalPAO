package model;

public class AppointmentPrescription extends Prescription {

    private int appointedDoctorIdNo;
    public AppointmentPrescription(String medication, int prescribingDoctorIdNo, int appointedDoctorIdNo){
        super(medication,prescribingDoctorIdNo);
        this.appointedDoctorIdNo = appointedDoctorIdNo;
    }

    public int getAppointedDoctorIdNo(){
        return appointedDoctorIdNo;
    }

    @Override
    public String toString(){
        return "Prescription {" + "index: " + getIndex() +
                ", medication: " + getMedication() + ", prescribing doctor: " +
                getPrescribingDoctorIdNo() + ", appointed doctorIdNo: " + appointedDoctorIdNo + "}";
    }

}
