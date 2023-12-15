import java.util.ArrayList;

public class ReaderAndWriter {
    KeyboardStringReader kbd_rdr;

    public ArrayList<String> readStrings() {
        return kbd_rdr.read_kbd();
    }

    public void writeStrings(ArrayList<String> strings) {
        for (String string : strings) {
            System.out.print(string);
        }
    }

    public void chooseReader() {
        int choice = 0;
        System.out.println("Which reader do you choose?");
        System.out.println("1. String");
        System.out.println("2. Integer");
        choice = ReaderDriver.kbd.nextInt();
        switch (choice) {
            case 1:
                kbd_rdr = new KeyboardStringReader();
                break;
            case 2:
                //////////////////////////////////////////
                // ADD CODE HERE TO CONNECT THE ADAPTER //
                //////////////////////////////////////////
                kbd_rdr = new IntegerToStringKeyboardReaderAdapter(new KeyboardIntegerReader());
                break;
            default:
                kbd_rdr = new KeyboardStringReader();
                break;
        }
    }
}