package day23;

public class BankAccount {
	private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        double newBalance = balance + amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", new balance: " + newBalance);
        balance = newBalance;
    }
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            double newBalance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", new balance: " + newBalance);
            balance = newBalance;
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient balance.");
        }
    }
    public synchronized double getBalance() {
        return balance;
    }
	public static void main(String[] args) {
		 BankAccount account = new BankAccount(1000.0);

	        Runnable depositTask = () -> {
	            for (int i = 0; i < 10; i++) {
	                account.deposit(100);
	                try {
	                    Thread.sleep((int)(Math.random() * 100));
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        };
	        Runnable withdrawTask = () -> {
	            for (int i = 0; i < 10; i++) {
	                account.withdraw(50);
	                try {
	                    Thread.sleep((int)(Math.random() * 100));
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        };
	        Thread thread1 = new Thread(depositTask, "Thread-1");
	         Thread thread2 = new Thread(withdrawTask, "Thread-2");

	        thread1.start();
	         thread2.start();

	        try {
	         thread1.join();
	         thread2.join();
	        } catch (InterruptedException e) {
	         e.printStackTrace();
	        }
	        System.out.println("Final balance: " + account.getBalance());
		// TODO Auto-generated method stub

	}

}
