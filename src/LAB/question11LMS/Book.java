package LAB.question11LMS;

public class Book {
    private String title;
    private String author;
    private Long isbn;
    private boolean availabilityStatus;


    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
    Book(String title,String author, Long isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.availabilityStatus = true;
    }


}
