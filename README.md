📚 Simple Banking Management System
A simple console-based banking management system written in Java.
This project helps you practice classes, objects, file I/O, exception handling, and basic OOP design.

🚀 Features
✅ Account Holder Menu

Log in with account number and PIN

Check account balance

Deposit money

Withdraw money

✅ Bank Officer Menu

Log in with username and password

Create new customer accounts

View customer account details

Deposit or withdraw money for customers

✅ Admin Option

Add new bank officers (admin only)

✅ File Storage

Customer accounts and bank officers are saved to text files (accounts.txt, officer.txt)

✅ Basic Input Validation

Handles invalid menu options and wrong input types

📂 Project Structure
css
Copy
Edit
📁 Simple Banking System/
 ├── src/
 │   ├── Main.java
 │   ├── Bank.java
 │   ├── BankAccounts.java
 │   ├── BankOfficers.java
 ├── accounts.txt
 ├── officer.txt
 ├── .idea/ (IDE configs)
 ├── out/ (compiled classes)
 └── README.md
🛠️ How to Run
1️⃣ Clone or download this project to your machine.
2️⃣ Open the project in IntelliJ IDEA (or any Java IDE).
3️⃣ Compile and run Main.java.
4️⃣ Follow the console prompts to use the system.

⚙️ Requirements
Java 17+ (or your version)

Any modern Java IDE (IntelliJ IDEA recommended)

✨ Learning Goals
Practice object-oriented programming (OOP) in Java.

Work with file read/write to persist data.

Use loops, conditionals, exception handling.

Understand the flow of a simple console app with multiple user roles.

🔑 How it works
The Main class runs the main menu loop.

Bank class manages accounts and officers.

BankAccounts class handles individual customer account data.

BankOfficers class handles officer login and permissions.

Data is stored in plain text files.

✅ Improvements you could add
Encrypt PINs and passwords (currently plain text)

Add transaction history logs

Use a database instead of text files

Add input validation for negative amounts

Add unit tests for each class

📜 License
This project is for educational purposes only.
