package service;

import java.math.BigDecimal;
import java.math.MathContext;

public class CalcService {
    private BigDecimal memory =  BigDecimal.ZERO;
    private BigDecimal a =  BigDecimal.ZERO;
    private BigDecimal b =  BigDecimal.ZERO;

    public void clearMemory(){
        this.memory = BigDecimal.ZERO;
    }

    public void addToMemory(final String toAdd) {
        this.memory = this.memory.add((BigDecimal.valueOf(Double.parseDouble(toAdd))));
    }

    public void subFromMemory(final String toSub) {
        this.memory = this.memory.subtract(BigDecimal.valueOf(Double.parseDouble(toSub)));
    }

    public void clearA() {
        this.a =  BigDecimal.ZERO;
    }

    public void clearB() {
        this.b =  BigDecimal.ZERO;
    }

    public void clearAB(){
        clearA();
        clearB();
    }

    public String getMemory() {
        return memory.toString();
    }

    public void setMemory(final String memory) {
        this.memory = BigDecimal.valueOf(Double.parseDouble(memory));
    }

    public String getA() {
        return a.toString();
    }

    public void setA(final String a) {
        this.a = BigDecimal.valueOf(Double.parseDouble(a));
    }

    public String getB() {
        return b.toString();
    }

    public void setB(final String b) {
        this.b = BigDecimal.valueOf(Double.parseDouble(b));
    }

    public String root(final String a) {
        BigDecimal n = BigDecimal.valueOf(Double.parseDouble(a));
        if (Double.parseDouble(a) <= 0.0){
            return "bledna operacja";
        }
        return String.valueOf(n.sqrt(MathContext.DECIMAL64));
    }

    public String oneByX(final String a) {
        BigDecimal n = BigDecimal.valueOf(Double.parseDouble(a));
        if (Double.parseDouble(a) == 0.0){
            return "bledna operacja";
        }
        return String.valueOf(BigDecimal.ONE.divide(n, MathContext.DECIMAL64));
    }

    public String calculate(final String command) {
        switch (command){
            case "add":
                return String.valueOf(this.a.add(this.b));
            case "subtract":
                return String.valueOf(this.a.subtract(this.b));
            case "multiply":
                return String.valueOf(this.a.multiply(this.b));
            case "divide":
                return String.valueOf(this.a.divide(this.b, MathContext.DECIMAL64));
            default:
                return "0";
        }
    }

    public String calculatePercent() {
        return String.valueOf(this.a.multiply(this.b.divide(BigDecimal.valueOf(100.0), MathContext.DECIMAL64)));
    }
}
