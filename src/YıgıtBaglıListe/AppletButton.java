package YıgıtBaglıListe;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class YıgıtBagliListe {

    int elamanYıgıt;
    YıgıtBagliListe next;

    public YıgıtBagliListe(int elaman) {
        elamanYıgıt = elaman;
        next = null;
    }
}

class Liste {
    YıgıtBagliListe son = null;
//bosmu dolumu kontrol eder
    boolean YıgıtBosmu() {
        return son == null;
    }
//Diziye elaman ekler
    void push(YıgıtBagliListe d) {

        if (YıgıtBosmu()) {
            son = d;
        } else {
            d.next = son;
            son = d;}    } 
    //Diziden Elaman siler
    YıgıtBagliListe pop() {
        YıgıtBagliListe e = son;
        if (!YıgıtBosmu()) {
            son = e.next; }return e;
    }

}

public class AppletButton extends Applet implements ActionListener {
    Button buttonekle;
    Button buttonCıkar;
    Button buttonGöster;
    int cizX = 30;int cizY = 400; Graphics g;
    TextField giris;
    public void ciz(int s) {
        g = getGraphics();
        if (cizX < 530) {
            g.drawRect(cizX += 90, cizY, 50, 40);

            g.drawRect(cizX + 50, cizY + 20, 40, 0);
        } else {
            g.drawRect(cizX + 480, cizY + 20, 0, 100);
            cizX=30;
            cizY=50;
            g.drawRect(cizX+90 , cizY + 20, 500, 0);   }
        g.drawString(s + "", cizX + 10, cizY + 20); g.drawString("| tob", cizX + 5, cizY - 20);
    }
    int say = 0;
    public void sil() {
        g = getGraphics();  g.setColor(Color.WHITE); g.fillRect(cizX, cizY, 52, 42);        cizX -= 90;
    } 
    
    
    
    Label l1;

    public void init() {
        setLayout(null);
        setSize(800, 600);

        setFont(new Font("Helvetica", Font.BOLD, 14));
        buttonekle = new Button("EKLE()"); buttonCıkar = new Button("ÇIKAR()");
        buttonGöster = new Button("GÖSTER()");
        giris = new TextField();  add(buttonekle); add(buttonCıkar);add(buttonGöster);
        add(giris);    l1 = new Label("Sayı:");     add(l1);   l1.setBounds(210, 300, 30, 30);
        buttonekle.addActionListener(this);      buttonekle.setLocation(50, 50);
        buttonekle.setSize(125, 125);    buttonekle.setBackground(Color.gray);

        buttonGöster.addActionListener(this);    buttonGöster.setLocation(350, 50);
        buttonGöster.setSize(125, 125);    buttonGöster.setBackground(Color.gray);

        buttonCıkar.addActionListener(this);    buttonCıkar.setBounds(200, 50, 125, 125);
        buttonCıkar.setBackground(Color.gray);  giris.setBounds(250, 300, 70, 40);
    }


    public void topciz() {
        g = getGraphics();

        g.drawString("| tob", cizX + 5, cizY - 20);

    }

    public void cıkarrButtonTopsil() {
        g = getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(cizX + 88, cizY - 35, 50, 20);

    }

    public void topsil() {
        g = getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(cizX - 88, cizY - 35, 50, 20);

    }
        Liste l = new Liste();//liste sınıfında birer nesne


    @Override
        public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonekle) {
            String c = giris.getText();
            int a = Integer.parseInt(c);
            l.push(new YıgıtBagliListe(a));
            ciz(l.son.elamanYıgıt);
            giris.setText("");
            say++;
            if (say > 1) {
                topsil();
            }
        } else if (l.YıgıtBosmu()) {
            JOptionPane.showMessageDialog(null, "YIGIT BOS");

        } else if (ae.getSource() == buttonCıkar) {
            giris.setText(l.pop().elamanYıgıt + "");
            sil();

            if (say > 1) { topciz();cıkarrButtonTopsil();} say--;
        } else if (ae.getSource() == buttonGöster) {
            giris.setText(l.son.elamanYıgıt + "");

        }

    }
}
