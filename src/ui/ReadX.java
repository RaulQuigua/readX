package ui;
import javax.swing.*;
import model.*;
import java.util.Calendar;

public class ReadX {
    static ReadXControler controler = new ReadXControler();
    static ReadX AppReadX = new ReadX();

    public static void main(String[] args) {
        AppReadX.menu();

    }
    public void menu() {
        boolean onLoop = true;
        while (onLoop) {
            String[] opciones = {"Register User Free", "Register User Premium", "Generate pay","Add bibliography products", "Buy products","Simulate reading","Exit"};
            String option = (String) JOptionPane.showInputDialog(null, "Choose an option", "Menu", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            switch (option) {
                case "Register User Free":
                    AppReadX.addUser(1);
                    break;
                case "Register User Premium":
                    AppReadX.addUser(0);
                    break;
                case "Register user Critical":
                    AppReadX.addUser(2);
                    break;
                case "Generate all surprises":
                    AppReadX.surprise(0);
                    break;
                case "Generate all random surprises":
                    AppReadX.surprise(1);
                    break;
                case "User with more critics":
                    AppReadX.countCritics();
                    break;
                case "Generate pay":
                    AppReadX.generatePayment();
                    break;
                case "Add bibliography products":
                    AppReadX.AddBibliographyProduct();
                break;
                case "Buy products":
                    AppReadX.buyProduct();
                break;
                case "Show biblio":
                    AppReadX.showBiblio();
                    break;
                case "Simulate reading":
                    AppReadX.simularSesionLectura();
                    break;
                case "Exit":
                    onLoop = false;
                    break;
            }
        }
    }
    public void addUser(int type){
        if (type == 0) {
            String name = JOptionPane.showInputDialog("Enter your name: ");
            String id = JOptionPane.showInputDialog("Enter your ID: ");
            Boolean adds = false;
            Calendar date = Calendar.getInstance();
            String email = JOptionPane.showInputDialog(null, "Enter your email: ");
            String nickname = JOptionPane.showInputDialog(null, "Enter your nickname: ");
            String avatar = JOptionPane.showInputDialog(null, "Enter the url of your avatar:" );
            String creditCard = JOptionPane.showInputDialog(null, "Enter your credit card: ");
            JOptionPane.showMessageDialog(null, controler.addUser(name, id, adds, date, email, nickname, avatar, creditCard));

        } else if (type == 1) {
            String name = JOptionPane.showInputDialog("Enter your name: ");
            String id = JOptionPane.showInputDialog("Enter your ID: ");
            Boolean adds = true;
            Calendar date = Calendar.getInstance();
            String email = JOptionPane.showInputDialog(null, "Enter your email: ");
            JOptionPane.showMessageDialog(null, controler.addUser(name, id, adds, date, email));
        } else if (type == 2){
            String name = JOptionPane.showInputDialog("Enter your name: ");
            String id = JOptionPane.showInputDialog("Enter your ID: ");
            Boolean adds = false;
            Calendar date = Calendar.getInstance();
            String email = JOptionPane.showInputDialog(null, "Enter your email: ");
            String nickname = JOptionPane.showInputDialog(null, "Enter your nickname: ");
            String avatar = JOptionPane.showInputDialog(null, "Enter the url of your avatar:" );
            String creditCard = JOptionPane.showInputDialog(null, "Enter your credit card: ");
            String area = JOptionPane.showInputDialog(null, "Enter your interest area: ");
            int CriticsCount = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your count critics"));
            String blog = JOptionPane.showInputDialog(null, "Enter your blog");
            JOptionPane.showMessageDialog(null, controler.addUser(name, id, adds, date, email, nickname, avatar, creditCard, area, CriticsCount, blog));
        }

    }

    public void generatePayment(){
        JOptionPane.showMessageDialog(null, controler.generarCobros());
    }


    public void surprise(int type){
        if (type==0){
            String letter = JOptionPane.showInputDialog(null, "Enter the char to generate random surprise");
            JOptionPane.showMessageDialog(null, controler.surprise(0, letter.charAt(0)));
        } else if (type==1){
            JOptionPane.showMessageDialog(null,controler.surprise());
        }
    }
    
    public void countCritics(){
        JOptionPane.showMessageDialog(null, controler.countCritics());
    }

    
    public void AddBibliographyProduct(){
        String[] botones = {"Book", "Magazine"};
        int ventana = JOptionPane.showOptionDialog(null,
                "Choose your type bibliography that you want register:",
                "ReadX",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                botones, botones[0]);
        if (ventana == 0) {
            String name = JOptionPane.showInputDialog("Enter the book name: ");
            int numberPages = Integer.parseInt(JOptionPane.showInputDialog("Enter pages numbers: " ));
            int gender = Integer.parseInt(JOptionPane.showInputDialog("Enter book gender: "  + " \n " +
                    "1. Sciencie Fiction" + " \n " +
                    "2. Fancy" + " \n " +
                    "3. Historical novel"));

            String review =  JOptionPane.showInputDialog("Enter a short review: ");
            int value = Integer.parseInt(JOptionPane.showInputDialog("Enter the book value: " ));
            String frontPage = JOptionPane.showInputDialog("Enter the URL of front page: ");
            Calendar date = Calendar.getInstance();
            String id = JOptionPane.showInputDialog(null, "Id of the book: ");

            String message = controler.addBooks(name, date, numberPages, review, value, id, gender, frontPage);
            JOptionPane.showMessageDialog(null, message);

        } else if (ventana == 1) {
            String name = JOptionPane.showInputDialog("Enter magazine name: ");
            int numPages = Integer.parseInt(JOptionPane.showInputDialog("Enter the pages of magazines: " ));
            int valueSubscription = Integer.parseInt(JOptionPane.showInputDialog("Enter the magazine price: " ));
            Calendar date = Calendar.getInstance();
            String id = JOptionPane.showInputDialog(null, "Id of the magazine: ");

            int issuancePeriodicity = Integer.parseInt(JOptionPane.showInputDialog("Enter type: " + " \n " +
                    "1. Sciencie " + " \n " +
                    "2. Design " + " \n " +
                    "3. Varieties" + " \n "));
            JOptionPane.showMessageDialog(null, controler.addMagazine( name,  date,  numPages,  valueSubscription, id, issuancePeriodicity));
        }
    }

    public void buyProduct(){
        String[] botones = {"Book", "Magazine"};
        int options = JOptionPane.showOptionDialog(null,
                "Choose your type bibliography that you want register:",
                "ReadX",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                botones, botones[0]);
        
                
        if (options==0){
            String id = JOptionPane.showInputDialog("Enter your ID: ");
            String bookName = JOptionPane.showInputDialog("Name of the book that you want to buy: ");
            JOptionPane.showMessageDialog(null, controler.buyBook(id, bookName));
        } else if (options==1){
            String id = JOptionPane.showInputDialog("Enter your ID: ");
            String MagName = JOptionPane.showInputDialog("Name of the book that you want to buy: ");
            JOptionPane.showMessageDialog(null, controler.buyMagazine(id, MagName));
        }
    }
    public void showBiblio(){
        String id = JOptionPane.showInputDialog(null, "Enter your id");
        JOptionPane.showMessageDialog(null, controler.showBiblioP(id));
    }


    public void simularSesionLectura() {
        boolean salir = false;
        int x = -1;
        int y = -1;
        String id = JOptionPane.showInputDialog(null, "ID");
        
        while (!salir) {
            int opcion = JOptionPane.showOptionDialog(null,
                    "¿What do yo want to do?",
                    "Library",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]{"View library", "Access a product", "Close"},
                    null);
    
            if (opcion == 0) { // Ver Biblioteca
                JOptionPane.showMessageDialog(null, controler.showBiblioP(id));
            } else if (opcion == 1) { // Acceder a Producto
                String inputX = JOptionPane.showInputDialog("Cordinate x:");
                String inputY = JOptionPane.showInputDialog("Cordinate y:");

                try {
                    x = Integer.parseInt(inputX);
                    y = Integer.parseInt(inputY);
    
                    if (x >= 0 && x < 5 && y >= 0 && y < 5 && controler.getBiblio(id)[x][y] != null) {
                        int paginaActual = 1;
                        int totalPaginas = controler.numPages(id, controler.getBiblio(id)[x][y]);
    
                        while (true) {
                            int opcionProducto = JOptionPane.showOptionDialog(null,
                                    "Code: " + controler.getBiblio(id)[x][y] + " Name: " + controler.nameBook(id, controler.getBiblio(id)[x][y])+"\n"
                                            + "Acual Page: " + paginaActual + "\n"
                                            + "¿What do you want to do?",
                                    "Session lecture",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    new String[]{"Read previou page", "Read next page", "Go back library"},
                                    null);
    
                            if (opcionProducto == 0) { // Leer página anterior
                                if (paginaActual > 1) {
                                    paginaActual--;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Already page 1", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else if (opcionProducto == 1) { // Leer página siguiente
                                if (paginaActual < totalPaginas) {
                                    paginaActual++;
                                } else {
                                    JOptionPane.showMessageDialog(null, "No more pages", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else if (opcionProducto == 2) { // Volver a la Biblioteca
                                break;
                            } else {
                                salir = true;
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Valid", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                salir = true;
            }
        }
    }
    
    


}
