Polynomial-Solver
Java implementation of Polynomial Reconstruction using Lagrange Interpolation from JSON test cases (Base Conversion + Fraction Support).

Polynomial Reconstruction using Lagrange Interpolation (Java)
📌 Project Overview
This project reconstructs a polynomial of degree (k-1) using k roots provided in JSON format.
Each root contains:

Base of the number system
Encoded value
Index representing x-coordinate
The program:

Converts values from different bases to decimal
Selects first k valid roots
Applies Lagrange Interpolation
Outputs exact polynomial coefficients (Highest → Constant)
Supports large numbers and fractional coefficients
🧮 Problem Statement
Given:

n total roots
k minimum roots required
k = m + 1 (where m = degree of polynomial)
Reconstruct the polynomial:

f(x) = a₀xⁿ + a₁xⁿ⁻¹ + ... + constant

⚙ Technologies Used
Java (OpenJDK 25)
BigInteger
BigDecimal
Fraction arithmetic
Lagrange Interpolation
JSON Parsing
📂 Project Structure
PolynomialProject/ │ ├── Main.java ├── PolynomialSolver.java ├── input.json └── README.md
