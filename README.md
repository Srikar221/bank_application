# Bank Application

## Abstract 

The BankApplication class serves as the entry point of the program, where the user
is prompted to enter their name and customer ID to access their bank account. It
creates an instance of the BankAccount class and calls the menu method to initiate
the banking operations.

The BankAccount class represents a bank account and maintains attributes such as
the customer's name, customer ID, account balance, and previous transaction details.
It provides methods to deposit funds, withdraw funds, retrieve the previous
transaction, and display a menu of options for the user to choose from.

The program uses the Scanner class for user input and utilizes a do-while loop to
repeatedly display the menu and process user-selected options until the user chooses
to exit. The switch statement inside the loop handles the different options and
performs the corresponding operations based on user input.

In summary, the provided code offers a basic framework for a bank application
where customers can manage their accounts by performing various banking
operations. It serves as a starting point for further enhancements and customization
to meet specific banking requirements.

## Introduction

The project represents a Bank Application implemented in Java. It aims to provide a
comprehensive solution for managing bank accounts by offering functionalities such
as checking the account balance, depositing funds, withdrawing funds, and
retrieving previous transaction details. The code utilizes object-oriented
programming principles to ensure modularity, code reusability, and maintainability.

The Bank Application serves as a digital platform for customers to conveniently and
securely manage their bank accounts. It eliminates the need for manual transactions
by providing a user-friendly interface that allows customers to perform various
banking operations efficiently.

## Key Functions 

The code focuses on implementing key functionalities that are crucial for effective
bank account management. These functionalities include:

- Checking Account Balance:
Customers can check their account balance, which provides them with real-time
information on the available funds in their bank accounts. This helps users make
informed decisions regarding their finances.

- Depositing Funds:
Customers can deposit funds into their bank accounts by specifying the amount they
wish to deposit. The application ensures that the deposited amount is accurately
reflected in the account balance.

- Withdrawing Funds:
Customers can withdraw funds from their bank accounts, provided they have
sufficient balance. The application validates the withdrawal amount and updates the
account balance accordingly.

- Retrieving Previous Transaction Details:

The Bank Application maintains a record of previous transactions, allowing
customers to access information about their recent deposits and withdrawals. This
feature provides users with a transaction history for reference and record-keeping
purposes.
