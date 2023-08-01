import java.util.*;
public class Polinom {
    public Map<Integer, Integer> polinom = new TreeMap<>(Collections.reverseOrder()) ;
    public void adaugare(int coeficient, int exponent){
        polinom.put(exponent, coeficient);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean firstTerm = true;
        for(Map.Entry<Integer, Integer> entry: this.polinom.entrySet()){
            int exponent = entry.getKey();
            int coeficient = entry.getValue();
            if (firstTerm == true) {
                firstTerm = false;
                if (coeficient < 0) {
                    sb.append("-");
                }
            } else {
                if (coeficient < 0) {
                    sb.append(" - ");
                    coeficient = -coeficient;
                } else {
                    sb.append(" + ");
                }
            }
            if (Math.abs(coeficient) != 1 || exponent == 0) {
                sb.append(Math.abs(coeficient));
            }
            if (exponent > 0) {
                sb.append("x");
                if (exponent != 1) {
                    sb.append("^").append(exponent);
                }
            }
        }
        return sb.toString();
    }
    public static Map<Integer,Integer> polynomialParser(String polynomial) {

            Map<Integer, Integer> coefficients = new HashMap<>();
            String[] terms = polynomial.split("\\s*\\+\\s*"); // split la "+" cu spatiu inainte si dupa

            for (String term : terms) {
                String[] parts = term.split("x\\^?");
                int coefficient = Integer.parseInt(parts[0].trim());
                int exponent ;
                if( parts.length > 1 ){
                    exponent = Integer.parseInt(parts[1].trim());
                }
                else{
                    exponent = 0;
                }
                coefficients.put(exponent, coefficient);
            }

            return coefficients;
    }
}
