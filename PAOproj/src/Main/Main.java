package Main;
import model.*;
import service.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final DoctorService doctorService = DoctorService.getInstance();
        final DoctorServiceInOut doctorServiceInOut = DoctorServiceInOut.getInstance();
        final PatientService patientService = PatientService.getInstance();
        final PatientServiceInOut patientServiceInOut = PatientServiceInOut.getInstance();
        final PrescriptionService prescriptionService = PrescriptionService.getInstance();
        final PrescriptionServiceInOut prescriptionServiceInOut = PrescriptionServiceInOut.getInstance();

        System.out.println(doctorService.getDoctors());
        Doctor doctor = new FamilyDoctor("Dorian","Gray");
        Doctor doctor1 = new SpecialistDoctor("David", "Dabija", "Chirurg");
        doctorService.addDoctor(doctor);
        doctorService.addDoctor(doctor1);
        System.out.println(doctorService.getDoctors());
        doctorService.removeDoctor(2);
        System.out.println(doctorService.getDoctors());
        doctorService.setDoctorFirstName(1,"Ionut");
        doctorService.setDoctorLastName(1,"Robu");
        System.out.println(doctorService.getDoctors());
        System.out.println(doctorService.getDoctorById(1));
        System.out.println(doctorService.getDoctorsByFirstName("Ionut"));
        System.out.println(doctorService.getDoctorsByLastName("Robu"));
        System.out.println(doctorService.getFamilyDoctors());
        System.out.println(doctorService.getSpecialistDoctors());


        System.out.println(patientService.getPatients());
        Patient patient = new CivilPatient(2,"Ionel","Ionescu",55,86,1.87);
        Patient patient1 = new MilitaryPatient(1,"Alex","Tolstoi",36, 95, 1.75, "General");
        patientService.add(patient);
        patientService.add(patient1);
        System.out.println(patientService.getPatients());
        patientService.remove(2);
        System.out.println(patientService.getPatients());
        patientService.setPatientFirstName(1,"Viorel");
        patientService.setPatientLastName(1,"Florescu");
        patientService.setPatientAge(1,20);
        patientService.setPatientWeight(1,50);
        patientService.setPatientHeight(1,1.88);
        System.out.println(patientService.getPatients());
        System.out.println(patientService.getCivilPatients());
        System.out.println(patientService.getMilitaryPatients());
        System.out.println(patientService.getPatientBySSN(1));
        System.out.println(patientService.getPatientsByFirstName("Viorel"));
        System.out.println(patientService.getPatientsByLastName("Florescu"));

        System.out.println(prescriptionService.getPrescriptions());
        Prescription prescription = new Prescription("algocalmin", 2);
        Prescription prescription1 = new AppointmentPrescription("strepsils", 3, 1);
        prescriptionService.add(prescription);
        prescriptionService.add(prescription1);
        System.out.println(prescriptionService.getPrescriptions());
        prescriptionService.remove(1);
        System.out.println(prescriptionService.getPrescriptions());
        System.out.println(prescriptionService.getPrescriptionByIndex(2));
        System.out.println(prescriptionService.getPrescriptionsByMedication("nurofen"));
        System.out.println(prescriptionService.getPrescriptionsByPrescribingDoctorIdNo(1));
        System.out.println(prescriptionService.getAppointmentPrescriptions());

        doctorServiceInOut.saveDoctors();
        patientServiceInOut.savePatients();
        prescriptionServiceInOut.savePrescriptions();

    }
}
