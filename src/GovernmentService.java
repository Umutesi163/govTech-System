//The GovernmentService class is an abstract class in Java that serves
// as a template for various government services
//Key Components:
//Fields:
//serviceName: Name of the service (e.g., "Birth Certificate").
//fee: Cost of the service in RWF (Rwandan Francs).
abstract class GovernmentService {
    protected String serviceName;
    protected double fee;
//Constructor:
//Initializes serviceName and fee when a subclass is created.
    public GovernmentService(String serviceName, double fee) {
        this.serviceName = serviceName;
        this.fee = fee;
    }
//This method(abstract) must be implemented by every subclass (e.g., PassportService, IDCardService)
// to define custom validation rules for a citizen's application.
    public abstract boolean validateApplication(Citizen citizen);
//Concrete Methods:
//getServiceName() and getFee(): Standard getters.
//toString(): Returns a readable string like "Birth Certificate (Fee: RWF 1000)"
    public String getServiceName() { return serviceName; }
    public double getFee() { return fee; }

    @Override
    public String toString() {
        return serviceName + " (Fee: RWF " + fee + ")";
    }
}