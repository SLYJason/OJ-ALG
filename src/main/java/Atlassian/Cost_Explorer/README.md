# Cost Explorer
Imagine you’re working on payments team at a Company and your company is building different products to the customers. Customers subscribes to your company product and is interested in exploring how much it’ll cost them to keep using the product for the rest of the year.
Your task is to develop a **CostExplorer** that calculates the total cost a customer has to pay in a unit year. This means that at any day of the year they should be able to get a provisional report giving monthly/yearly cost estimates. Here we define the unit year from Jan 1st to Dec 31st.

**CostExplorer** should be able to provide a report of:
1. **Monthly cost** (Generate a bill for each month, including bill amount for future months for the unit year).
2. **Yearly cost estimates** (for the unit year).
```markdown
CostExplorer ->
  monthlyCostList(): Array/List of size 12 filled with cost incurred in each month of the unit year
  annualCost(): Total cost in a unit year
```

## Level 0 requirements
To keep it simple, we are keeping one pricing for all products, it reality we have different pricing. The pricing will be like:
```markdown
[
  {BASIC, 9.99},
  {STANDARD, 49.99}, 
  {PREMIUM, 249.99}
]
```
Customer subscription information
```markdown
Customer -> C1
Product -> 
	Name -> Product A
	Subscription -> [ BASIC, "2022-03-10”  ] //  { planId, startDate }, date in YYYY-MM-DD format
```
Case 1: `startDate` is `Jan 01`, 2023, and customer subscribed to `BASIC` plan,
```markdown
Monthly Cost = [9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99]
Yearly cost estimates = 119.88
```
Case 2: `startDate` is `Feb 01`, 2023, and customer subscribed to `BASIC` plan,
```markdown
Monthly Cost = [0.00, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99]
Yearly cost estimates = 109.89
```
Case 3: `startDate` is `Sep 01, 2023`, and customer subscribed to `STANDARD` plan,
```markdown
Monthly Cost = [0, 0, 0, 0, 0, 0, 0, 0, 49.99, 49.99, 49.99, 49.99]
Yearly cost estimates = 199.96
```
Case 4: `startDate` is `Dec 01, 2023`, and customer subscribed to `PREMIUM` plan,
```markdown
Monthly Cost = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 249.99]
Yearly cost estimates = 249.99
```