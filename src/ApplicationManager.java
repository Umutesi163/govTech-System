import java.util.*;

// Custom exceptions
class ApplicationNotFoundException extends Exception {
    public ApplicationNotFoundException(String message) {
        super(message);
    }
}

class InvalidStatusTransitionException extends Exception {
    public InvalidStatusTransitionException(String message) {
        super(message);
    }
}

class ApplicationManager {
    private Map<String, ServiceApplication> applications;
    private static final String FILE_NAME = "applications.txt";

    public ApplicationManager() {
        this.applications = new HashMap<>();
        loadApplications(); // loading still happens silently
    }

    // Add new application
    public void addApplication(ServiceApplication app) {
        applications.put(app.getApplicationId(), app);
        System.out.println("Application " + app.getApplicationId() + " added.");
    }

    // Approve application with proper exception handling
    public void approveApplication(String appId)
            throws ApplicationNotFoundException, InvalidStatusTransitionException {
        ServiceApplication app = applications.get(appId);

        if (app == null) {
            throw new ApplicationNotFoundException("Application not found: " + appId);
        }

        if (app.getStatus() != ServiceApplication.Status.PENDING) {
            throw new InvalidStatusTransitionException(
                    "Cannot approve application " + appId + ": already " + app.getStatus());
        }

        if (!app.getService().validateApplication(app.getCitizen())) {
            throw new InvalidStatusTransitionException(
                    "Citizen does not meet requirements for " + app.getService().getServiceName());
        }

        app.setStatus(ServiceApplication.Status.APPROVED);
        System.out.println("Application " + appId + " approved.");
    }

    // Search application by ID
    public ServiceApplication getApplicationById(String appId) throws ApplicationNotFoundException {
        ServiceApplication app = applications.get(appId);
        if (app == null) {
            throw new ApplicationNotFoundException("Application not found: " + appId);
        }
        return app;
    }

    // Display all applications
    public void displayAllApplications() {
        System.out.println("\n=== All Applications ===");
        applications.values().forEach(System.out::println);
    }

    public Collection<ServiceApplication> getAllApplications() {
        return applications.values();
    }

    // Save applications silently to file
    public void saveApplications() {
        try (var writer = new java.io.PrintWriter(new java.io.FileWriter(FILE_NAME))) {
            for (ServiceApplication app : applications.values()) {
                writer.println(app.getApplicationId() + "," +
                        app.getCitizen().getId() + "," +
                        app.getCitizen().getNationalId() + "," +
                        app.getCitizen().getName() + "," +
                        app.getCitizen().getPhone() + "," +
                        app.getCitizen().getEmail() + "," +
                        app.getCitizen().getDateOfBirth() + "," +
                        app.getCitizen().getAddress() + "," +
                        app.getCitizen().getPhotoPath() + "," +
                        app.getService().getClass().getSimpleName() + "," +
                        app.getStatus() + "," +
                        app.getAppliedDate());
            }
            // Removed console output for saving
        } catch (java.io.IOException e) {
            System.err.println("Error saving applications: " + e.getMessage());
        }
    }

    // Load applications silently from file
    public void loadApplications() {
        java.io.File file = new java.io.File(FILE_NAME);
        if (!file.exists()) return;

        try (var lines = java.nio.file.Files.lines(java.nio.file.Paths.get(FILE_NAME))) {
            lines.forEach(line -> {
                try {
                    String[] parts = line.split(",");
                    Citizen citizen = new Citizen(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);
                    GovernmentService service = switch (parts[9]) {
                        case "BirthCertificateService" -> new BirthCertificateService();
                        case "DrivingTestService" -> new DrivingTestService();
                        case "PassportApplicationService" -> new PassportApplicationService();
                        case "NationalIDService" -> new NationalIDService();
                        case "MarriageCertificateService" -> new MarriageCertificateService();
                        default -> throw new IllegalStateException("Unknown service: " + parts[9]);
                    };
                    ServiceApplication app = new ServiceApplication(citizen, service);
                    app.setStatus(ServiceApplication.Status.valueOf(parts[10]));
                    applications.put(app.getApplicationId(), app);
                } catch (Exception e) {
                    System.err.println("Error parsing line: " + e.getMessage());
                }
            });
            // Removed console output for loading
        } catch (Exception e) {
            System.err.println("Error loading applications: " + e.getMessage());
        }
    }
}
