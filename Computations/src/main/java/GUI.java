import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
public class GUI extends JFrame {
    private Color primaryColor = new Color(48, 63, 159); // Indigo
    private Color secondaryColor = new Color(255, 87, 34); // Deep Orange
    private Color textColor = Color.BLACK;
    private JPanel mainPanel;
    private JLabel P1Label;
    private JTextField txtP1;
    private JTextField txtP2;
    private JLabel P2Label;
    private JLabel adunareLabel;
    private JLabel scadereLabel;
    private JLabel inmultireLabel;
    private JLabel impartireLabel;
    private JLabel derivareLabel;
    private JLabel integrareLabel;
    private JButton okAdunare;
    private JButton okScadere;
    private JButton okInmultire;
    private JButton okImpartire;
    private JButton okDerivare;
    private JButton okIntegrare;
    private JLabel rezultatCalcul;
    private JTextField rezultatField;
    private JLabel rezultat1;
    private JLabel rezultat2;
    private JTextField rez1;
    private JTextField rez2;
    private JTextField restTextField;
    private JLabel restImp;
    public GUI() {
        okAdunare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1 = txtP1.getText();
                String p2 = txtP2.getText();

                Map<Integer, Integer> poli1 = Polinom.polynomialParser(p1);
                Map<Integer, Integer> poli2 = Polinom.polynomialParser(p2);

                Polinom polinom1 = new Polinom();
                Polinom polinom2 = new Polinom();

                for(Map.Entry<Integer,Integer> afisare : poli1.entrySet()){
                    int coeficient = afisare.getValue();
                    int exponent = afisare.getKey();
                    polinom1.adaugare(coeficient, exponent);
                }

                for(Map.Entry<Integer,Integer> afisare : poli2.entrySet()){
                    int coeficient = afisare.getValue();
                    int exponent = afisare.getKey();
                    polinom2.adaugare(coeficient, exponent);
                }

                Operatii polioname = new Operatii(polinom1,polinom2);
                Polinom rezultat = polioname.adunare();

                rezultatField.setText(rezultat.toString());
            }
        });
        okScadere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1 = txtP1.getText();
                String p2 = txtP2.getText();

                Map<Integer, Integer> poli1 = Polinom.polynomialParser(p1);
                Map<Integer, Integer> poli2 = Polinom.polynomialParser(p2);

                Polinom polinom1 = new Polinom();
                Polinom polinom2 = new Polinom();

                for(Map.Entry<Integer,Integer> afisare : poli1.entrySet()){
                    int coeficient = afisare.getValue();
                    int exponent = afisare.getKey();
                    polinom1.adaugare(coeficient, exponent);
                }

                for(Map.Entry<Integer,Integer> afisare : poli2.entrySet()){
                    int coeficient = afisare.getValue();
                    int exponent = afisare.getKey();
                    polinom2.adaugare(coeficient, exponent);
                }

                Operatii polioname = new Operatii(polinom1,polinom2);
                Polinom rezultat = polioname.scadere();

                rezultatField.setText(rezultat.toString());
            }
        });
        okInmultire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1 = txtP1.getText();
                String p2 = txtP2.getText();

                Map<Integer, Integer> poli1 = Polinom.polynomialParser(p1);
                Map<Integer, Integer> poli2 = Polinom.polynomialParser(p2);

                Polinom polinom1 = new Polinom();
                Polinom polinom2 = new Polinom();

                for(Map.Entry<Integer,Integer> afisare : poli1.entrySet()){
                    int coeficient = afisare.getValue();
                    int exponent = afisare.getKey();
                    polinom1.adaugare(coeficient, exponent);
                }

                for(Map.Entry<Integer,Integer> afisare : poli2.entrySet()){
                    int coeficient = afisare.getValue();
                    int exponent = afisare.getKey();
                    polinom2.adaugare(coeficient, exponent);
                }

                Operatii polioname = new Operatii(polinom1,polinom2);
                Polinom rezultat = polioname.inmultire();

                rezultatField.setText(rezultat.toString());
            }
        });
        okImpartire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1 = txtP1.getText();
                String p2 = txtP2.getText();

                Map<Integer, Integer> poli1 = Polinom.polynomialParser(p1);
                Map<Integer, Integer> poli2 = Polinom.polynomialParser(p2);

                Polinom polinom1 = new Polinom();
                Polinom polinom2 = new Polinom();

                for(Map.Entry<Integer,Integer> afisare : poli1.entrySet()){
                    int coeficient = afisare.getValue();
                    int exponent = afisare.getKey();
                    polinom1.adaugare(coeficient, exponent);
                }

                for(Map.Entry<Integer,Integer> afisare : poli2.entrySet()){
                    int coeficient = afisare.getValue();
                    int exponent = afisare.getKey();
                    polinom2.adaugare(coeficient, exponent);
                }

                Operatii polioname = new Operatii(polinom1,polinom2);
                Polinom rezultat = polioname.impartire();

                Polinom restRezultat = polioname.restImpartire() ;

                restTextField.setText(restRezultat.toString());
                rezultatField.setText(rezultat.toString());
            }
        });
        okDerivare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1 = txtP1.getText();
                String p2 = txtP2.getText();

                Map<Integer, Integer> poli1 = Polinom.polynomialParser(p1);
                Map<Integer, Integer> poli2 = Polinom.polynomialParser(p2);

                Polinom polinom1 = new Polinom();
                Polinom polinom2 = new Polinom();

                for(Map.Entry<Integer,Integer> afisare : poli1.entrySet()){
                    int coeficient = afisare.getValue();
                    int exponent = afisare.getKey();
                    polinom1.adaugare(coeficient, exponent);
                }

                for(Map.Entry<Integer,Integer> afisare : poli2.entrySet()){
                    int coeficient = afisare.getValue();
                    int exponent = afisare.getKey();
                    polinom2.adaugare(coeficient, exponent);
                }

                String rezultat = Operatii.derivare(polinom1);
                String rezultat2 = Operatii.derivare(polinom2);
                rez1.setText(rezultat);
                rez2.setText(rezultat2);
            }
        });
        okIntegrare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1 = txtP1.getText();
                String p2 = txtP2.getText();

                Map<Integer, Integer> poli1 = Polinom.polynomialParser(p1);
                Map<Integer, Integer> poli2 = Polinom.polynomialParser(p2);

                Polinom polinom1 = new Polinom();
                Polinom polinom2 = new Polinom();

                for(Map.Entry<Integer,Integer> afisare : poli1.entrySet()){
                    int coeficient = afisare.getValue();
                    int exponent = afisare.getKey();
                    polinom1.adaugare(coeficient, exponent);
                }

                for(Map.Entry<Integer,Integer> afisare : poli2.entrySet()){
                    int coeficient = afisare.getValue();
                    int exponent = afisare.getKey();
                    polinom2.adaugare(coeficient, exponent);
                }

                String rezultat = Operatii.integrare(polinom1);
                String rezultat2 = Operatii.integrare(polinom2);
                rez1.setText(rezultat);
                rez2.setText(rezultat2);
            }
        });

        mainPanel.setBackground(primaryColor);
        P1Label.setForeground(textColor);
        P2Label.setForeground(textColor);

        customButon(okAdunare, "Adunare");
        customButon(okScadere, "Scadere");
        customButon(okInmultire, "Inmultire");
        customButon(okImpartire, "Impartire");
        customButon(okDerivare, "Derivare");
        customButon(okIntegrare, "Integrare");

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        P1Label.setFont(labelFont);
        P2Label.setFont(labelFont);
        rezultatCalcul.setFont(labelFont);
        adunareLabel.setFont(labelFont);
        scadereLabel.setFont(labelFont);
        inmultireLabel.setFont(labelFont);
        impartireLabel.setFont(labelFont);
        derivareLabel.setFont(labelFont);
        integrareLabel.setFont(labelFont);
        rezultat1.setFont(labelFont);
        rezultat2.setFont(labelFont);
        restImp.setFont(labelFont);

        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        txtP1.setFont(textFieldFont);
        txtP2.setFont(textFieldFont);
        rezultatField.setFont(textFieldFont);
        rez1.setFont(textFieldFont);
        rez2.setFont(textFieldFont);
        restTextField.setFont(textFieldFont);
    }
    private void customButon(JButton button, String text) {
        button.setText(text);
        button.setBackground(secondaryColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setContentPane(gui.mainPanel);
        gui.setTitle("Calculator Polinoame");
        gui.setSize(500, 400); // Adjusted size to fit the components better
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
