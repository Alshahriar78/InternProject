# Day 27 - SOLID Principles in Java

Today I studied the 5 SOLID principles in Object-Oriented Programming (OOP) using Java. These principles help in writing clean, maintainable, and scalable code. Here's a summary of what I learned:

---

## ✅ S — Single Responsibility Principle (SRP)
- A class should have only **one reason to change**.
- Each class should do **one specific task** or responsibility.
- 📌 Example: Separate classes for `ReportPrinter` and `ReportSaver`.

- suppose a manager manage two task/responsibility. One is registration User & Another is Send Mail .for Better perfomance we need two specific manger one is who registered user & Another who Can send Mail to the User.

---

## ✅ O — Open/Closed Principle (OCP)
- Software components/entities   should be **open for extension** but **closed for modification**.
- You should be able to add new behavior without modifying existing code.
- 📌 Example: Add new shapes (`Circle`, `Rectangle`) by extending the `Shape` interface.
- software entities (classes, modules, etc.) should be open for extension but closed for  modification.
-  This means you should be able to add new functionality to a class without changing its existing code. 
 
### Open for Extension:
- This means the class should be designed in a way that allows you to add new features or functionalities without modifying its existing implementation. This can be achieved through techniques like using **abstract classes, interfaces,polymorphism , or design patterns like the Decorator or Strategy patterns**. 


### Closed for Modification:
- This means the core functionality of the class should not be changed when adding new features. You should avoid modifying the existing source code to add new functionalities. 


#### Benefits:
- **Increased Flexibility:** The system can adapt to new requirements without disrupting existing code. 
- **Reduced Risk of Bugs:** Modifying existing code can introduce unintended consequences, so avoiding it reduces the risk of introducing new bugs. 
- **Improved Maintainability:** Code that is easy to extend is also easier to maintain and understand. 

---

## ✅ L — Liskov Substitution Principle (LSP)
- Subclasses should be **substitutable** for their base (super) class without alterning program.
- Derived classes must adhere to the behavior expected by the parent class.
- ❌ Violated when a subclass (e.g., `b`) can't perform a method (e.g., `fly()`).

---

## ✅ I — Interface Segregation Principle (ISP)
- Don't force classes to implement interfaces they don't use.
- Prefer **many small interfaces** over a big, bulky one.
- 📌 Example: Split `Printer` and `Scanner` into separate interfaces.

---

## ✅ D — Dependency Inversion Principle (DIP)
- High-level modules should **not depend on low-level modules**. Both should depend on **abstractions**.
- Use interfaces or abstract classes to invert dependencies.
- 📌 Example: `Computer` depends on `Keyboard` interface, not on `MechanicalKeyboard` directly.

---


