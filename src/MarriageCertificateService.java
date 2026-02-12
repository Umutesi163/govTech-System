//The MarriageCertificate Service class is a concrete subclass of the abstract GovernmentService class.
class MarriageCertificateService extends GovernmentService {
    public MarriageCertificateService() {
        super("Marriage Certificate", 3000.0);
    }

    @Override
    public boolean validateApplication(Citizen citizen) {
        return citizen.getName().contains(" ") && citizen.getPhone() != null;
    }
}