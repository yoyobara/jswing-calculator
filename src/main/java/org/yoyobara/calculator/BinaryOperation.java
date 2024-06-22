package org.yoyobara.calculator;

@FunctionalInterface
public interface BinaryOperation {
    public double performOperation(double a, double b);
}
