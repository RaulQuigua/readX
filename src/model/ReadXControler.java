/**
 * ReadXControler Class
 * This class represents the controller for the ReadX project.
 * It manages the users, magazines, and books in the system.
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class ReadXControler {
    private ArrayList<User> users;
    private ArrayList<Magazine> magazines;
    private ArrayList<Book> books;
    private static final String[] ADDS = {"Do you want to experience an explosion of flavor on your palate? Try our delicious product now and feel the perfect combination of sweet and salty in every bite. With the highest quality ingredients and carefully controlled production process, we guarantee a unique and unforgettable gastronomic experience. Don't wait any longer to try it and amaze your senses!"};
    private Random random;
    /**
     * Constructor for ReadXControler class.
     * Initializes the lists for users, magazines, and books.
     */
    public ReadXControler() {
        Calendar date = Calendar.getInstance();
        books = new ArrayList<Book>();
        books.add(new Book("Icesi Active Learning", date, 344, "A beautiful Book", 45000, "4DF", 1, "Icesi.com"));
        magazines = new ArrayList<Magazine>();
        users = new ArrayList<User>();
        random = new Random();
    }

    /**
     * Adds a free user to the system.
     *
     * @param name  The name of the user.
     * @param id    The ID of the user.
     * @param adds  The flag indicating if the user wants to receive ads.
     * @param date  The registration date of the user.
     * @param email The email of the user.
     * @return A message indicating the result of the operation.
     */
    public String addUser(String name, String id, boolean adds, Calendar date, String email) {
        String message = "User already exists";
        if (searchUser(id) == null) {
            if (users.size() < 15) {
                users.add(new UserFree(name, id, date, email));
                message = "User free added successfully";
            } else {
                message = "Cannot add more clients";
            }
        }
        return message;
    }

    /**
     * Adds a premium user to the system.
     *
     * @param name       The name of the user.
     * @param id         The ID of the user.
     * @param adds       The flag indicating if the user wants to receive ads.
     * @param date       The registration date of the user.
     * @param email      The email of the user.
     * @param nickname   The nickname of the user.
     * @param avatar     The avatar of the user.
     * @param creditCard The credit card information of the user.
     * @return A message indicating the result of the operation.
     */
    public String addUser(String name, String id, boolean adds, Calendar date, String email, String nickname, String avatar, String creditCard) {
        String message = "User already exists";
        if (searchUser(id) == null) {
            if (users.size() < 15) {
                users.add(new UserPremium(name, id, date, email, nickname, avatar, creditCard));
                message = "User premium added successfully";
            } else {
                message = "Cannot add more clients";
            }
        }
        return message;
    }

    /**
     * Adds a critical user to the system.
     *
     * @param name         The name of the user.
     * @param id           The ID of the user.
     * @param adds         The flag indicating if the user wants to receive ads.
     * @param date         The registration date of the user.
     * @param email        The email of the user.
     * @param nickname     The nickname of the user.
     * @param avatar       The avatar of the user.
     * @param creditCard   The credit card information of the user.
     * @param area         The area of expertise of the user.
     * @param criticsCount The number of critics made by the user.
     * @param blog         The user's blog URL.
     * @return A message indicating the result of the operation.
     */
    public String addUser(String name, String id, boolean adds, Calendar date, String email, String nickname, String avatar, String creditCard, String area, int criticsCount, String blog) {
        String message = "";
        if (searchUser(id) == null) {
            users.add(new UserCritical(name, id, date, email, nickname, avatar, creditCard, area, criticsCount, blog));
            message = "User critical added successfully";
        } else {
            message = "Cannot add more users";
        }
        return message;
    }

    /**
     * Generates payments for premium users.
     *
     * @return A message indicating the generated payments.
     */
    public String generarCobros() {
        String message = "";
        for (User usuario : users) {
            if (usuario instanceof UserPremium) {
                UserPremium usuarioPremium = (UserPremium) usuario;
                double cobro = 15000;
                usuarioPremium.generatepay(cobro);
                message += "Nombre: " + usuarioPremium.getName() +
                        ", ID: " + usuarioPremium.getId() +
                        ", Email: " + usuarioPremium.getEmail() +
                        ", Cobro: " + cobro + "\n";
            }
        }
        return message;
    }

    /**
     * Generates random ads for a user.
     *
     * @param id The ID of the user.
     * @return The generated ads message.
     */
    public String generateAdds(String id) {
        String messageAdds = "";
        for (User user : users) {
            if (user != null && user instanceof UserFree && user.getId().equals(id) && ((UserFree) user).isAdds()) {
                messageAdds = ADDS[random.nextInt(ADDS.length)];
            }
        }
        return messageAdds;
    }

    /**
     * Generates a surprise message for users.
     *
     * @param j      The integer parameter for the surprise.
     * @param letter The character parameter for the surprise.
     * @return The surprise message.
     */
    public String surprise(int j, char letter) {
        String message = "";
        for (User user : users) {
            if (user != null && user.surprise(j, letter) != null) {
                message += user.surprise(j, letter) + "\n";
            }
        }
        return message;
    }

    /**
     * Generates a random surprise message for users.
     *
     * @return The surprise message.
     */
    public String surprise() {
        char letter = (char) (random.nextInt(26) + 'a');
        int randomInt = random.nextInt(12);
        return surprise(randomInt, letter);
    }

       /**
     * Counts the number of critics for each user and returns the user with the highest number of critics.
     *
     * @return A message indicating the user with the highest number of critics.
     */
    public String countCritics() {
        String message = "";
        int max = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof UserCritical) {
                if (((UserCritical) users.get(i)).getCriticsCount() > max) {
                    max = ((UserCritical) users.get(i)).getCriticsCount();
                    message = users.get(i).getName() + " is the person with more critics";
                }
            }
        }
        return message;
    }

    /**
     * Adds a book to the library.
     *
     * @param name       The name of the book.
     * @param date       The publication date of the book.
     * @param numPages   The number of pages in the book.
     * @param review     The review of the book.
     * @param value      The value of the book.
     * @param id         The ID of the book.
     * @param gender     The gender of the book.
     * @param frontPage  The front page of the book.
     * @return A message indicating the result of the operation.
     */
    public String addBooks(String name, Calendar date, int numPages, String review, int value, String id, int gender, String frontPage) {
        String message = "";
        int MAX_BOOKS = 100;
        if (books.size() >= MAX_BOOKS) {
            message = "Can't add more books";
        } else {
            Book book = new Book(name, date, numPages, review, value, id, gender, frontPage);
            books.add(book);
            message = "Book added successfully";
        }
        return message;
    }

    /**
     * Adds a magazine to the library.
     *
     * @param name              The name of the magazine.
     * @param date              The publication date of the magazine.
     * @param numPages          The number of pages in the magazine.
     * @param value             The value of the magazine.
     * @param id                The ID of the magazine.
     * @param issuancePeriodicity The issuance periodicity of the magazine.
     * @return A message indicating the result of the operation.
     */
    public String addMagazine(String name, Calendar date, int numPages, int value, String id, int issuancePeriodicity) {
        String message = "";
        Magazine newMagazine = new Magazine(name, date, numPages, value, id, issuancePeriodicity);

        int MAX_MAGAZINES = 100;
        if (magazines.size() < MAX_MAGAZINES) {
            magazines.add(newMagazine);
            message = "Magazine added successfully";
        } else {
            message = "Cannot add more magazines, max limit reached";
        }

        return message;
    }

    /**
     * Searches for a user by their ID.
     *
     * @param id The ID of the user.
     * @return The user object if found, or null if not found.
     */
    public User searchUser(String id) {
        User user = null;
        boolean found = false;
        for (int i = 0; i < users.size() && !found; i++) {
            if (users.get(i) != null && users.get(i).getId().equals(id)) {
                user = users.get(i);
                found = true;
            }
        }
        return user;
    }

    /**
     * Searches for a magazine and returns its string representation.
     *
     * @return The string representation of the first found magazine, or null if no magazines are found.
     */
    public String searchMagazine() {
        for (Magazine magazine : magazines) {
            if (magazine != null) {
                return magazine.toString();
            }
        }
        return null;
    }

    /**
     * Searches for a book and returns its string representation.
     *
     * @return The string representation of the first found book, or null if no books are found.
     */
    public String searchBook() {
        for (Book book : books) {
            if (book != null) {
                return book.toString();
            }
        }
        return null;
    }

    /**
     * Searches for a book and returns its name.
     *
     * @return The name of the first found book, or null if no books are found.
     */
    public String searchBookName() {
        for (Book book : books) {
            if (book != null) {
                return book.getName();
            }
        }
        return null;
    }

    /**
     * Allows a user to buy a book.
     *
     * @param userId    The ID of the user.
     * @param bookName  The name of the book.
     * @return A message indicating the result of the operation.
     */
    public String buyBook(String userId, String bookName) {
        User user = searchUser(userId);
        if (user == null) {
            return "User not found";
        }
        Book book = null;
        for (Book b : books) {
            if (b != null && b.getName().equals(bookName)) {
                book = b;
                break;
            }
        }
        if (book == null) {
            return "Book not found";
        }
        user.addBookUser(book);
        return "Book bought successfully";
    }

    /**
     * Allows a user to buy a magazine.
     *
     * @param userId  The ID of the user.
     * @param MagName The name of the magazine.
     * @return A message indicating the result of the operation.
     */
    public String buyMagazine(String userId, String MagName) {
        User user = searchUser(userId);
        if (user == null) {
            return "User not found";
        }
        Magazine mag = null;
        for (Magazine m : magazines) {
            if (m != null && m.getName().equals(MagName)) {
                mag = m;
                break;
            }
        }
        if (mag == null) {
            return "Magazine not found";
        }
        user.addMagazineUser(mag);
        return "Magazine bought successfully";
    }

    /**
     * Shows the library of a premium user.
     *
     * @param id The ID of the user.
     * @return A message representing the library of the user.
     */
    public String showBiblioP(String id) {
        String message = "";
        User premium = searchUser(id);
        premium.inicializarBiblioteca();
        premium.Fillbiblio();
        if (premium != null) {
            message = premium.mostrarBiblioteca();
        }
        return message;
    }

    /**
     * Returns the library of a user as a 2D array.
     *
     * @param id The ID of the user.
     * @return The library of the user as a 2D array, or null if the user is not found.
     */
    public String[][] getBiblio(String id) {
        User user = searchUser(id);
        String[][] Biblio = null;
        if (user != null) {
            Biblio = user.getBiblio();
        }
        return Biblio;
    }

    /**
     * Returns the number of pages of a book in the user's library.
     *
     * @param id        The ID of the user.
     * @param bookName  The name of the book.
     * @return The number of pages of the book, or 0 if the user or book is not found.
     */
    public int numPages(String id, String bookName) {
        User user = searchUser(id);
        int pages = 0;
        if (user != null) {
            pages = user.getPagesBook(bookName);
        }
        return pages;
    }

    /**
     * Returns the name of a book in the user's library.
     *
     * @param id        The ID of the user.
     * @param bookName  The name of the book.
     * @return The name of the book, or an empty string if the user or book is not found.
     */
    public String nameBook(String id, String bookName) {
        User user = searchUser(id);
        String pages = "";
        if (user != null) {
            pages = user.getNameBook(bookName);
        }
        return pages;
    }
}

