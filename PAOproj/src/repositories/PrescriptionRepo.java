package repositories;

import model.*;
import service.PatientServiceInOut;
import service.PrescriptionServiceInOut;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class PrescriptionRepo {
    private final Set<Prescription> prescriptions;
    public PrescriptionRepo() throws IOException {
        prescriptions = PrescriptionServiceInOut.getInstance().loadPrescriptions();
    }

    public Set<Prescription> getPrescriptions(){
        return Collections.unmodifiableSet(prescriptions);
    }

    public boolean add(final Prescription prescription){
        return prescriptions.add(prescription);
    }

    public boolean remove(final int index){
        final Prescription prescription = getPrescriptionByIndex(index);
        if(prescription == null)
            return false;
        return prescriptions.remove(prescription);
    }

    public Prescription getPrescriptionByIndex(int index) {
        for(final Prescription prescription:prescriptions){
            if(prescription.getIndex() == index)
                return prescription;
        }
        return null;
    }

    public Set<Prescription> getPrescriptionsByMedication(String medication){
        Set<Prescription> srcResult = null;
        for(final Prescription prescription:prescriptions){
            if(prescription.getMedication().equals(medication)) {
                if (srcResult == null)
                    srcResult = new TreeSet<>();
                srcResult.add(prescription);
            }
        }
        return srcResult;
    }

    public Set<Prescription> getPrescriptionsByPrescribingDoctorIdNo(int idNo){
        Set<Prescription> srcResult = null;
        for(final Prescription prescription:prescriptions){
            if(prescription.getPrescribingDoctorIdNo() == idNo ) {
                if (srcResult == null)
                    srcResult = new TreeSet<>();
                srcResult.add(prescription);
            }
        }
        return srcResult;
    }

    public Set<Prescription> getAppointmentPrescriptions(){
        Set<Prescription> srcResult = null;
        for(final Prescription prescription:prescriptions){
            if(prescription.getClass() == AppointmentPrescription.class) {
                if (srcResult == null)
                    srcResult = new TreeSet<>();
                srcResult.add(prescription);
            }
        }
        return srcResult;
    }

}
