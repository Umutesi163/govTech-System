import java.util.*;

class RevenueReport {
    private List<ServiceApplication> applications;

    public RevenueReport(Collection<ServiceApplication> applications) {
        this.applications = new ArrayList<>(applications);
    }

    public double getTotalRevenue() {
        return applications.stream()
                .filter(app -> app.getStatus() == ServiceApplication.Status.APPROVED)
                .mapToDouble(app -> app.getService().getFee())
                .sum();
    }

    public Map<String, Double> getRevenueByService() {
        return applications.stream()
                .filter(app -> app.getStatus() == ServiceApplication.Status.APPROVED)
                .collect(
                        HashMap::new,
                        (map, app) -> map.merge(
                                app.getService().getServiceName(),
                                app.getService().getFee(),
                                Double::sum),
                        HashMap::putAll
                );
    }

    public void generateReport(String filename) {

        long approvedCount = applications.stream()
                .filter(a -> a.getStatus() == ServiceApplication.Status.APPROVED)
                .count();

        double totalRevenue = getTotalRevenue();
        Map<String, Double> revenueByService = getRevenueByService();

        // ✅ PRINT TO CONSOLE
        System.out.println("\n=== GOVERNMENT SERVICE REVENUE REPORT ===");
        System.out.println("Generated on: " + new Date());
        System.out.println("Total Approved Applications: " + approvedCount);
        System.out.println("Total Revenue: RWF " + String.format("%.2f", totalRevenue));

        System.out.println("\n--- Revenue by Service ---");
        revenueByService.forEach((service, revenue) ->
                System.out.println(service + ": RWF " + String.format("%.2f", revenue))
        );

        // ✅ SAVE TO FILE
        try (var writer = new java.io.PrintWriter(new java.io.FileWriter(filename))) {

            writer.println("=== GOVERNMENT SERVICE REVENUE REPORT ===");
            writer.println("Generated on: " + new Date());
            writer.println("Total Approved Applications: " + approvedCount);
            writer.println("Total Revenue: RWF " + String.format("%.2f", totalRevenue));

            writer.println("\n--- Revenue by Service ---");
            revenueByService.forEach((service, revenue) ->
                    writer.println(service + ": RWF " + String.format("%.2f", revenue))
            );

            System.out.println("\nRevenue report generated and saved to: " + filename);

        } catch (java.io.IOException e) {
            System.err.println("Error writing report: " + e.getMessage());
        }
    }
}
