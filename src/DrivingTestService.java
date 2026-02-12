//The DrivingTestService class is a concrete subclass of the abstract GovernmentService class.
//Purpose:
//It models a government service for applying to take a driving test, including a fixed fee and specific application validation rules.
class DrivingTestService extends GovernmentService {
    public DrivingTestService() {
        super("Driving Test", 8000.0);
    }

    @Override
    public boolean validateApplication(Citizen citizen) {
        return citizen.getNationalId() != null;
    }
}