package service;

import model.Prescription;
import repositories.PrescriptionRepo;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Set;


public class PrescriptionService {
    private static PrescriptionService instance;
    private final PrescriptionRepo prescriptionRepo;

    private PrescriptionService() throws IOException {
        prescriptionRepo = new PrescriptionRepo();
    }

    public static PrescriptionService getInstance() throws IOException {
        if(instance == null)
            instance = new PrescriptionService();
        return instance;
    }

    public Set<Prescription> getPrescriptions() throws IOException {
        AuditService.getInstance().log("Requested prescriptions",new Timestamp(System.currentTimeMillis()));
        return prescriptionRepo.getPrescriptions();
    }

    public boolean add(final Prescription prescription) throws IOException {
        AuditService.getInstance().log("Added prescription",new Timestamp(System.currentTimeMillis()));
        return prescriptionRepo.add(prescription);
    }

    public boolean remove(final int index) throws IOException {
        AuditService.getInstance().log("Removed a prescription",new Timestamp(System.currentTimeMillis()));
        return prescriptionRepo.remove(index);
    }

    public Prescription getPrescriptionByIndex(int index) throws IOException {
        AuditService.getInstance().log("Requested prescription by index",new Timestamp(System.currentTimeMillis()));
        return prescriptionRepo.getPrescriptionByIndex(index);
    }

    public Set<Prescription> getPrescriptionsByMedication(String medication) throws IOException {
        AuditService.getInstance().log("Requested prescriptions by medication",new Timestamp(System.currentTimeMillis()));
        return prescriptionRepo.getPrescriptionsByMedication(medication);
    }

    public Set<Prescription> getPrescriptionsByPrescribingDoctorIdNo(int idNo) throws IOException {
        AuditService.getInstance().log("Requested prescriptions by prescribing doctor idNo",new Timestamp(System.currentTimeMillis()));
        return prescriptionRepo.getPrescriptionsByPrescribingDoctorIdNo(idNo);
    }

    public Set<Prescription> getAppointmentPrescriptions() throws IOException {
        AuditService.getInstance().log("Requested appointment prescriptions",new Timestamp(System.currentTimeMillis()));
        return prescriptionRepo.getAppointmentPrescriptions();
    }
}
