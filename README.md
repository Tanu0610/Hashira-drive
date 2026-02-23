**Lagrange Interpolation in Java**

This project implements Lagrange Interpolation in Java to compute the polynomial equation that passes through a given set of data points.

**📌 What is Lagrange Interpolation?**

Lagrange Interpolation is a polynomial interpolation method used to find a polynomial that exactly fits a set of given data points.

Given n data points:

(x₀, y₀), (x₁, y₁), ..., (xₙ, yₙ)

The Lagrange polynomial is defined as:

P(x) = Σ ( yi * Li(x) )

Where,

Li(x) = Π (x - xj) / (xi - xj),  for j ≠ i

This method guarantees a unique polynomial of degree at most n-1.

**🚀 Features**

Accepts user-defined data points

Computes interpolated value for any given x

Generates full polynomial equation

Simple and readable Java implementation

No external libraries required

**🛠️ Technologies Used**

Java (JDK 8 or higher)

Standard Java libraries only

**📂 Project Structure**
LagrangeInterpolation/
│── src/
│   └── LagrangeInterpolation.java
│── README.md
