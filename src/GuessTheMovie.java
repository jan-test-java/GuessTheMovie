import java.util.Scanner;

public class GuessTheMovie {
    static final String FILE_NAME = "c:\\tmp\\lista_tytulow.txt";
    static final int COUNT_OF_CHANCE = 10;

    public static void main( String [] args) {
        System.out.println("test");
        RunGame();
    }


    private static void RunGame() {


        int errorCount = 0;
        MovieManager mngr = new MovieManager();
        if (!mngr.LoadFile(FILE_NAME)) {
            System.out.println("W pliku " + FILE_NAME + " nie ma wierszy!");
            return;
        }

        mngr.RandomMovie();
        System.out.println("Zgadnij tytuł filmu: ");

        Scanner scanner = new Scanner(System.in);

        while (errorCount < COUNT_OF_CHANCE) {
            System.out.println("" + (COUNT_OF_CHANCE - errorCount) + " : " + mngr.getGuessing() );

            // TODO: nie wiadomo jak odczytać tylko jeden znak!
            String s = scanner.nextLine();
            char ch = s.charAt(0);

            if (! mngr.GuessLetter(ch)) {
                errorCount++;
                System.out.println("Niestety litera " + ch + " nie występuje");
            }
            else if (mngr.Winn()) {
                System.out.println("Tak! Wygrałeś! :)");
                System.out.println("Tytył filmu to: " + mngr.getGuessing());
                return;
            }
        }

        System.out.println("Niestety przegarna! :(");
    }
}

