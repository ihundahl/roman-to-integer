import java.util.HashMap;

public class RomanToInteger {

    public static int calculateRoman(String s) {

        int result = 0;
        
        // Associates roman numerals with numbers they represent
        HashMap<Character,Integer> charToNumber = new HashMap<>();
        charToNumber.put('I', 1);
        charToNumber.put('V', 5);
        charToNumber.put('X', 10);
        charToNumber.put('L', 50);
        charToNumber.put('C', 100);
        charToNumber.put('D', 500);
        charToNumber.put('M', 1000);


        for(int i = 0; i < s.length(); i++) {

            char numeral = s.charAt(i);
            Integer current = charToNumber.get(numeral);

            // Check if previous numeral is smaller than current
            if (i > 0 && current > charToNumber.get(s.charAt(i-1)))
            {
                // Resolves cases where adjacent numerals subtract (ex.IV != 6)
                result += current - (2 * charToNumber.get(s.charAt(i-1)));
            }   else {
                result += current;
            }
        }

        return result;
    }

    public static void main(String args[])
    {
        System.out.println("III = " + calculateRoman("III"));
        System.out.println("LVIII = " + calculateRoman("LVIII"));
        System.out.println("MCMXCIV = " + calculateRoman("MCMXCIV"));
    }
}