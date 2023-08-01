import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestOperatii {
    @Test
    public void adunareTest(){

        Polinom p1 = new Polinom() ;
        Polinom p2 = new Polinom() ;
        Polinom p3 = new Polinom() ;

        p1.adaugare(1,3);
        p1.adaugare(-2,2);
        p1.adaugare(6,1);
        p1.adaugare(-5,0);

        p2.adaugare(1,2);
        p2.adaugare(-1,0);

        Operatii operatii = new Operatii(p1,p2);

        p3 = operatii.adunare() ;
        String p3String = p3.toString() ;

        assertEquals(p3String, "x^3 - x^2 + 6x - 6");
    }
    @Test
    public void scadereTest(){

        Polinom p1 = new Polinom() ;
        Polinom p2 = new Polinom() ;
        Polinom p3 = new Polinom() ;

        p1.adaugare(1,3);
        p1.adaugare(-2,2);
        p1.adaugare(6,1);
        p1.adaugare(-5,0);

        p2.adaugare(1,2);
        p2.adaugare(-1,0);

        Operatii operatii = new Operatii(p1,p2);
        p3 = operatii.scadere() ;
        String p3String = p3.toString() ;

        assertEquals(p3String, "x^3 - 3x^2 + 6x - 4");
    }
    @Test
    public void inmultireTest(){

        Polinom p1 = new Polinom() ;
        Polinom p2 = new Polinom() ;
        Polinom p3 = new Polinom() ;

        p1.adaugare(1,3);
        p1.adaugare(-2,2);
        p1.adaugare(6,1);
        p1.adaugare(-5,0);

        p2.adaugare(1,2);
        p2.adaugare(-1,0);

        Operatii operatii = new Operatii(p1,p2);
        p3 = operatii.inmultire() ;
        String p3String = p3.toString() ;

        assertEquals(p3String, "x^5 - 2x^4 + 5x^3 - 3x^2 - 6x + 5");
    }
    @Test
    public void impartireTest(){

        Polinom p1 = new Polinom() ;
        Polinom p2 = new Polinom() ;
        Polinom p3 = new Polinom() ;

        p1.adaugare(1,3);
        p1.adaugare(-2,2);
        p1.adaugare(6,1);
        p1.adaugare(-5,0);

        p2.adaugare(1,2);
        p2.adaugare(-1,0);

        Operatii operatii = new Operatii(p1,p2);
        p3 = operatii.impartire() ;
        String p3String = p3.toString() ;

        assertEquals(p3String, "x - 2");
    }
    @Test
    public void derivareP1Test(){

        Polinom p1 = new Polinom() ;
        Polinom p2 = new Polinom() ;

        p1.adaugare(1,3);
        p1.adaugare(-2,2);
        p1.adaugare(6,1);
        p1.adaugare(-5,0);

        p2.adaugare(1,2);
        p2.adaugare(-1,0);

        assertEquals(Operatii.derivare(p1), "3x^2 - 4x + 6 + 0");
    }
    @Test
    public void derivareP2Test(){

        Polinom p1 = new Polinom() ;
        Polinom p2 = new Polinom() ;

        p1.adaugare(1,3);
        p1.adaugare(-2,2);
        p1.adaugare(6,1);
        p1.adaugare(-5,0);

        p2.adaugare(1,2);
        p2.adaugare(-1,0);

        assertEquals(Operatii.derivare(p2), "2x + 0");
    }
    @Test
    public void integrareP1Test(){

        Polinom p1 = new Polinom() ;
        Polinom p2 = new Polinom() ;

        p1.adaugare(1,3);
        p1.adaugare(-2,2);
        p1.adaugare(6,1);
        p1.adaugare(-5,0);

        p2.adaugare(1,2);
        p2.adaugare(-1,0);
        assertEquals(Operatii.integrare(p1), "1/4*x^4 + -2/3*x^3 + 6/2*x^2 + -5/1*x^1");
    }
    @Test
    public void integrareP2Test(){

        Polinom p1 = new Polinom() ;
        Polinom p2 = new Polinom() ;

        p1.adaugare(1,3);
        p1.adaugare(-2,2);
        p1.adaugare(6,1);
        p1.adaugare(-5,0);

        p2.adaugare(1,2);
        p2.adaugare(-1,0);

        assertEquals(Operatii.integrare(p2), "1/3*x^3 + -1/1*x^1");
    }
}
