# TemplateProcassingException
* General exception for errors raised during the process of a template.

# WeakKeyException

# HttpRequestMethodNotSupportedException



1. SOLID Principles

Single Responsibility Principle (SRP)

A class should have only one reason to change.

Example: Refactored ReportManager into ReportGenerator, ReportPrinter, and ReportEmailer.

Open/Closed Principle (OCP)

Open for extension, closed for modification.

Example: Introduced DiscountStrategy interface with RegularDiscount & PremiumDiscount implementations. DiscountCalculator depends on the abstraction.

Liskov Substitution Principle (LSP)

Subtypes must be substitutable for their base types.

Example: Replaced inheritance-based Square extends Rectangle with a common Shape interface and separate Rectangle & Square classe


2. Video Tutorial Resources

SOLID principles in Java OOP: https://www.youtube.com/watch?v=DiJ3LVP4ASQ

SOLID Design Principles in Java with Example (JavaTechie): https://www.youtube.com/watch?v=BM_lSZPMClo

SOLID Design Principles with Java Examples (Geekific): https://www.youtube.com/watch?v=HoA6aZPR5K0


3. IntelliJ IDEA Troubleshooting

When everything compiles but IntelliJ shows red highlights:
Invalidate Caches & Restart

4. Thymeleaf & Spring Security

4.1 Fixing TemplateProcessingException

4.2 Logout Button Implementation



## Revision Of OOP, With Class, Object

- Class is a blue print or template that can create individuals object.

### How to create Class 
 class(keyword) className{
   fields;
   methods;
 }