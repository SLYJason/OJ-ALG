package Atlassian.Cost_Explorer;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Level0 {

    public static void main(String[] args) {
        // case 1
        LocalDate localDate1 = LocalDate.of(2023, 1, 1);
        CostExplorer costExplorer1 = new CostExplorer(localDate1, CostExplorer.Plan.BASIC);
        System.out.println("Monthly cost for localDate1: " + costExplorer1.monthlyCostList() + ", annual cost: " + costExplorer1.annualCost());
        // case 2
        LocalDate localDate2 = LocalDate.of(2023, 2, 1);
        CostExplorer costExplorer2 = new CostExplorer(localDate2, CostExplorer.Plan.BASIC);
        System.out.println("Monthly cost for localDate2: " + costExplorer2.monthlyCostList() + ", annual cost: " + costExplorer2.annualCost());
        // case 3
        LocalDate localDate3 = LocalDate.of(2023, 9, 1);
        CostExplorer costExplorer3 = new CostExplorer(localDate3, CostExplorer.Plan.STANDARD);
        System.out.println("Monthly cost for localDate3: " + costExplorer3.monthlyCostList() + ", annual cost: " + costExplorer3.annualCost());
        // case 3
        LocalDate localDate4 = LocalDate.of(2023, 12, 1);
        CostExplorer costExplorer4 = new CostExplorer(localDate4, CostExplorer.Plan.PREMIUM);
        System.out.println("Monthly cost for localDate4: " + costExplorer4.monthlyCostList() + ", annual cost: " + costExplorer4.annualCost());
    }
}

class CostExplorer {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private List<Double> monthlyCostList;
    private Plan plan;
    private int year;
    private int month;
    private int day;
    public CostExplorer(LocalDate date, Plan plan) {
        this.year = date.getYear();
        this.month = date.getMonthValue();
        this.day = date.getDayOfMonth();
        this.monthlyCostList = new ArrayList<>(Collections.nCopies(12, 0.0));
        this.plan = plan;
    }

    public enum Plan {
        BASIC,
        STANDARD,
        PREMIUM
    }
    private final Map<Plan, Double> planCostMap = Map.of(Plan.BASIC, 9.99, Plan.STANDARD, 49.99, Plan.PREMIUM, 249.99);

    public List<Double> monthlyCostList() {
        for (int i = month - 1; i < 12; i++) {
            monthlyCostList.set(i, planCostMap.get(plan));
        }
        return monthlyCostList;
    }

    public String annualCost() {
        return df.format(monthlyCostList().stream().reduce(0.0, Double::sum));
    }
}
