import java.time.LocalDateTime;
import java.util.UUID;

class ServiceApplication {
    public enum Status { PENDING, APPROVED, REJECTED }

    private String applicationId;
    private Citizen citizen;
    private GovernmentService service;
    private Status status;
    private LocalDateTime appliedDate;

    public ServiceApplication(Citizen citizen, GovernmentService service) {
        this.applicationId = "APP" + UUID.randomUUID().toString().substring(0, 8);
        this.citizen = citizen;
        this.service = service;
        this.status = Status.PENDING;
        this.appliedDate = LocalDateTime.now();
    }

    public String getApplicationId() { return applicationId; }
    public Citizen getCitizen() { return citizen; }
    public GovernmentService getService() { return service; }
    public Status getStatus() { return status; }
    public LocalDateTime getAppliedDate() { return appliedDate; }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServiceApplication{" +
                "applicationId='" + applicationId + '\'' +
                ", citizen=" + citizen.getName() +
                ", service=" + service.getServiceName() +
                ", status=" + status +
                ", appliedDate=" + appliedDate +
                '}';
    }
}