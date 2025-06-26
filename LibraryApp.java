import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Sample data
        library.addBook(new Book("Book1", "The Alchemist", "Paulo Coelho"));
        library.addBook(new Book("Book2", "1984", "George Orwell"));
        library.addUser(new User("User1", "Alice"));
        library.addUser(new User("User2", "Bob"));

        int choice;
        do {
            System.out.println("\nLIBRARY MENU :-");
            System.out.println("\n1. Show all books");
            System.out.println("2. Upload a new book");
            System.out.println("3. Add a new user");
            System.out.println("4. Issue a book");
            System.out.println("5. Return a book");
            System.out.println("6. Show all users and their books");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Book Name: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(bookId, title, author));
                    break;
                case 3:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = scanner.nextLine();
                    library.addUser(new User(userId, name));
                    break;
                case 4:
                    System.out.print("Enter Book ID to issue (Not Name): ");
                    String issueBookId = scanner.nextLine();
                    System.out.print("Enter User ID (Not Name): ");
                    String issueUserId = scanner.nextLine();
                    library.issueBook(issueBookId, issueUserId);
                    break;
                case 5:
                    System.out.print("Enter Book ID (Not Name) to return: ");
                    String returnBookId = scanner.nextLine();
                    System.out.print("Enter User ID (Not Name): ");
                    String returnUserId = scanner.nextLine();
                    library.returnBook(returnBookId, returnUserId);
                    break;
                case 6:
                    library.showUsers();
                    break;
                case 0:
                    System.out.println("\nExiting program. Bye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
