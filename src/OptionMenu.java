import java.io.IOException;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account{
	Scanner menuInput=new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat(" '$'###,##0.00 ");
	HashMap<Integer, Integer> data= new HashMap<Integer, Integer>();
	
	public void getLogin() throws IOException {
		int x=1;
		do {
			try {
				data.put(1234567, 1234);
				data.put(2345678, 9876);
				data.put(9704367, 9441);
				
				System.out.println("Welcome to The ATM Project ");
				
				System.out.println("Enter Your Customer Number: ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter Your PIN: ");
				setPinNumber(menuInput.nextInt());
			}catch (Exception e) {
				System.out.println("\n"+ "Invalid character(s). only numbers allowed. "+"\n"); 
				x=2;
			}
			for(Entry<Integer,Integer> entry :data.entrySet()) {
				if(entry.getKey()==getCustomerNumber() && entry.getValue()==getPinNumber() ) {
					getAccountType();
			}
		}
		System.out.println("\n"+"Wrong Customer Number or Pin Number" + "\n");
	}while(x==1);
}

public void getAccountType() {
	System.out.println("Select the Account you want to access: ");
	System.out.println("Type 1-Checking Account");
	System.out.println("Type 2-Saving Account");
	System.out.println("Type 3-Exit");

	System.out.println("Choice: ");

	int selection = menuInput.nextInt();
	
	switch(selection) {
	case 1:
		getChecking();
	       break;
	       
	case 2:
		getSaving();
	       break;
	       
	case 3:
		System.out.println("Thanks you for using this ATM,bye");
	      break;
	       
	default:
		System.out.println("\n"+"Invalid Choice"+"\n");
		getAccountType();
	}
}
public void getChecking() {
	System.out.println("Checking Account:");
	System.out.println("Type 1- View Balance");
	System.out.println("Type 2- Withdraw Funds");
	System.out.println("Type 3- Deposit Funds");
	System.out.println("Type 4-Exit");
    System.out.println("Choice: ");
    
   int selection = menuInput.nextInt();
    
    switch(selection) {
    case 1:
    	System.out.println("Your Checking Account Balance is: "+ moneyFormat.format(getCheckingBalance()));
    	getAccountType();
    	break;
    	
    case 2:
    	getcheckingWithdrawInput();
    	getAccountType();
    	break;
    	
    case 3:
    	getcheckingDepositInput();
    	getAccountType();
    	break;
    	
    case 4:
    	System.out.println("Thank You for using this ATM, bye");
    	break;
    	
    default:
    	System.out.println("\n"+"Invalid Choice"+"\n");
    	getChecking();
    }
}

public void getSaving() {
	System.out.println("Saving Account:");
	System.out.println("Type 1- View Balance");
	System.out.println("Type 2- Withdraw Funds");
	System.out.println("Type 3- Deposit Funds");
	System.out.println("Type 4-Exit");
    System.out.println("Choice: ");
    
   int selection = menuInput.nextInt();
    
    switch(selection) {
    case 1:
    	System.out.println("Your Saving Account Balance is: "+ moneyFormat.format(getSavingBalance()));
    	getAccountType();
    	break;
    	
    case 2:
    	getsavingWithdrawInput();
    	getAccountType();
    	break;
    	
    case 3:
    	getsavingDepositInput();
    	getAccountType();
    	break;
    	
    case 4:
    	System.out.println("Thank You for using this ATM, bye");
    	break;
    	
    default:
    	System.out.println("\n"+"Invalid Choice"+"\n");
    	getSaving();
    }
}
}
