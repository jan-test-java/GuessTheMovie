import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.*;

public class MovieManager {
    private String [] listOfMovie;
    private char[] movie; // wylosowany wiersz z pliku tytułów filmów
    private char[] guessMovie; // zgadywane przez użytkownika litery

    public boolean LoadFile(String aFileName) {

        File file = new File(aFileName);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            listOfMovie = new String[0];
            return false;
        }

        int  count = 0;
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s != "")
                count ++;
        }

        listOfMovie = new String[count];

        //scanner.reset();
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            listOfMovie = new String[0];
            return false;
        }

        count = 0;
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s != "") {
                listOfMovie[count] = s;
                count++;
            }
        }
        return true;
    }

    public void RandomMovie() {
        if (listOfMovie == null) {
            movie = new char[0];
            guessMovie = new char[0];
        }
        else {
            int randomInt = (int) (Math.random() * listOfMovie.length);
            movie = listOfMovie[randomInt].toCharArray();
            guessMovie = new char[movie.length];
            Arrays.fill(guessMovie, '_');
        }
    }

    public boolean GuessLetter(char ch) {
        boolean ok = false;
        for(int i = 0; i < movie.length; i++)
            if (movie[i] == ch) {
                guessMovie[i] = ch;
                ok = true;
            }
        return ok;
    }

    public boolean Winn() {
        //boolean ok = guessMovie.equals(movie);
        boolean ok = Arrays.equals(guessMovie, movie);
        return ok;
    }

    public String getGuessing() {
        String s = new String(guessMovie);
        return s;
    }
}
