import java.lang.Math;
import java.util.Scanner;

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    public Loan()
    {

    }

    public Loan (double annualInterestRate, int numberOfYears, double loanAmount)
    {
        this.annualInterestRate = annualInterestRate / 100;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new java.util.Date();

    }

    public double getAnnualInterestRate()
    {
        return this.annualInterestRate;
    }

    public int getNumberOfYears()
    {
        return this.numberOfYears;
    }

    public double getLoanAmount()
    {
        return this.loanAmount;
    }

    public java.util.Date getLoanDate()
    {
        return this.loanDate;
    }

    public void setAnnualInterestRate(double interest)
    {
        this.annualInterestRate = interest ;
    }

    public void setNumberOfYears(int years)
    {
        this.numberOfYears = years;
    }

    public void setLoanAmount(double loan)
    {
        this.loanAmount = loan;
    }

    public double getMonthlyPayment()
    {
        double monthlyPayment;
        double monthlyInterestRate = this.annualInterestRate / 12;
        monthlyPayment = ((this.loanAmount * monthlyInterestRate) / (1 - (1 / Math.pow((1 + monthlyInterestRate),(this.numberOfYears * 12)))));
        return monthlyPayment;

    }

    public double getTotalPayment()
    {
        double totalPayment = getMonthlyPayment() * this.numberOfYears * 12;
        return totalPayment;

    }

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter annual interest rate, for example 8.25: ");
        double interest = input.nextDouble();
        System.out.print("Enter number of years as an integer: ");
        int years = input.nextInt();
        System.out.print("Enter loan amount, for example 120000.95: ");
        double loan = input.nextDouble();
        Loan newloan = new Loan(interest,years,loan);
        System.out.println("The loan was created on " + newloan.loanDate);
        System.out.println("The monthly payment is " + newloan.getMonthlyPayment());
        System.out.println("The total payment is " + newloan.getTotalPayment());
        input.close();

    
    }






}