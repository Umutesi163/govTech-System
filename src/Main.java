public class Main {
    public static void main(String[] args) {
        ApplicationManager manager = new ApplicationManager();

        Citizen c1 = new Citizen("C001", "NPR001", "Alice Uwimana", "+250788000001",
                "alice@email.com", "2000-01-15", "Kigali", "photos/alice.jpg");
        Citizen c2 = new Citizen("C002", "NPR002", "John Doe", "+250788000002",
                "john@email.com", "1995-06-10", "Musanze", "photos/john.jpg");

        // Create applications
        ServiceApplication app1 = new ServiceApplication(c1, new BirthCertificateService());
        ServiceApplication app2 = new ServiceApplication(c2, new DrivingTestService());
        ServiceApplication app3 = new ServiceApplication(c1, new PassportApplicationService());
        ServiceApplication app4 = new ServiceApplication(c2, new NationalIDService());
        ServiceApplication app5 = new ServiceApplication(c1, new MarriageCertificateService());

        // Add applications
        manager.addApplication(app1);
        manager.addApplication(app2);
        manager.addApplication(app3);
        manager.addApplication(app4);
        manager.addApplication(app5);

        // --- Normal Approvals ---
        try {
            manager.approveApplication(app1.getApplicationId());
            manager.approveApplication(app2.getApplicationId());
            manager.approveApplication(app3.getApplicationId());
        } catch (ApplicationNotFoundException | InvalidStatusTransitionException e) {
            System.err.println("Error during normal approvals: " + e.getMessage());
        }

        // Display applications after approvals
        manager.displayAllApplications();

        // Save applications
        manager.saveApplications();

        // Generate revenue report
        RevenueReport report = new RevenueReport(manager.getAllApplications());
        report.generateReport("revenue_report.txt");

        // --- Exception Tests ---
        System.out.println("\n--- Testing Exceptions ---");
        try {
            manager.approveApplication(app1.getApplicationId()); // Already approved
        } catch (ApplicationNotFoundException | InvalidStatusTransitionException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            manager.approveApplication("NON_EXISTENT_ID"); // Non-existent application
        } catch (ApplicationNotFoundException | InvalidStatusTransitionException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
