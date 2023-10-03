
public class Main {
    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();
        System.out.println("\nYoungestEldestWorkers");
        for (DatabaseQueryService.YoungestEldestWorkers res: queryService.findYoungestEldestWorkers()) {
            System.out.println(res.type()+ " " + res.name() + " " + res.birthday());
        }
        System.out.println("\nMaxSalaryWorker");
        for (DatabaseQueryService.MaxSalaryWorker res: queryService.findMaxSalaryWorker()) {
            System.out.println(res.name() + " " + res.salary());
        }
        System.out.println("\nMaxProjectsClient");
        for (DatabaseQueryService.MaxProjectsClient res: queryService.findMaxProjectsClient()) {
            System.out.println(res.name() + " " + res.projectCount());
        }
        System.out.println("\nLongestProject");
        for (DatabaseQueryService.LongestProject res: queryService.findLongestProject()) {
            System.out.println(res.name() + " " + res.monthCount());
        }
        System.out.println("\nProjectPrices");
        for (DatabaseQueryService.ProjectPrices res: queryService.findProjectPrices()) {
            System.out.println(res.name() + " " + res.price());
        }
    }
}
