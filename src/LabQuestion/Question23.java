package LabQuestion;

abstract class Person {
    abstract void printMedicalFee();
}

class Patient extends Person {
    private int patientID;
    private String patientDepartment;
    private String patientWard;
    private String patientDoj;
    private String patientAddress;
    private double patientMedicalFee;

    public Patient(int patientID, String patientDepartment, String patientWard, String patientDoj, String patientAddress, double patientMedicalFee) {
        this.patientID = patientID;
        this.patientDepartment = patientDepartment;
        this.patientWard = patientWard;
        this.patientDoj = patientDoj;
        this.patientAddress = patientAddress;
        this.patientMedicalFee = patientMedicalFee;
    }

    @Override
    void printMedicalFee() {
        System.out.println("Total medical fee :- " + patientMedicalFee + " for patient id " + patientID);
    }
}

/**
 * Write a Patient class which inherits from the Person class. Patient can again be of two types,
 * indoor and outdoor. The Patient class requires the following:
     * a) a variable to store the patient ID for the patient
     * b) a variable to store the department of hospital
     * c) a variable to store the ward of hospital
     * d) a variable to store the patient 's date of joining the hospital
     * e) a variable to store the patient 's address
     * f) a variable to store the medical fees that the patient pays
     * g) constructor methods, which initialize the variables
     * h) a method to calculate the medical fees (for both indoor and outdoor patient)
 */
public class Question23 {
    public static void main(String[] args) {
        var indoor = new Patient(1, "indoor", "10", "12-2-2021", "xyz", 2000);
        var outdoor = new Patient(2, "outdoor", "09", "14-5-2021", "xyz1", 3000);

        indoor.printMedicalFee();
        outdoor.printMedicalFee();
    }
}
