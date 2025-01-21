import java.util.Scanner;
public class ATMInterface {
    double bal;
    public ATMInterface(double amt){
        this.bal=amt;
    }
    public void deposit(double amt) {
        if (amt > 0) {
            bal += amt;
            System.out.println("Successfully Deposited!\nNew Balance: Rs" + bal);
        } else {
            System.out.println("Invalid amount. Please try again. ");
        }
    }

    public void withdraw(double amt) {
        if (amt > 0 && amt <= bal) {
            bal -= amt;
            System.out.println("Withdrawal Successful!\nNew balance: Rs" + bal);
        } else if (amt > bal) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance: Rs" + bal);
    }
}
class ATM{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        ATMInterface acc= new ATMInterface(5000.0);
        System.out.println("Welcome to the ATM Interface!");
        while(true){
            System.out.println("\nSelect an option:\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");

            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    acc.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dAmt = sc.nextDouble();
                    acc.deposit(dAmt);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double wAmt = sc.nextDouble();
                    acc.withdraw(wAmt);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}

