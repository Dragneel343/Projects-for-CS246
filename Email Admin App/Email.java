import java.util.Scanner;

public class Email {
   private String firstName;
   private String lastName;
   private String password;
   private String department;
   private String email;
   private int mailboxCap = 500;
   private int defaultpasswordLength = 10;
   private String alternateEmail;
   private String companySuffix = "ANcompany.com";

   //Constructor to receive frist and last name
   public Email(String firstName, String lastName) {
       this.firstName = firstName;
       this.lastName = lastName;
       System.out.println("\n");

       // call method asking for the dept and returns the dept
       this.department = setDepartment();

       // call a method that retruns a random password
       this.password = randomPassword(defaultpasswordLength);
       System.out.println("Your password is: " + this.password);

       //combined elements to generate email
       email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
   }

   // ask for department
   private String setDepartment() {
       System.out.println("New worker:" + lastName + ", " + firstName + ".\n Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department Code: ");
       Scanner in = new Scanner(System.in);
       int depChoice = in.nextInt();
       if (depChoice == 1) { return "Sales"; }
       else if (depChoice == 2) { return "Dev"; }
       else if (depChoice == 3) { return "Acct"; }
       else { return ""; }
   }

   // generate random password
   private String randomPassword(int length) {
       String passwordSet = "ABCDEFGHIJKLMNOPQRSTRUVXYZ0123456789!@#$%-_";
       char[] password = new char[length];
       for (int i = 0; i < length; i++) {
           int rand = (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);
       }
       return new String(password);
   }

   // set mailbox capacity
   public void setMailboxCap(int capacity) {
       this.mailboxCap = capacity;

   }

   //set alternate email
   public void setAltEmail(String altEmail) {
       this.alternateEmail = altEmail;
   }

   //change the password
   public void changePassword(String password) {
       this.password = password;
   }

   public int getMailboxCap() { return mailboxCap; }
   public String getAltEmail() { return alternateEmail; }
   public String getPassword() { return password; }

   public String showInfo() {
       return "DISPLAY NAME: " + firstName + " " + lastName + 
              "\nCOMPANY EMAIL: " + email +
              "\nMAILBOX CAPACITY: " + mailboxCap + "mb";
   }
}
