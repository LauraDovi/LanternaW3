import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class LanternaTest {
    public static void main(String[] args) throws Exception {

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();

        //Task 5
        terminal.setCursorPosition(1, 1); //Cross lines
        terminal.putCharacter('A');

        terminal.setCursorPosition(2, 2);
        terminal.putCharacter('B');

        terminal.setCursorPosition(3, 3);
        terminal.putCharacter('C');

        for (int column = 4; column < 10; column++) { //Horizontal Line   (>leka med olika simboler<
            terminal.setCursorPosition(column, 4); //samma line_______
            terminal.putCharacter('X');
        for (int column1 = 4; column < 10; column++) { //Horizontal Line
                terminal.setCursorPosition(column, 10);
                terminal.putCharacter('X');
            }
        for (int column2 = 4; column < 10; column++) { //Cross Line
                terminal.setCursorPosition(column, column);
                terminal.putCharacter('X');
            }
        for (int row = 0; row < 10; row++) { //Vertical Line
                terminal.setCursorPosition(0, row);
                terminal.putCharacter('Y');
            }


            terminal.setCursorPosition(15, 15);
            String terminal2 = "This is a String printed out in Lanterna by iterating over the characters";
            for (Character c : terminal2.toCharArray()) {
                terminal.putCharacter(c);

            }
          //Task 8

            boolean continueReadingInput = true;
            while (continueReadingInput) {

                KeyStroke keyStroke = terminal.pollInput();

                keyStroke = null;
                do {
                    Thread.sleep(5); // might throw InterruptedException
                    keyStroke = terminal.pollInput();
                } while (keyStroke == null);

                KeyType type = keyStroke.getKeyType(); //like Scanner
                Character c = keyStroke.getCharacter();

//                terminal.setCursorPosition(10, 6);
//                terminal.putCharacter(c);

                System.out.println("keyStroke.getKeyType(): " + type + " key.Stoke.getCharacter(): " + c);

                if (c == Character.valueOf('q')) {
                    continueReadingInput = false;
                    terminal.close();
                    System.out.println("quit");

                }
            }
            System.out.println("Change 3");
            terminal.flush(); //skriver ut på skärm, altid i sluted

        }
        }
    }
