//The passportAppplication Service class is a concrete subclass of the abstract GovernmentService class.
class PassportApplicationService extends GovernmentService {
    public PassportApplicationService() {
        super("Passport Application", 100000.0);
    }

    @Override
    public boolean validateApplication(Citizen citizen) {
        return citizen.getNationalId() != null && citizen.getPhotoPath() != null;
    }
}