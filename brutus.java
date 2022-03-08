import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class brutus {
    // 
    public static final double[] english = {
        0.0855,
        0.0160,
        0.0316,
        0.0387,
        0.1210,
        0.0218,
        0.0209,
        0.0496,
        0.0733,
        0.0022,
        0.0081,
        0.0421,
        0.0253,
        0.0717,
        0.0747,
        0.0207,
        0.0010,
        0.0633,
        0.0673,
        0.0894,
        0.0268,
        0.0106,
        0.0183,
        0.0019,
        0.0172,
        0.0011
    };

    public static final String[] LetterMap = {
        "a",
        "b",
        "c",
        "e",
        "f",
        "g",
        "h",
        "i",
        "j",
        "k",
        "l",
        "m",
        "n",
        "o",
        "p",
        "q",
        "r",
        "s",
        "t",
        "u",
        "v",
        "w",
        "x",
        "y",
        "z",
    };

    public static HashMap < Character, Integer > count(String text) {
        /**
         * Returns a HashMap with characters and thier frequency within the string 
         *
         * @param  String text  The message recived through console args
         * @return      the HasHMap for the chars in the string "text"
         *
         */
        HashMap < Character, Integer > map = new HashMap < Character, Integer > ();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            Integer val = map.get(c);
            if (val != null) {
                map.put(c, (val + 1));
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public static List < Double > frequency(String text) {
        /**
         * Returns a dynamic list array with frequency values normalised 
         * to the English array of double integers.
         * the individual frequency integer is divided by the total amount of characters
         *
         * @param  String text  The message received through console args
         * @return      the frequency values calculated
         *
         **/
        // initialising and defining a HashMap with char and int generics
        // and filling it with the hashmap of the previously processed string
        HashMap < Character, Integer > LetterHashMap = count(text);
        // 
        List < Integer > freqList = new ArrayList < > (LetterHashMap.values());
        List < Double > returningValue = new ArrayList < > ();

        for (Integer i: freqList) {
            int denominator = text.length();
            int numerator = i;
            double freq_res = ((double) numerator / denominator);
            returningValue.add(freq_res);
        }
        return returningValue;
    }

    public static void decrypt(double sum, String text) {
        /**
         * Returns Decrypted string processed in similar manner for encryption 
         *
         * @param  String text  The message recived through console args
         * @param  double sum  sum processed by chi-squared function
         *
         **/

        String decryptedMessage = "";
        int key;
        char CurrentChar;
        String message = text;
        key = (int) sum;
        for (int i = 0; i < message.length(); ++i) {
            CurrentChar = message.charAt(i);
            if (CurrentChar >= 'a' && CurrentChar <= 'z') {
                CurrentChar = (char)(CurrentChar - key);
                if (CurrentChar < 'a') {
                    CurrentChar = (char)(CurrentChar + 'z' - 'a' + 1);
                }
                decryptedMessage += CurrentChar;
            } else if (CurrentChar >= 'A' && CurrentChar <= 'Z') {
                CurrentChar = (char)(CurrentChar - key);
                if (CurrentChar < 'A') {
                    CurrentChar = (char)(CurrentChar + 'Z' - 'A' + 1);
                }
                decryptedMessage += CurrentChar;
            } else {
                decryptedMessage += CurrentChar;
            }
        }
        System.out.println("Decrypted Message = " + decryptedMessage);
    }

    public static double chiSquared(String text) {
        /**
         * Returns a sum of chi-squared values 
         * for the comparison between the given values
         * and pre-processed frequency values
         *
         * @param  String text  The message recived through console args
         *
         **/
        List < Double > freq_ = frequency(text);
        // the values of a dynamic list are converted into an Object generic to 
        // convert into real static array

        Object[] newArr = freq_.toArray();
        double sum = 0;
        // for loop designated with the size of the converted array
        for (int i = 0; i < freq_.size(); i++) {
            // the sum applies the following: (Frequency - English )^2 / English
            // for each of the characters within the array of text

            sum += ((((double) newArr[i]) - english[i]) * (((double) newArr[i]) - english[i])) / english[i];
        }

        System.out.println(sum);
        // the decrypt function is called to finally produce the 
        // decrypted value
        decrypt(sum, text);
        return sum;
    }
    public static void main(String[] args) {

        chiSquared(args[0]);
    }
}