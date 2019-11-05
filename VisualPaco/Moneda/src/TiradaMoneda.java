import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TiradaMoneda {
    private JButton btonTirar;
    private JPanel panelMain;
    private JTextField txtTiradas;
    private JLabel tiradasLabel;
    private JTextField txtCaras;
    private JLabel carasLabel;
    private JLabel cruzLabel;
    private JTextField txtCruz;
    private JTextField txtPorcentajeCara;
    private JTextField txtPorcentajeCruz;
    private JTextField txtRepetir;
    private JButton btonRepetir;
    private JButton btonLimpiarField;
    private JLabel imgLabel;
    private JTextField txtnumTiradas;
    private JTextField txtnumRepetir;
    private int hContador = 0;
    private int tContador = 0;
    private int sContador=hContador+tContador;
    private double porcentajeCara=0.0;
    private double porcentajeCruz=0.0;
    ImageIcon caraImg = new ImageIcon("img/cara.png");
    ImageIcon cruzImg = new ImageIcon("img/cruz.png");
    Image cara = caraImg.getImage();
    Image cruz = cruzImg.getImage();

    public TiradaMoneda() {
        btonTirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CaraoCruz();
            }
        });
        btonLimpiarField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCruz.setText("");
                txtCaras.setText("");
                txtTiradas.setText("");
                txtPorcentajeCruz.setText("");
                txtPorcentajeCara.setText("");
            }
        });
        btonRepetir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hContador = 0;
                tContador = 0;
                sContador = 0;
                double tiradas = Double.parseDouble(txtnumTiradas.getText());

                for (int i = 0; i < tiradas; i++) {
                   tiradaAleatoria();
                   CaraoCruz();
                }
               Porcentajes();
                txtCaras.setText(String.valueOf(hContador));
                txtCruz.setText(String.valueOf(tContador));
                txtTiradas.setText(String.valueOf(sContador));

            }
        });
    }

    public int tiradaAleatoria(){
        int tirada = (int)(Math.random()*2+1);
        return tirada;
    }
    public void CaraoCruz() {
        int random = tiradaAleatoria();

            if (random == 1) {
                imgLabel.setIcon(new ImageIcon(cara));
                hContador++;
                sContador++;
                Porcentajes();
            }

        else {
            imgLabel.setIcon(new ImageIcon(cruz));
            tContador++;
            sContador++;}

        txtCaras.setText(String.valueOf(hContador));
        txtCruz.setText(String.valueOf(tContador));
        txtTiradas.setText(String.valueOf(sContador));
        Porcentajes();



    }
    private void Porcentajes () {
        DecimalFormat decimal = new DecimalFormat("#.00");
        porcentajeCara = ((double) hContador / (double) sContador) * 100;
        txtPorcentajeCara.setText(String.valueOf(decimal.format(porcentajeCara)));


        porcentajeCruz = ((double) tContador / (double) sContador) * 100;
        txtPorcentajeCruz.setText(String.valueOf(decimal.format(porcentajeCruz)));
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("TiradaMoneda");
        frame.setContentPane(new TiradaMoneda().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
