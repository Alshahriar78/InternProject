# 1. implement the Single Responsibility Principle (SRP)

## Here's a more detailed breakdown:
- **I.** Identify Responsibilities:
Analyze your classes and identify different responsibilities.
Each responsibility is a potential reason for change.
Look for patterns and group related actions. 
- **II.** Divide and Conquer:
If a class has multiple responsibilities, consider dividing it into smaller classes, each with its own responsibility. 
For example, a class that handles both data retrieval and data presentation should be split into two classes: one for data retrieval and another for presentation. 
- **III.** Create Cohesive and Modular Classes:
Create classes that focus on specific responsibilities, ensuring they are cohesive and modular.
Avoid "god classes" (classes that handle too many responsibilities). 

**Try to applied this in My Lab test Appoinmnet Booking.**
**Complete Users Controller according To SRP**
