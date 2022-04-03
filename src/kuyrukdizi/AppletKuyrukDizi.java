package kuyrukdizi;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Kuyrukeleman {

    int icerik;

    public Kuyrukeleman(int icerik) {

        this.icerik = icerik;
    }
}

class kuyruk {

    int bas, son;
    Kuyrukeleman[] dizi;
    int elamanSay;
    int maks;

    kuyruk(int maks) {
        bas = 0;
        son = 0;
        this.maks = maks;
        dizi = new Kuyrukeleman[this.maks];
        elamanSay = 0;
    }

    boolean dolumu() {
        return elamanSay == maks;
    }

    boolean bosmu() {
        return elamanSay == 0;
    }

    void kuyrugaEkle(Kuyrukeleman e) {
        if (bosmu() && elamanSay==0) {
            dizi[bas] = e;
            dizi[son++] = e;

        }

        if (!dolumu() && elamanSay - 1 <= maks) {
            dizi[son] = e;
        } else if (!dolumu()) {
            dizi[son] = e;
        }
    }

    Kuyrukeleman Göster() {
        return dizi[son];
    }

    Kuyrukeleman KuyruktanSil() {
        Kuyrukeleman temp = dizi[++bas];
        elamanSay--;
        return temp;
    }
    
}

public class AppletKuyrukDizi extends Applet implements ActionListener {

    Button ekle = new Button("Ekle()");
    Button cıkar = new Button("Cıkar()");
    Button Goster = new Button("Goster()");

    TextField t1 = new TextField();
    TextField t2 = new TextField();
    TextField t3 = new TextField();
    TextField t4 = new TextField();
    TextField t5 = new TextField();
    TextField t6 = new TextField();
    TextField t7 = new TextField();
    TextField t8 = new TextField();
    TextField t9 = new TextField();
    TextField textDizi[] = {t1, t2, t3, t4, t5, t6, t7, t8, t9};
    Label l = new Label("Sayi");

    TextField giris = new TextField();

    public void init() {

        setSize(800, 800);
        setLayout(null);
        add(ekle);
        add(giris);
        add(t1);
        add(Goster);
        add(cıkar);

        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(t7);
        add(t8);
        add(t9);

        ekle.addActionListener(this);
        ekle.setBackground(Color.gray);
        ekle.setBounds(150, 50, 140, 80);

        cıkar.addActionListener(this);
        cıkar.setBackground(Color.gray);
        cıkar.setBounds(300, 50, 140, 80);

        Goster.addActionListener(this);
        Goster.setBackground(Color.gray);
        Goster.setBounds(450, 50, 140, 80);

        giris.setBounds(250, 200, 100, 50);

        t1.setBounds(250, 300, 70, 30);
        t2.setBounds(250, 335, 70, 30);
        t3.setBounds(250, 370, 70, 30);
        t4.setBounds(250, 405, 70, 30);
        t5.setBounds(250, 440, 70, 30);
        t6.setBounds(250, 475, 70, 30);
        t7.setBounds(250, 510, 70, 30);
        t8.setBounds(250, 545, 70, 30);
        t9.setBounds(250, 580, 70, 30);

        setFont(new Font("Helvetica", Font.BOLD, 14));

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(150, 280, 214, 380);
        int a = 320;
        for (int i = 1; i< 9; i++) {
            a += 35;
            String c = i + "";
            g.setColor(Color.black);
            g.drawString(c + "-", 200, a);
        }
    }

    kuyruk k = new kuyruk(textDizi.length);
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if (ae.getSource() == ekle) {
            
            k.kuyrugaEkle(new Kuyrukeleman(Integer.parseInt(giris.getText())));
            textDizi[k.son].setText(k.Göster().icerik + "");
            giris.setText("");  
          
        }
        else if (ae.getSource() == cıkar) {
            giris.setText(k.KuyruktanSil().icerik + "");
            textDizi[k.bas].setText("");
        }else if(ae.getSource()==Goster){
           giris.setText(k.Göster().icerik+"");
        }
    }

}
