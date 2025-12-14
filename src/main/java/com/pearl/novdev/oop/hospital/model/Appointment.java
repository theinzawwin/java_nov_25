package com.pearl.novdev.oop.hospital.model;

import java.time.LocalDateTime;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime dateTime;
    private AppointmentStatus status;

    public Appointment(Doctor doctor, Patient patient, LocalDateTime dateTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
        this.status = AppointmentStatus.BOOKED;
    }

    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }
    public LocalDateTime getDateTime() { return dateTime; }
    public AppointmentStatus getStatus() { return status; }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public void printDetails() {
        System.out.println("Appointment:");
        System.out.println("  Doctor: " + doctor.getName() + " (" + doctor.getSpecialization() + ")");
        System.out.println("  Patient: " + patient.getName() + " - " + patient.getSickness());
        System.out.println("  Date: " + dateTime);
        System.out.println("  Status: " + status);
    }
}
