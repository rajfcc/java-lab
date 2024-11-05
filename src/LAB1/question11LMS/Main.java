package LAB1.question11LMS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        You are tasked with developing a simple Library Management System. This system should allow users to perform the following operations:
//        Add New Books: Books should have properties like title, author, ISBN, and availability status.
//        Add New Members: Members should have properties like name, membership ID, and a list of borrowed books.
//                Issue and Return Books: Members should be able to borrow and return books. Ensure that a book cannot be issued if it is already borrowed by someone else.
//        Search for Books: Users should be able to search for books by title, author, or ISBN.
//                Display Book and Member Details: Provide methods to display details of all books and all members.
//                Requirements:
//        Use inheritance to create base classes and derived classes where applicable.
//                Implement interfaces to define common behaviors.
//                Use abstract classes to define abstract methods that must be implemented by subclasses.
//                Implement encapsulation by making class fields private and providing public getter and setter methods.
//        Demonstrate polymorphism by using method overriding.
//        Ensure proper use of constructors, including copy constructors.
//        Handle exceptions to manage scenarios like issuing an already borrowed book.
//                Use arrays or ArrayList for storing books and members.
        Scanner sc = new Scanner(System.in);
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        MultiValueHashMap<Integer,Book> borrowedBook = new MultiValueHashMap<>();
        String tempName="";
        int tempMembershipId=0;
        String tempTitle="", tempAuthor="";
        Long tempIsbn=0L;
        while(true) {
            System.out.println("<------Available Options----->");
            System.out.println("1. Add New Books");
            System.out.println("2. Add New Members ");
            System.out.println("3. Display all the books");
            System.out.println("4. Display all the members");
            System.out.println("5. Issue a book");
            System.out.println("6. Return a book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.next();

            switch (choice) {
                //Adding New Books
                case "1":
                    System.out.print("Title: ");
                    tempTitle = sc.next();
                    System.out.print("Author: ");
                    tempAuthor = sc.next();
                    System.out.print("ISBN: ");
                    tempIsbn = sc.nextLong();
                    books.add(new Book(tempTitle, tempAuthor, tempIsbn));
                    break;


                //Adding new member
                case "2":
                    System.out.print("Name: ");
                    tempName = sc.next();
                    System.out.print("Membership ID: ");
                    tempMembershipId = sc.nextInt();
                    members.add(new Member(tempName, tempMembershipId));
                    break;

                //Display all the Books
                case "3":
                    System.out.println("The list of books are: ");
                    System.out.printf("%-30s %-25s %-20s %-25s","Title","Author","ISBN","Availability Status");
                    System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------");
                    for (Book b : books) {
                        String availability = b.isAvailabilityStatus() ? "Available" : "Borrowed";
                        System.out.printf("%-30s %-25s %-20d %-25s",b.getTitle(),b.getAuthor(),b.getIsbn(),availability);
                        System.out.print("\n");
                    }
                    System.out.println("<-------End of List------->\n\n");
                    break;

                //Display all the members
                case "4":
                    System.out.println("The list of members are: ");
                    System.out.printf("%-30s %-25s","Name","Membership ID");
                    System.out.println("\n---------------------------------------");
                    for (Member m : members) {
                        System.out.printf("%-30s %-25s",m.getName(),m.getMembershipId());
                        System.out.print("\n");
                    }
                    System.out.println("<-------End of List------->\n\n");

                    break;


                //Issue a book
                case "5":
                    System.out.print("Enter the title of book: ");
                    tempTitle = sc.next();
                    boolean memFound = false;
                    for(Book b: books){
                        if(b.getTitle().equals(tempTitle)){
                            System.out.print("Enter the Membership ID: ");
                            tempMembershipId = sc.nextInt();
                            for(Member m: members){
                                if(m.getMembershipId()==tempMembershipId){
                                    memFound = true;
                                    b.setAvailabilityStatus(false);
                                    borrowedBook.put(tempMembershipId,b);
                                    break;
                                }
                            }
                            if(!memFound){
                                System.out.println("Member not found.");
                            }
                            break;
                        }
                    }
                    System.out.println("Book not found.");
                    break;
                //Return a book
                case "6":
                    System.out.print("Enter the Membership ID: ");
                    tempMembershipId = sc.nextInt();
                    List<Book> b1 = borrowedBook.get(tempMembershipId);
                    boolean memberFound = false;
                    boolean bookFound = false;
                    if(b1!=null){
                        System.out.print("Enter the book title: ");
                        tempTitle= sc.next();
                        for(Book b: b1){
                            if(b.getTitle().equals(tempTitle)){
                                bookFound = true;
                                b.setAvailabilityStatus(true);
                                System.out.println("System Updated.");
                                break;
                            }
                        }
                        if(!bookFound){
                            System.out.println("Book not found.");
                        }
                    }
                    else{
                        for(Member m: members){
                            if(tempMembershipId==m.getMembershipId()){
                                memberFound = true;
                                System.out.println("User has not borrowed any book");
                                break;
                            }
                        }
                        if(!memberFound){
                            System.out.println("Member not found");
                        }
                    }
                    break;

                case "0":
                    return;

                default:
                    System.out.println("Enter valid characters only!!");

            }
        }
    }
}
