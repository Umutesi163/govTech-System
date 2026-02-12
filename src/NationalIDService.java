///The nationalID Service class is a concrete subclass of the abstract GovernmentService class.
class NationalIDService extends GovernmentService {
    public NationalIDService() {
        super("National ID Application", 1500.0);
    }

    @Override
    public boolean validateApplication(Citizen citizen) {
        return citizen.getDateOfBirth() != null && citizen.getPhone() != null;
    }
}