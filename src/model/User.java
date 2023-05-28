package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Abstract class representing a user in the library system.
 */
public abstract class User {
    private String name;
    private String id;
    private final boolean adds = true;
    private Calendar date;
    private String email;
    private ArrayList<Book> booksUser;
    private ArrayList<Magazine> magazinesuser;
    private String[][] biblio;

    /**
     * Constructor for the User class.
     *
     * @param name  The name of the user.
     * @param id    The identifier of the user.
     * @param date  The registration date of the user.
     * @param email The email of the user.
     */
    public User(String name, String id, Calendar date, String email) {
        this.name = name;
        this.id = id;
        this.date = date;
        this.email = email;
        booksUser = new ArrayList<>();
        magazinesuser = new ArrayList<>();
        this.biblio = new String[5][5];
    }

    /**
     * Initializes the library with default values.
     */
    public void inicializarBiblioteca() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                biblio[i][j] = "___";
            }
        }
    }

    /**
     * Retrieves the number of pages of a book.
     *
     * @param bookName The identifier of the book.
     * @return The number of pages of the book, or -1 if not found.
     */
    public int getPagesBook(String bookName) {
        for (Book book : booksUser) {
            if (book.getId().equals(bookName)) {
                return book.getNumPages();
            }
        }
        return -1;
    }

    /**
     * Retrieves the name of a book.
     *
     * @param bookName The identifier of the book.
     * @return The name of the book, or "Book not found" if not found.
     */
    public String getNameBook(String bookName) {
        for (Book book : booksUser) {
            if (book.getId().equals(bookName)) {
                return book.getName();
            }
        }
        return "Book not found";
    }

    /**
     * Fills the library with books and magazines.
     */
    public void Fillbiblio() {
        int x = 0;
        int y = 0;

        for (Book book : booksUser) {
            biblio[x][y] = book.getId();
            y++;
            if (y >= 5) {
                x++;
                y = 0;
            }
            if (x >= 5) {
                break;
            }
        }

        if (x < 5) {
            for (Magazine magazine : magazinesuser) {
                biblio[x][y] = magazine.getId();
                y++;
                if (y >= 5) {
                    x++;
                    y = 0;
                }
                if (x >= 5) {
                    break;
                }
            }
        }
    }

    /**
     * Retrieves the library as a formatted string.
     *
     * @return The formatted string representing the library.
     */
    public String mostrarBiblioteca() {
        StringBuilder sb = new StringBuilder();
        sb.append("Library of ").append(name).append("\n\n");
        sb.append("      ");
        for (int i = 0; i < 5; i++) {
            sb.append(" |    ").append(i).append("    ");
        }
        sb.append("|\n");

        for (int i = 0; i < 5; i++) {
            sb.append("   ").append(i).append("  ");
            for (int j = 0; j < 5; j++) {
                sb.append("|  ");
                if (biblio[i][j] != null) {
                    sb.append(biblio[i][j]);
                }
                sb.append("  ");
            }
            sb.append("|\n");
        }

        return sb.toString();
    }

    /**
     * Adds a book to the user's collection.
     *
     * @param book The book to be added.
     */
    public void addBookUser(Book book) {
        booksUser.add(book);
    }

    /**
     * Adds a magazine to the user's collection.
     *
     * @param magazine The magazine to be added.
     */
    public void addMagazineUser(Magazine magazine) {
        magazinesuser.add(magazine);
    }

    /**
     * Retrieves the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name The name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the identifier of the user.
     *
     * @return The identifier of the user.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the identifier of the user.
     *
     * @param id The identifier of the user.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Checks if the user has ads.
     *
     * @return True if the user has ads, false otherwise.
     */
    public boolean isAdds() {
        return adds;
    }

    /**
     * Retrieves the registration date of the user.
     *
     * @return The registration date of the user.
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * Sets the registration date of the user.
     *
     * @param date The registration date of the user.
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * Retrieves the email of the user.
     *
     * @return The email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email The email of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the first letter of the user's name in lowercase.
     *
     * @return The first letter of the user's name in lowercase.
     */
    public char getFirtsLetter() {
        char firsLetter = Character.toLowerCase(name.charAt(0));
        return firsLetter;
    }

    /**
     * Abstract method to generate a surprise for the user.
     *
     * @param i      The surprise index.
     * @param letter The letter associated with the surprise.
     * @return The generated surprise.
     */
    public abstract String surprise(int i, char letter);

    /**
     * Retrieves the books in the user's collection.
     *
     * @return The books in the user's collection.
     */
    public ArrayList<Book> getBooksUser() {
        return booksUser;
    }

    /**
     * Sets the books in the user's collection.
     *
     * @param booksUser The books in the user's collection.
     */
    public void setBooksUser(ArrayList<Book> booksUser) {
        this.booksUser = booksUser;
    }

    /**
     * Retrieves the library matrix.
     *
     * @return The library matrix.
     */
    public String[][] getBiblio() {
        return biblio;
    }

    /**
     * Sets the library matrix.
     *
     * @param biblio The library matrix.
     */
    public void setBiblio(String[][] biblio) {
        this.biblio = biblio;
    }
}

