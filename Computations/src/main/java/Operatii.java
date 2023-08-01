import java.util.*;
public class Operatii {
    private Polinom p1;
    private Polinom p2;
    public Operatii(Polinom p1, Polinom p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    public Polinom adunare() {
        Polinom result = new Polinom();

        for(Map.Entry<Integer, Integer> entry : this.p1.polinom.entrySet()) {
            result.adaugare(entry.getValue(), entry.getKey());
        }
        for(Map.Entry<Integer, Integer> entry : this.p2.polinom.entrySet()) {
            int coeficient = entry.getValue();
            int exponent = entry.getKey();
            if(result.polinom.containsKey(exponent)) {
                coeficient += result.polinom.get(exponent);
            }
            result.adaugare(coeficient, exponent);
        }
        return result;
    }
    public Polinom scadere() {
        Polinom result = new Polinom();
        for(Map.Entry<Integer, Integer> entry : this.p1.polinom.entrySet()) {
            result.adaugare(entry.getValue(), entry.getKey());
        }
        for(Map.Entry<Integer, Integer> entry : this.p2.polinom.entrySet()) {
            int coeficient = -entry.getValue();
            int exponent = entry.getKey();
            if(result.polinom.containsKey(exponent)) {
                coeficient += result.polinom.get(exponent);
            }
            result.adaugare(coeficient, exponent);
        }
        return result;
    }
    public Polinom inmultire(){
        Polinom result = new Polinom();
        for(Map.Entry<Integer, Integer> entry : this.p1.polinom.entrySet()) {
            int coeficient1 = entry.getValue();
            int exponent1 = entry.getKey();
            for(Map.Entry<Integer, Integer> entry2 : this.p2.polinom.entrySet()) {
                int coeficient2 = entry2.getValue();
                int exponent2 = entry2.getKey();
                int coeficient = coeficient1 * coeficient2;
                int exponent = exponent1 + exponent2;
                if(result.polinom.containsKey(exponent)) {
                    coeficient += result.polinom.get(exponent);
                }
                result.adaugare(coeficient, exponent);
            }
        }
        return result;
    }
    public Polinom impartire(){

        Polinom q = new Polinom();
        Polinom r = new Polinom();
        Polinom t = new Polinom();

        for(Map.Entry<Integer, Integer> entry : this.p1.polinom.entrySet()) {
            r.adaugare(entry.getValue(), entry.getKey());
        }

        int gradP2 = this.p2.polinom.keySet().iterator().next();
        int gradR = r.polinom.keySet().iterator().next();

        while(!r.polinom.isEmpty() && gradR >= gradP2) {
            int coeficient1 = this.p2.polinom.values().iterator().next();
            int coeficient2 = r.polinom.values().iterator().next();
            int exponent1 = this.p2.polinom.keySet().iterator().next();
            int exponent2 = r.polinom.keySet().iterator().next();
            int coeficient = coeficient2 / coeficient1;
            int exponent = exponent2 - exponent1;

            q.adaugare(coeficient, exponent);
            Polinom produs = new Polinom();
            for (Map.Entry<Integer, Integer> entry : this.p2.polinom.entrySet()) {
                int coefP2 = entry.getValue();
                int expP2 = entry.getKey();
                int coefPrim = coeficient * coefP2;
                int expPrim = exponent + expP2;
                produs.adaugare(coefPrim, expPrim);
            }

            Operatii operatii = new Operatii(r, produs);
            r = operatii.scadere();

            r.polinom.entrySet().removeIf(entry -> entry.getValue() == 0);

            int gradP2Prim = this.p2.polinom.keySet().iterator().next();
            int gradRPrim = r.polinom.keySet().iterator().next();
            gradP2 = gradP2Prim;
            gradR = gradRPrim ;
        }
        return q ;
    }
    public Polinom restImpartire(){

        Polinom q = new Polinom();
        Polinom r = new Polinom();
        Polinom t = new Polinom();

        for(Map.Entry<Integer, Integer> entry : this.p1.polinom.entrySet()) {
            r.adaugare(entry.getValue(), entry.getKey());
        }

        int gradP2 = this.p2.polinom.keySet().iterator().next();
        int gradR = r.polinom.keySet().iterator().next();

        while(!r.polinom.isEmpty() && gradR >= gradP2) {
            int coeficient1 = this.p2.polinom.values().iterator().next();
            int coeficient2 = r.polinom.values().iterator().next();
            int exponent1 = this.p2.polinom.keySet().iterator().next();
            int exponent2 = r.polinom.keySet().iterator().next();
            int coeficient = coeficient2 / coeficient1;
            int exponent = exponent2 - exponent1;

            q.adaugare(coeficient, exponent);
            Polinom produs = new Polinom();
            for (Map.Entry<Integer, Integer> entry : this.p2.polinom.entrySet()) {
                int coefP2 = entry.getValue();
                int expP2 = entry.getKey();
                int coefPrim = coeficient * coefP2;
                int expPrim = exponent + expP2;
                produs.adaugare(coefPrim, expPrim);
            }

            Operatii operatii = new Operatii(r, produs);
            r = operatii.scadere();

            r.polinom.entrySet().removeIf(entry -> entry.getValue() == 0);

            int gradP2Prim = this.p2.polinom.keySet().iterator().next();
            int gradRPrim = r.polinom.keySet().iterator().next();
            gradP2 = gradP2Prim;
            gradR = gradRPrim ;
        }
        return r ;
    }
    public static String derivare(Polinom p1){

        Polinom p2 = new Polinom() ;

        for(Map.Entry<Integer,Integer> derivare : p1.polinom.entrySet()){
            int coeficient = derivare.getValue() ;
            int exponent = derivare.getKey() ;
            int aux = coeficient * exponent ;
            int aux2 = exponent - 1 ;
            p2.adaugare(aux, aux2) ;
        }

        return p2.toString();
    }
    public static String integrare(Polinom p1){

        StringBuilder poli2 = new StringBuilder();

        for(Map.Entry<Integer,Integer> integrare : p1.polinom.entrySet()){
            int coeficient = integrare.getValue() ;
            int exponent = integrare.getKey() ;
            int aux = exponent + 1 ;

            poli2.append(coeficient).append("/").append(aux).append("*x^").append(aux).append(" + ") ;
        }

        poli2.setLength(poli2.length() - 3);

        return poli2.toString() ;
    }
}
