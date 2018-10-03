import java.util.Scanner;

// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.



/*
* add instructions after adding
* give quit options for inner menus
* make alphebetizers
* search by number
* file saving ()
* exception handling
* */
public class Main {


    public static void main(String args []){
        boolean flag = true;
        //we must instantiate a specific phone to run.
        MobilePhone thisPhone = new MobilePhone();

       printMenu();

        while(flag){ // to keep looking for an int.

            boolean flag2 = false;
            Scanner res = new Scanner(System.in);
            int userChoice = res.nextInt();

            while(flag2==false){ // to stop analyzing the scanner in.
                switch(userChoice){
                    case 0:
                        printMenu();
                        flag2=true;
                        break;
                    case 1:
                        thisPhone.add();
                        flag2=true;
                        break;
                    case 2:
                        thisPhone.searchContacts();
                        flag2=true;
                        break;
                    case 3:
                        thisPhone.showContacts();
                        flag2=true;
                        break;
                    case 4:
                        thisPhone.editContacts();
                        flag2=true;
                        break;
                    case 5:
                        thisPhone.deleteContact();
                        flag2=true;
                        break;
                    case 6:
                        System.out.println("Goodbye");
                        flag=false;
                        flag2=true;
                        break;
                    default:
                        break;
                }
            }



        }


    }

    public static void printMenu(){

        System.out.println("**************************************************************************");
        System.out.println("OPTIONS \n 0. Show Options \n 1. Add a Contact \n 2. Search Contacts " +
                "\n 3. Show Contacts \n 4. Edit a Contact \n 5. Delete a Contact \n 6. Done "
        );
        System.out.println("***************************************************************************");

    }



}
