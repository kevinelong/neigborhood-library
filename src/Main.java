import java.util.Scanner;

public class Main {
    static Book[] books = new Book[20];

    static void available(){
        System.out.println("\nAVAILABLE:");
        for(Book b : books){
            if(b == null || b.isCheckedOut){
                continue;
            }
            System.out.printf("ID: %d - %s, %s\n", b.id, b.title, b.isbn);
        }
        String command = "start";
        Scanner in = new Scanner(System.in);
        while(!command.equalsIgnoreCase("X")){
            System.out.println("""
C - to check out a book.
X - to exit this screen.
                    """);
            command = in.nextLine().trim();
            if(command.equalsIgnoreCase("X")){
                return; //exit function immediately.
            }else if(command.equalsIgnoreCase("C")) {
                System.out.println("Enter book id: ");
                int id = in.nextInt();
                in.nextLine(); // throw away trailing new line
                for (Book b : books) {
                    if (b.id == id) {
                        System.out.println("Enter your name: ");
                        String name = in.nextLine().trim();
                        b.checkOut(name);
                        break;
                    }
                }
            }//end else if
        }//end while
    }
    static void checkedOut(){
        System.out.println("\nCHECKED-OUT:");
        for(Book b : books){
            if(b == null || !b.isCheckedOut){
                continue;
            }
            System.out.printf("%d - %s, %s\n", b.id, b.title, b.checkedOutTo);
        }
        String command = "start";
        Scanner in = new Scanner(System.in);
        while(!command.equalsIgnoreCase("X")){
            System.out.println("""
C - to check in a book.
X - to exit this screen.
                    """);
            command = in.nextLine().trim();
            if(command.equalsIgnoreCase("X")){
                return; //exit function/method immediately
            }else if(command.equalsIgnoreCase("C")) {
                System.out.println("Enter id of book to check in: ");
                int id = in.nextInt();
                if (!command.isEmpty()) {
                    for (Book b : books) {
                        if (b.id == id) {
                            b.checkIn();
                            break;//exit loop
                        }
                    }
                }
            }else{
                System.out.println("No such command at this level: " + command);
            }
        }
    }
    public static void main(String[] args) {
        books[0] = new Book(111,"978-0307292063", "Foundation");
        books[1] = new Book(222,"ASIN-B07D23CFGR", "Atomic Habits");
        books[2] = new Book(333,"978-0679728757", "Blood Meridian");
//        books[1].checkOut("Kevin");
//        available();
//        checkedOut();
        Scanner in = new Scanner(System.in);
        int command = -1;
        while(command != 0) {
            System.out.println("\nMAIN MENU:");
            System.out.print("""
                    1 - Show Available Books
                    2 - Show Checked Out Books
                    0 - Exit - closes out of the application
                    """);
            command = in.nextInt();
            if (command == 0) {
                break; // exit loop right now!!!
            } else if (command == 1) {
                //show available plus menu
                available();
            } else if (command == 2) {
                //show checked out plus menu
                checkedOut();
            } else {
                //no such command
                System.out.println("no such command: " + command);
            }
        }//end outer while loop
        System.out.println("Thanks for using the Library!!!");
    }//end main program
}