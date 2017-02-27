package TuitionCalc;
import java.util.Scanner;


public class TuitionCalculator {
//Calculate amount it cost to go and the payments needed to repay in a certain time  
	
	//These are my variables
	private double tuitionCost;
	private double percentIncrease;
	private double repaymentAPR;
	private double totalTuitionCost;
	private int term;
	private int payments;
	private double loanBalance = 0;
	private double pmt;
	
	

	public static void main(String[] args) {
		TuitionCalculator tc = new TuitionCalculator();
		tc.test();
	}
	public void loanbalance(){
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter your first year tuition cost:"); //Get initial tuition cost
		tuitionCost = console.nextDouble();
		loanBalance += tuitionCost;
		for (int i = 0; i < 3; i++) { //wont ask for senior year
			System.out.println("What is the percentage increase for next year?(as % value) ");
			percentIncrease = console.nextDouble() / 100.0;
			tuitionCost += tuitionCost * percentIncrease;
			loanBalance += tuitionCost;
		}
	}
	public void test(){
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter the first year tuition cost:");
		tuitionCost = console.nextDouble();
		loanBalance += tuitionCost;
		for (int i = 0; i < 3; i++) {
			System.out.println("What is the percentage increase for next year?(In a % value) ");
			percentIncrease = console.nextDouble() / 100.0;
			tuitionCost += tuitionCost * percentIncrease;
			loanBalance += tuitionCost;
			
		}
		System.out.println("What is the repayment APR?(In a % value) ");
		repaymentAPR = console.nextDouble() / 100.0;
		
		System.out.println("How many years do you plan to take to repay your loan?");
		term = console.nextInt();
		payments = term*12;
		
		pmt =	FinanceLib.pmt(repaymentAPR, payments, loanBalance, 0.0, true);
		
		System.out.printf("Your tuition cost is: $%8.2f \n Your monthly payment is: $%8.2f " , loanBalance,pmt*-1);
//Future Value is 0 so FinanceLib is returning a negative number. Multiplying by -1 will fix this  ^
	}


	public double getPmt() {
		return pmt;
	}
	
	public void setPmt(double pmt) {
		this.pmt = pmt;
	}
	public double getTuitionCost() {
		return tuitionCost;
	}

	public void setTuitionCost(double tuitionCost) {
		this.tuitionCost = tuitionCost;
	}

	public double getPercentIncrease() {
		return percentIncrease;
	}

	public void setPercentIncrease(double percentIncrease) {
		this.percentIncrease = percentIncrease;
	}

	public double getRepaymentAPR() {
		return repaymentAPR;
	}

	public void setRepaymentAPR(double repaymentAPR) {
		this.repaymentAPR = repaymentAPR;
	}

	public double getTotalTuitionCost() {
		return totalTuitionCost;
	}

	public void setTotalTuitionCost(double totalTuitionCost) {
		this.totalTuitionCost = totalTuitionCost;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public int getPayments() {
		return payments;
	}

	public void setPayments(int payments) {
		this.payments = payments;
	}

	public double getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(double loanBalance) {
		this.loanBalance = loanBalance;
	}

}