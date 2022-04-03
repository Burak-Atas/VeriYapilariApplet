package yigitDizi;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class YigitDizi extends Applet implements ActionListener {

    Button buttonekle;
    Button buttonCıkar;
    Button buttonGöster;
    TextField t;
    TextField t1;
    TextField t2;
    TextField t3;
    TextField t4;
    TextField t5;
    TextField t6;
    TextField t7;
    TextField t8;
    TextField t9;
    TextField t10;
    
    Label l1;
    public void init() {
        setLayout(null);
        setSize(600, 800);
        setFont(new Font ( "Helvetica" , Font.BOLD, 14));
        buttonekle = new Button("EKLE()");
        buttonCıkar = new Button("ÇIKAR()");
        buttonGöster = new Button("GÖSTER()");
        Label l=new Label("Sayı :");
        add(l);
        l.setBounds(150, 260, 50, 25);
        l.setForeground(Color.black);
       
        t1=new TextField();
      
        t2=new TextField();
        t3=new TextField();
        t4=new TextField();
        t5=new TextField();
        t6=new TextField();
        t7=new TextField();
        t8=new TextField();
        t9=new TextField();
        t10=new TextField();
        add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);
        add(t7);  add(t8);add(t9);add(t10);

        
        add(buttonekle);add(buttonCıkar);add(buttonGöster);

        
        buttonekle.addActionListener(this);
        buttonekle.setLocation(50, 50);
        buttonekle.setSize(125, 125);
        buttonekle.setBackground(Color.gray);

        buttonGöster.addActionListener(this);
        buttonGöster.setLocation(350, 50);
        buttonGöster.setSize(125, 125);
        buttonGöster.setBackground(Color.gray);

        buttonCıkar.addActionListener(this);
        buttonCıkar.setBounds(200, 50, 125, 125);
        buttonCıkar.setBackground(Color.gray);
        
        t=new TextField();
        add(t);
        
        
        t.setBounds(200,250,150,50);
        
        t1.setBounds(200, 400, 75, 30);
        t1.setVisible(true);
        t2.setBounds(200, 430, 75, 30);
        t3.setBounds(200, 460, 75, 30);
        t4.setBounds(200, 490, 75, 30);
        t5.setBounds(200, 520, 75, 30);
        t6.setBounds(200, 550, 75, 30);
        t7.setBounds(200, 580, 75, 30);
        t8.setBounds(200, 610, 75, 30);
        t9.setBounds(200, 640, 75, 30);
        t10.setBounds(200, 670,75,30);
       
    }
    public void kaldır(){
        
        Graphics g=getGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(cizX, cizY+15, 20, 15);
    }
    int cizX=280;
    int cizY=715;
    public void ciz(){
    Graphics g = getGraphics();
    g.drawString("<--", cizX, cizY-=30);
}
    int tıklanma=0;
    dizi d=new dizi(10);//DİZİ SINIFINDAN NESNEMİZ
    @Override
    public void actionPerformed(ActionEvent ae) {
          TextField []textdizi={t10,t9,t8,t7,t6,t5,t4,t3,t2,t1};       
       if (d.Dolumu()){}       
       else if (ae.getSource() == buttonekle) {
           ciz();
           String veri=t.getText();
            int veriİnt=Integer.valueOf(veri);
            d.dizi[d.tab]=veriİnt;
            textdizi[d.tab].setText(veri);
            t.setText("");
            d.tab++;
            tıklanma++;
            if (tıklanma>1)
                kaldır();
        }
       else if(d.isEmty()){ d.tab=0;   }
            else if(ae.getSource()==buttonCıkar){
            String c=textdizi[d.tab].getText();  t.setText(c);
            textdizi[d.tab].setText(""); System.out.println(c);
            d.tab--; }   else  if(ae.getSource()==buttonGöster){
            String c=textdizi[d.tab-1].getText();t.setText(c);
             
        }
    }

    
    public void paint(Graphics g){        
        g.drawRect(20, 15, 490, 200);
        g.setColor(Color.GRAY);
        g.fillRect(150, 375, 214, 349);
       int a=390;
        for (int i = 9; i >=0; i--) {
            a+=30;
            String c=i+"";
            g.setColor(Color.black);
            g.drawString(c, 175, a  );   
        }
    }    
}

class dizi{
        int []dizi;
        int tab;
        int maksize;
    dizi(int maks){
        dizi=new int[maks];
        maksize=maks;
        tab=0;
    } public boolean isEmty(){
        if(tab<=-1){  JOptionPane.showMessageDialog(null, "YIGIT BOS");  return true;
        }   return false;}   public void ekle(int n){  dizi[++tab]=n;
    } public boolean Dolumu(){  if(tab>=maksize){       JOptionPane.showMessageDialog(null, "YIGIT Dolu");
            return true;
        }
            return false;
        
    
    }
    
}
