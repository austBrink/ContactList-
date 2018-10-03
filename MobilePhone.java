import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private ArrayList<Contact> myContacts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // create all the basic functions of contacts as per the prompt.

    public void add() {
        System.out.println("What's your contacts name? ");
        String name = scanner.nextLine();
        System.out.println("What is " + name + " 's phone number?");
        String number = scanner.nextLine();
        myContacts.add(Contact.creatContact(name, number));
        System.out.println("Exemplary! " + name + " with phone number " + number + " was added to contacts! ");
    }

    // rebuilt using  using valued conditions as per methods.
    // consider adding method to search by number.

    public void searchContacts() {
        System.out.println("For whom do you search?");
        String who = scanner.nextLine();
        if(findContactName(who)==-1){
            System.out.println("Sorry, we failed to find " + who + " :( ");
        } else if (findContactName(who)==1){
            int eye = indexOfName(who); // <= clever. a method returning the index of a given name.
            System.out.println(who + " was found!");
            System.out.println("info => " + who + ":" + myContacts.get(eye).getNumber());
        }
//      WHY WONT THIS WORK?!?!?!?!>>>>>>>>>>>>>
//        for (int i = 0; i < myContacts.size(); i++) {
//            String canon = myContacts.get(i).getName();
//            if (who.equals(canon)){
//                System.out.println(who + ":" + myContacts.get(i).getNumber());
//                break;
//            } else {
//                System.out.println(who + " not found D: ");
//                break;
//            }
//
//        }
    }

    public void showContacts() {
        if(myContacts.size()>0) {
            System.out.println("You have " + myContacts.size() + " Contacts! ^.^ ");
            for (int n = 0; n < myContacts.size(); n++) {
                System.out.println(myContacts.get(n).getName() + ":" + myContacts.get(n).getNumber());
            }
        }else{
            System.out.println("You don't have any contacts to show at this juncture ): we behoove you to observe the menu options");
        }
    }

    public void editContacts(){
        boolean looper=true;
        while(looper){
            boolean nestedLooper = false;
            System.out.println("Do you want to edit a name (enter 0 ) or number (enter 1) ?");
            Scanner choices = new Scanner(System.in);
            int choice = choices.nextInt();

            while(nestedLooper == false){
                switch(choice){
                    case 0:
                        nameChange();
                        nestedLooper = true;
                        looper = false;
                        break;
                    case 1:
                        numberChange();
                        nestedLooper = true;
                        looper = false;
                        break;
                    default:
                        System.out.println("oops");
                        nestedLooper = true;
                }
            }

        }

    }
//     juneEigth: AUSTIN: FIXED! purrs like a kitten! //NEEDS REBUILT WITH NEW FIND METHOD
    public void nameChange() {
        System.out.println("Who's name do you want to change?");
        String reNameMe = scanner.nextLine();
        if(findContactName(reNameMe)==1){
            System.out.println("What do you want " + reNameMe + "'s new name to be?");
            String newName = scanner.nextLine();
            myContacts.set(indexOfName(reNameMe),Contact.creatContact(newName,myContacts.get(indexOfName(reNameMe)).getNumber()));
            System.out.println("Mission success! What was " + reNameMe + " is now " + newName);// <=== wowza!
                   } else if (findContactName(reNameMe) ==-1){
            System.out.println("Many Apologies, we couldn't find " + reNameMe + "....(*sadFace*)...");
        }
    }

    public void numberChange(){
        System.out.println("who's number do you want to change?");
        String reNumberMe = scanner.nextLine();
        if(findContactName(reNumberMe) == 1){
            System.out.println("What do you want " + reNumberMe + "'s new number to be?");
            String newNumber = scanner.nextLine();
            myContacts.set(indexOfName(reNumberMe),Contact.creatContact(reNumberMe,newNumber));
            System.out.println("Exemplary! " + reNumberMe + "'s number is now " + newNumber );
        } else if (findContactName(reNumberMe) == -1){
            System.out.println("There is no " + reNumberMe + ":(");
        }

    }


    public void deleteContact() {
        System.out.println("Which contact do you want to be rid of?");
        String deleteMe = scanner.nextLine();
        if(findContactName(deleteMe)==1){
            myContacts.remove(myContacts.get(indexOfName(deleteMe)));
            System.out.println("Success! " + deleteMe + " was removed from your contacts");
        } else if(findContactName(deleteMe)==-1){
            System.out.println("Hmmmm... looks like you don't have a " + deleteMe + " in your Contacts :/ ");
        }
    }

    //used to extract index (list no.) of a given contact. not sure when this would be useful.
    private int findContactName(Contact contact){
        return this.myContacts.indexOf(contact);
    }
// still unsure why old method failed.....
    private int findContactName(String nameSearch){
        for(int i=0; i< myContacts.size(); i++){
            Contact aContact = myContacts.get(i);
            if(aContact.getName().equals(nameSearch)){
                return 1;
            }
        }
        return -1;
    }
    private int findContactNumber(String numberSearch){
        for(int i=0; i< myContacts.size(); i++){
            Contact aContact = myContacts.get(i);
            if(aContact.getNumber().equals(numberSearch)){
                return 1;
            }
        }
        return -1;

    }
//again made a method to return the index of given object info. uses the index in the for loop created to find such an object. clever.
    private int indexOfName(String aName){
        for(int i=0; i< myContacts.size(); i++){
            Contact aContact = myContacts.get(i);
            if(aContact.getName().equals(aName)){
                return i;
            }
        }
        return -1;

    }

    private int indexOfNumber(String aNumber){
        for(int i=0; i< myContacts.size(); i++){
            Contact aContact = myContacts.get(i);
            if(aContact.getNumber().equals(aNumber)){
                return i;
            }
        }
        return -1;
    }
}



