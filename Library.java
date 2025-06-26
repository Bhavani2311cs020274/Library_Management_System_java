import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        
    }

    public void addUser(User user) {
        users.add(user);
        
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\nAll Books ");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println("No users in the system.");
        } else {
            System.out.println("\nUsers and Their Issued Books");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    public void issueBook(String bookId, String userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (user == null) {
            System.out.println("User not found.");
        } else if (book.isIssued()) {
            System.out.println("Book is already issued.");
        } else {
            book.issue();
            user.issueBook(book);
            System.out.println("Book issued to " + user.getName());
        }
    }

    public void returnBook(String bookId, String userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null || user == null) {
            System.out.println("Book or User not found.");
        } else if (!book.isIssued()) {
            System.out.println("Book is not issued.");
        } else {
            book.returnBook();
            user.returnBook(book);
            System.out.println("Book returned.");
        }
    }

    private Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id))
                return book;
        }
        return null;
    }

    private User findUserById(String id) {
        for (User user : users) {
            if (user.getUserId().equalsIgnoreCase(id))
                return user;
        }
        return null;
    }
}
