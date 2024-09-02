import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String uniqueBookNumber;

    public Book(String title, String author, String uniqueBookNumber) {
        this.title = title;
        this.author = author;
        this.uniqueBookNumber = uniqueBookNumber;
    }

    //get the title of the book
    public String getTitle() {
        return title;
    }
    
    //get the author of the book
    public String getAuthor() {
        return author;
    }
    
    //get the uniqueBookNumber of the book
    public String getUniqueBookNumber() {
        return uniqueBookNumber;
    }

    public String info() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + uniqueBookNumber;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    //function to add a book into library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }
    
    //function to remove a book from library
    public void removeBook(String uniqueBookNumber) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getUniqueBookNumber().equals(uniqueBookNumber)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    //function to view all books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library currently.");
        } else {
            System.out.println("Books available in the library:");
            for (Book book : books) {
                System.out.println(book.info());
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String uniqueBookNumber = scanner.nextLine();
                    Book newBook = new Book(title, author, uniqueBookNumber);
                    library.addBook(newBook);
                    break;

                case 2:
                    System.out.print("Enter unique book number to remove: ");
                    String uniqueBookNumberInput = scanner.nextLine();
                    library.removeBook(uniqueBookNumberInput);
                    break;

                case 3:
                    library.viewBooks();
                    break;

                case 4:
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
