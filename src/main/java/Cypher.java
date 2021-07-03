
public class Cypher {
    //assumption that cypher is in scope of numbers 0-9 example 1111
    public int calculatePossibilities(String cypher) {
        int result = 0;

        for (int i = 0; i < cypher.length() ; i++) {
            if ((cypher.charAt(i) == '1')) {
                result++;
               //if there is another number in cypher after index it doesn't need to be checked
                if ((i + 1) < cypher.length()) {
                    result++;
                }
            } else if (cypher.charAt(i) == '2') {
                result++;
                if ((i + 1) < cypher.length()) {
                    if (cypher.charAt(i + 1) >= '0' && cypher.charAt(i+1) <='6') {
                        result++;
                    }
                }
            } else if (cypher.charAt(i) >= '3' && cypher.charAt(i) <= '9') {
                result++;
            }
        }
        return result;
    }
}
