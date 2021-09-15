import Payment.Payment;
import Payment.PaymentType;
import Person.Person;
import Resource.ResourceSelection;
import ViewController.CommandController;
import ViewController.CommandExecutor;
import ViewController.PaymentController;
import ViewController.PersonController;

import java.util.List;
import java.util.Scanner;

public class PaymentDialog {
    private CommandExecutor commandExecutor;
    private String menuOption;

    private PaymentType paymentType;
    private List<Person> personListget;

    public PaymentDialog() {
        this.commandExecutor = new CommandExecutor();
    }

    public String showMenu(){

        System.out.println("1: Add Payment\n2: Delete Payment\n3: View Payment");
        Scanner scanner = new Scanner(System.in);
        String selectedOption = scanner.next();
        switch (selectedOption){
            case"1":{
                this.menuOption ="51";
                return menuOption;
            }
            case"2":{
                this.menuOption ="52";
                return menuOption;
            }
            case"3":{
                this.menuOption ="53";
                return menuOption;
            }
            default:{
                throw new IllegalStateException("Input not known! Please try again" );
            }
        }
    }
    public List<Payment> dataInput(List<Payment> paymentList,List<Person> personList){
        System.out.println("Please select the number of the person that should send the amount");
        for(int i=0; i < personList.size(); i++){
            System.out.println(i + " " + personList.get(i).getName() );
        }
        Scanner scanner2 = new Scanner(System.in);
        String senderInput = scanner2.next();
        Person personSender = personList.get(Integer.parseInt(senderInput));


        System.out.println("Please select the number of the person that receives the amount");
        for(int i=0; i < personList.size(); i++){
            System.out.println(i + " " + personList.get(i).getName() );
        }
        Scanner scanner3 = new Scanner(System.in);
        String receiverInput = scanner3.next();
        Person personReceiver = personList.get(Integer.parseInt(receiverInput));

        System.out.println("Please enter the amount that should be transacted");
        Scanner scanner4 = new Scanner(System.in);
        String amountInput = scanner4.next();
        int amount = Integer.parseInt(amountInput);

        System.out.println("Please enter the Password for the sending Person");
        Scanner scanner5 = new Scanner(System.in);
        String credentialIdentifierInput = scanner5.next();

        System.out.println("Please select a payment type\n1: PayPal\n2: Google Wallet\n3: Mobile Money Wallet");
        Scanner scanner6= new Scanner(System.in);
        String paymentTypeInput = scanner6.next();

        switch (paymentTypeInput){
            case"1":
                this.paymentType =PaymentType.PayPal;
                break;
            case"2":
                this.paymentType =PaymentType.GoogleWallet;
                break;
            case"3":
                this.paymentType =PaymentType.MobileMoneyWallet;
                break;
        }

        CommandController paycon1 = new PaymentController(paymentType, personSender, personReceiver, amount, credentialIdentifierInput);
        commandExecutor.executeCommand("transactPayment",paycon1);
        Payment pay1 = ((PaymentController) paycon1).getPayment();
        paymentList.add(pay1);
        int iSender = Integer.parseInt(senderInput);
        int iReceiver = Integer.parseInt(receiverInput);
        personList.set(iSender,((PaymentController)paycon1).getPersonSender());
        personList.set(iReceiver,((PaymentController)paycon1).getPersonReceiver());
        this.personListget = personList;
        return paymentList;
    }
    public List<Payment> dataDelete(List<Payment> paymentList){
        System.out.println("Please enter the number of the paymnet you want to delete");
        for(int i=0; i < paymentList.size(); i++){
            System.out.println(i +" "+ paymentList.get(i).getSender().getInhaber().getName() +" "+ paymentList.get(i).getDate() );
        }
        Scanner scanner14 = new Scanner(System.in);
        String numberInput = scanner14.next();
        paymentList.remove(Integer.parseInt(numberInput));
        return paymentList;
    }
    public void dataOutput(List<Payment> paymentList){
        System.out.println("Curren payments");
        for(int i=0; i < paymentList.size(); i++){
            System.out.println(i +" "+ paymentList.get(i).getSender().getInhaber().getName() +" "+ paymentList.get(i).getDate() );
        }

    }
    public List<Person> getPersonList(){
        return personListget;
    }
}


