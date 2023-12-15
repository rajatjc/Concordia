import java.util.ArrayList;

public class IntegerToStringKeyboardReaderAdapter extends KeyboardStringReader {
    private final KeyboardIntegerReader integerReader;

    public IntegerToStringKeyboardReaderAdapter(KeyboardIntegerReader integerReader) {
        this.integerReader = integerReader;
    }

    @Override
    public ArrayList<String> read_kbd() {
        ArrayList<Integer> integers = integerReader.read_int_kbd();
        ArrayList<String> adaptedStrings = new ArrayList<>();
        for (Integer integer : integers) {
            adaptedStrings.add(String.valueOf(integer));
        }
        return adaptedStrings;
    }
}