package LAB1.question11LMS;

import java.util.ArrayList;

public class Member {
    private String name;
    private int membershipId;

    private ArrayList<Book> booksBorrowed;

    public ArrayList<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public String getName() {
        return name;
    }
    public void setBooksBorrowed(Book book) {
        booksBorrowed.add(book);
    }

    Member(String name, int membershipId){
        this.name = name;
        this.membershipId = membershipId;
        this.booksBorrowed = new ArrayList<Book>();
    }

}
