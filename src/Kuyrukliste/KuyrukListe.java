package Kuyrukliste;

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

public class KuyrukListe extends Applet implements ActionListener {

    Button buttonekle;
    Button buttonCıkar;
    Button buttonGöster;

    int cizX = 30;
    int cizY = 400;
    Graphics g;
    TextField giris;

    public void ciz(int s) {
        g = getGraphics();
        if (cizX < 530) {
            g.drawRect(cizX += 90, cizY, 50, 40);
            g.drawRect(cizX + 50, cizY + 20, 40, 0);
            
            g.drawString(s + "", cizX + 10, cizY + 20);

            g.drawString("| rear", cizX + 5, cizY - 20);
        }else if(cizY<440){
            g.drawRect(cizX+90, cizY,0, 50);
            cizX=80;
            cizY=460;
            g.drawRect(cizX, cizY, 600, 0);
            
        }
    }
    int fc=50, fy=400;
    public void frontciz() {
        g.drawString("Front  <->", fc -20, fy+20 );
    }

    int say = 0;
   
    
    int cx=30,cy=400;
    public void sil() {

        g = getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect((cx+= 90), cy, 52, 42);
            frontciz();
    }
    Label l1;

    @Override
    public void init() {
        setLayout(null);
        setSize(800, 600);
        
        setFont(new Font("Helvetica", Font.BOLD, 14));
        buttonekle = new Button("EKLE()"); buttonCıkar = new Button("ÇIKAR()");buttonGöster = new Button("GÖSTER()");
        giris = new TextField();

        add(buttonekle); add(buttonCıkar); add(buttonGöster); add(giris); l1 = new Label("Sayı:");

        add(l1); l1.setBounds(210, 300, 30, 30); buttonekle.addActionListener(this);
        buttonekle.setLocation(50, 50); buttonekle.setSize(125, 125);buttonekle.setBackground(Color.gray);

        buttonGöster.addActionListener(this); buttonGöster.setLocation(350, 50);
        buttonGöster.setSize(125, 125); buttonGöster.setBackground(Color.gray);

        buttonCıkar.addActionListener(this);  buttonCıkar.setBounds(200, 50, 125, 125);
        buttonCıkar.setBackground(Color.gray); giris.setBounds(250, 300, 70, 40);
    }

    public void topciz() {
        g = getGraphics();
        g.drawString("| tob", cizX+5, cizY-20);
    }

    public void topsil() {
        g = getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(cizX, cizY - 30, 50, 20);

    }

    public void ekletopsil() {
        g.setColor(Color.WHITE);
        g.fillRect(cizX - 90, cizY - 30, 50, 20);

    }

    list l = new list();
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonekle) {
            int s = Integer.parseInt(giris.getText());
            l.KuyrugaEkle(new Kuyruk(s));
            ciz(s);
            if (say == 0) {
                frontciz();
            }
            say++;
            giris.setText("");
            if (say > 1) { ekletopsil();}} else if (l.kuyrukBosmu()) {
                JOptionPane.showMessageDialog(null, "KUYRUK BOS SİLME YAPILAMAZ");
        } else if (ae.getSource() == buttonCıkar) {
            giris.setText(l.Kuyruktansil().elaman + "");
            
            sil();
            say--;
        } else if (ae.getSource() == buttonGöster) {
            giris.setText(l.goster() + "");
        }
    }

}

class Kuyruk {
    int elaman;
    Kuyruk next;
    public Kuyruk(int a) {
        elaman = a;
        next = null;
    }
}

class list {
    Kuyruk bas, son = null;
    boolean kuyrukBosmu() {
        return bas == null;
    }
    void KuyrugaEkle(Kuyruk d) {
        if (kuyrukBosmu()) {
            bas = d;
            son = d;
        } else {  son.next = d;  son = d;    }  }
    Kuyruk Kuyruktansil() {
        Kuyruk temp = bas;

        if (!kuyrukBosmu()) {
            bas = bas.next;
            if (bas == null) {
                son = null;
            }  } return temp;
    }
    int goster() {
        return son.elaman;
    }
    void listele(){
        Kuyruk tmp=bas;
        while(son.next!=null){
            System.out.println(tmp.elaman);
            tmp=bas.next;
        }
    }

}
