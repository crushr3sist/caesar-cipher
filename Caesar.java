import java.util.*;

public class Caesar {

    public static String rotate(int shift, String inputText) {
        /**
         * Returns a String that is the processed and encrypted with the
         * shift integer 
         *
         * @param  String text  The message recived through console args
         * @param  int shift    The integer provided to apply a shift for encryption
         *
         */
        String cipheredText = "";
        char alpha;
        for (int i = 0; i < inputText.length(); i++) {
            // Shift one character at a time
            alpha = inputText.charAt(i);
            // if alpha lies between a and z 
            if (alpha >= 'a' && alpha <= 'z') {
                // shift alpha
                alpha = (char)(alpha + shift);
                // if shift alpha greater than 'z'
                if (alpha > 'z') {
                    // reshift to starting position 
                    alpha = (char)(alpha + 'a' - 'z' - 1);
                }
                // assign final value
                cipheredText = cipheredText + alpha;
            }
            // if alpha lies between 'A'and 'Z'
            else if (alpha >= 'A' && alpha <= 'Z') {
                // shift alpha
                alpha = (char)(alpha + shift);
                // if shift alpha greater than 'Z'
                if (alpha > 'Z') {
                    //reshift to starting position 
                    alpha = (char)(alpha + 'A' - 'Z' - 1);
                }
                cipheredText = cipheredText + alpha;
            } else {
                cipheredText = cipheredText + alpha;
            }
        }
        return cipheredText;
    }
    public static void main(String[] args) {
        // initalsing a placeholder for the shift integer

        int firstArg;
        // using exception catching for incorrect params given through console
        try {
            firstArg = Integer.parseInt(args[0]);
            // applying a number format exception
        } catch (NumberFormatException e) {
            System.err.println("Argument :" + args[0] + " must be an integer.");
            System.exit(1);
        }
        // if there are more than 2 args given, return a error message accordingly
        if (args.length > 2) {
            System.err.println("too many parameters!");
            System.exit(1);
        }
        // if there arent 2 args given, return a error message accordingly
        if (args.length < 1) {
            System.err.println("too few parameters!");
            System.exit(1);
        }
        // otherwise, continue to produce the encrypted message
        else {
            System.out.println(rotate(Integer.parseInt(args[0]), args[1]));
        }
    }
}