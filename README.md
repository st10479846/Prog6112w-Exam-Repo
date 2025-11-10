# PROG6112W Exam Project Repository
**Student Name:** Eugene Makhukhule  
**Student Number:** ST10479846  
**Module:** PROG6112W  
**Exam Project Repository:** Prog6112w-Exam-Repo  

---

## Overview
This repository contains the Java-based exam projects completed for the PROG6112W module.  
The projects demonstrate the use of **Object-Oriented Programming**, **Graphical User Interfaces (GUI)**, **File I/O**, **Interfaces**, and **Unit Testing** in Java.

Each project follows best practices for code separation, readability, and reusability.

---

## Project Features Used in Code

### **1. Java GUI (Swing)**
- Used `JFrame`, `JPanel`, `JMenuBar`, `JMenuItem`, `JButton`, `JScrollPane`, and `JTextArea` to build a graphical interface.
- Allows the user to **load**, **view**, **clear**, and **save** product sales data.

### **2. Interfaces**
- A custom interface `IProductSales` was implemented.
- Ensures structure and enforceable method contracts for:
  - Getting Sales Data
  - Calculating Total Sales
  - Calculating Average Sales
  - Determining Sales Over and Under Limit

### **3. OOP Principles**
- **Encapsulation:** Data stored in a separate class (`ProductData`).
- **Classes & Objects:** `ProductGUI`, `ProductSales`, `ProductData`.
- **Constructor Usage:** Classes initialized with data dependency injection.

### **4. File Handling (I/O)**
- The application saves displayed output to `data.txt` using:
  ```java
  FileWriter writer = new FileWriter("data.txt");



