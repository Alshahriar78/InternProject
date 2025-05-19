# Day 27 - SOLID Principles in Java

Today I studied the 5 SOLID principles in Object-Oriented Programming (OOP) using Java. These principles help in writing clean, maintainable, and scalable code. Here's a summary of what I learned:

---

## ✅ S — Single Responsibility Principle (SRP)
- A class should have only **one reason to change**.
- Each class should do **one specific task** or responsibility.
- 📌 Example: Separate classes for `ReportPrinter` and `ReportSaver`.

---

## ✅ O — Open/Closed Principle (OCP)
- Software components should be **open for extension** but **closed for modification**.
- You should be able to add new behavior without modifying existing code.
- 📌 Example: Add new shapes (`Circle`, `Rectangle`) by extending the `Shape` interface.

---

## ✅ L — Liskov Substitution Principle (LSP)
- Subclasses should be **substitutable** for their base (super) class.
- Derived classes must adhere to the behavior expected by the parent class.
- ❌ Violated when a subclass (e.g., `Ostrich`) can't perform a method (e.g., `fly()`).

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


