//The BirthCertificateService class is a concrete subclass of
// the abstract GovernmentService class.
class BirthCertificateService extends GovernmentService {
    public BirthCertificateService() {
        super("Birth Certificate", 2500.0);
    }

    @Override
    //This design allows different services (e.g., passport, ID card) to have custom validation rules,
    // while sharing common structure from the parent class
    public boolean validateApplication(Citizen citizen) {
        return citizen.getName() != null && !citizen.getName().trim().isEmpty();
    }
}