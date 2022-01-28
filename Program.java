
public class Program {

	public static void main(String[] args) {
		Account<String> acc1 = new Account<String> ("1876",4500);
		Account<String> acc2 = new Account<String> ("3476",5400);

		Transaction<Account<String>> tran1 = new Transaction<Account<String>>(acc1, acc2, 400);
		tran1.execute();
		tran1 = new Transaction<Account<String>>(acc1, acc2,700);
		tran1.execute();
		
	}
}
class Transaction <T extends Account<String>>{
	private T from;
	private T to;
	private int sum;
	
	public Transaction(T from, T to, int sum) {
		
		this.from = from;
		this.to = to;
		this.sum = sum;
	}
	
	public void execute(){
		if (from.getSum()> sum)
		{
			from.setSum(from.getSum()-sum);
			to.setSum(to.getSum() + sum);
			System.out.printf("Account %s: %d \nAccount %s: %d \n ",
					from.getId(),from.getSum(),to.getId(),to.getSum());
		}
		else {	
			System.out.printf("Operation invalid");
			

		}
	}
	
}
	
	

class Account<T> {
	private T id;
	private int sum;
	
	public Account(T id, int sum) {
		super();
		this.id = id;
		this.sum = sum;
	
	}

	public T getId() {return id;}



	public int getSum() {return sum;}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
}