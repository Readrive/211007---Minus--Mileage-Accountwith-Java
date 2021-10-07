public class Account {
    private int balance; //정수값을 저장하는 field

    public Account(){
        this(0);
    }

    public Account(int amount){
        balance = amount;
    }

    public int getBalance(){
        return balance;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withdraw(int amount){
        balance -= amount;
    }
}


public class customerAccount extends Account{
    int id;

    public customerAccount(int n){
        this(n, 0);
    }

    public customerAccount(int n, int amount){
        super(amount);
        id = n;
    }

    public int getId(){
        return id;
    }
}


public class MinusAccount extends customerAccount {
    int minusLimitBalance; //마이너스 통장의 한도
    int minusBalance; //마이너스 통장에 남아있는 금액
    //private int firstDeposit; //초기 예금액

    public MinusAccount(int m){ //이거 this(m, 0)해서 된듯...
        //super(id, limit);
    	//super(id);
    	this(m, 0);
    }
    
    public MinusAccount(int m, int amount){
        super(amount);
        minusLimitBalance = m;
    }

    public void deposit(int amount){
        super.deposit(amount);
    }

    public void withdraw(int amount){
        super.withdraw(amount);
    }

    public int minusBal(){ //마이너스 통장 잔액
    	minusBalance = minusLimitBalance;
        return minusBalance;
    }

    public int minusLimitBal(){ //마이너스 통장 한도
        return minusLimitBalance;
    }
}


public class MileageAccount extends MinusAccount{ //마일리지 어카운트
	double mileageRate; //마일리지 비율
	double mileageLimitRate; //마일리지 비율 한도
	int mileageLimitBal; //마일리지 금액 한도
	
	public MileageAccount(double rate) { //r = rate = 비율
		this(rate, 0);
	}
	
    public MileageAccount(double rate, int amount){ //마일리지 금액 
        super(amount);
        mileageRate = rate;
    }
    
    public double MileageRate(double mileageRate) { //마일리지 비율
    	return mileageRate;
    }
	
	public double deposit(int amount, double mileageRate) { //입금
		double mileage;
		mileage = amount * mileageRate;
		double sum;
		sum = amount + mileage;
		return sum;
	}

	public double setMileageRate() { //마일리지 비율 한도
		return mileageLimitRate;
	}
	
	public int getMileageRate() { //마일리지 금액 한도
		return mileageLimitBal;
	}
}


import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		customerAccount kim = new customerAccount(573701); //kim은 변수...!!
		MinusAccount minux = new MinusAccount(5000000);
		//kim은 정수값을 저장하는 게 아니라, 레퍼런스(참조)값을 저장
		//customerAccount 클래스에 가는 길... 이정표 역할...
		
		//마이너스 Account를 만들 때
		//id, 마이너스 한도값, 초기 예금액까지 전달받는 생성자를 하나 더 만드세요!!

		System.out.println("고객님의 아이디: " + kim.getId());
		System.out.println(kim.getId() + " 고객님의 잔액 " + kim.getBalance() + "원");
		kim.deposit(1000000);
		System.out.println(kim.getId() + " 고객님의 잔액 " + kim.getBalance() + "원");
		System.out.println(kim.getId() + " 고객님의 마이너스 통장 한도 " + minux.minusLimitBal() + "원");
		System.out.println(kim.getId() + " 고객님의 출금 가능 잔액 " + (minux.minusLimitBal() + kim.getBalance()) + "원");
		kim.withdraw(3000000);
		System.out.println(kim.getId() + " 고객님의 마이너스 통장 잔액 " + (minux.minusBal()+kim.getBalance()) + "원");
		System.out.println(kim.getId() + " 고객님의 출금 가능 잔액 " + (minux.minusLimitBal() + kim.getBalance()) + "원");
	}
}



public class Tester2 {

	public static void main(String[] args) {
		customerAccount kim = new customerAccount(573701);
		MileageAccount mil = new MileageAccount(0.1);

		System.out.println("고객님의 아이디: " + kim.getId());
		System.out.println(kim.getId() + " 고객님의 마일리지 비율 " + mil.MileageRate(0.1));
		System.out.println(kim.getId() + " 고객님의 잔액 " + (mil.deposit(100000, 0.1)) + "원");
	}
}