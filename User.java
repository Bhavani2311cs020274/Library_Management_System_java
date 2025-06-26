import java.util.*;

public class User {
    private String userId;
    private String name;
    private List<Book> issuedBooks;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }

    public void issueBook(Book book) {
        issuedBooks.add(book);
    }

    public void returnBook(Book book) {
        issuedBooks.remove(book);
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User: ").append(userId).append(" - ").append(name).append("\n");

        if (issuedBooks.isEmpty()) {
            sb.append("No books issued\n");
        } else {
            sb.append("Books Issued:\n");
            for (Book book : issuedBooks) {
                sb.append("").append(book.getTitle())
                  .append(" (").append(book.getId()).append(")\n");
            }
        }
        return sb.toString();
    }
}
