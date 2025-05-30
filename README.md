# Ecommerce Store

This is a simple command-line interface (CLI) e-commerce project developed in Java.

## 📦 Description

The system simulates a complete e-commerce platform with functionalities for product management, user accounts (customer, administrator, and seller), order processing, and report generation. All data is stored locally in the `data/data.dat` file using Java serialization for persistence.

## 🚀 How to Run

> ⚠️ This project requires **Java 23** or higher.

### Steps:

1.  **Install JDK 23+**:
    *   [Download JDK](https://www.oracle.com/br/java/technologies/downloads/) (Choose the appropriate version for your OS).

2.  **Clone the repository**:

    ```bash
    git clone <url-do-repositorio> # Replace with your actual repo URL
    cd ecommerce-cli-application
    ```

3.  **Compile and execute the project**:

    ```bash
    javac -d bin/ --source-path src/ $(find src/main/java -name "*.java")
    java -cp bin/ ecommerce.application.App
    ```

    *   *Note*: The `$(find src/main/java -name "*.java")` command is for Bash-like shells. If you are on Windows Command Prompt, you might need to list files manually or use an alternative like Git Bash or WSL.

## 🧩 Features

The system implements the following functionalities:

*   **User Management**:
    *   User registration and authentication for different roles:
        *   **Customers**: Can browse products, place orders, and manage delivery addresses.
        *   **Administrators**: Can manage products, create/manage users, and access detailed reports.
        *   **Sellers**: Account type exists for future expansion (currently has limited functionality beyond login).
    *   Secure password storage using encryption and salting.
    *   Email uniqueness validation during account creation.
    *   Customer-specific features: add multiple delivery addresses, view comprehensive order history.
    *   Pre-loaded `admin@gmail.com` account with password `admin` for initial access.

*   **Product Management**:
    *   Creation of new products with attributes: unique ID (automatically generated), name, price, inventory quantity, description, and category.
    *   Listing of available products.
    *   Automatic inventory deduction upon order finalization.
    *   Prevents adding products to cart if inventory is insufficient.

*   **Order Processing**:
    *   Customers can add products to a shopping cart.
    *   Ability to view the current items in the shopping cart.
    *   Order finalization process that updates product stock, generates a unique order ID, calculates the total value, and records the order in the customer's history.
    *   Enforces a business rule that an order must contain at least one product to be finalized.

*   **Reporting (Administrator-only)**:
    *   **Most Expensive Order Report**: Identifies and displays details of the order with the highest total value.
    *   **Lowest Inventory Product Report**: Identifies and displays details of the product with the least quantity in stock.
    *   **Full Report**: Provides a comprehensive overview of all registered accounts and all available products.

*   **Data Persistence**:
    *   Automatic serialization of all application data (accounts, products, orders) to `data/data.dat` upon program exit.
    *   Automatic deserialization of data from `data/data.dat` upon program start.
    *   If no saved data is found, a default set of test data is loaded to populate the system.

*   **Interactive CLI**:
    *   Intuitive, menu-driven command-line interface with options selected by number.
    *   Dynamic menu presentation tailored to the logged-in user's role.

## 📁 Project Structure

*   `src/`: Contains the main Java source code.
    *   `main/java/ecommerce/application/`:
        *   `controllers/`: Manages the business logic for accounts, products, and orders, acting as an intermediary between models and views.
        *   `interfaces/`: Defines abstract contracts and interfaces for various components like `Account`, `Builder`, `Menu`, and `Report`.
        *   `models/`: Holds the core data entities (e.g., `Address`, `Product`, `Order`), utility classes (`IdGenerator`, `PasswordEncryption`, `Serialization`), and the `Program` singleton managing the application state. Includes subpackages for `account` and `product` models.
        *   `views/`: Implements the text-based user interface, including all interactive menus (e.g., `SignInMenu`, `CustomerMenu`, `AdministratorMenu`).
        *   (Other direct application classes like `App.java`, `FullReport.java`, specific reports).
*   `data/`: Directory where the `data.dat` file is stored for persistent data.
*   `pdf/`: Contains the original project specification document.
*   `E-commerce_Project.iml`: IntelliJ IDEA module configuration file.
*   `README.md`: This project documentation file.

## ✅ Requirements

*   Java Development Kit (JDK) 23+
*   A terminal that supports `find` command (e.g., Bash, PowerShell, Git Bash).