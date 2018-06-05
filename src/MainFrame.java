import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame{
    private JLabel jl1 =new JLabel();
    private JLabel jl2 =new JLabel();
    private Container cp;
    private ImageIcon img1 =new ImageIcon("ship.png");
    private ImageIcon img2 =new ImageIcon("bomb.png");
    private ImageIcon img3 =new ImageIcon("ship2.png");
    private Timer t1 ;
    public MainFrame(){
        init();
    }
    public void init(){
        this.setBounds(100,100,600,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        cp =this.getContentPane();
        cp.setLayout(null);
        jl1.setBounds(200,400,100,100);
        jl1.setIcon(img1);
        cp.add(jl1);
        t1 = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl2.setLocation(jl2.getX(),jl2.getY()-10);
                if (jl2.getY()<0){
                    t1.stop();
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case 37:
                        jl1.setIcon(img1);
                        jl1.setLocation(jl1.getX()-10,jl1.getY());
                        break;
                    case 38:
                        jl1.setLocation(jl1.getX(),jl1.getY()-10);
                        break;
                    case 39:
                        jl1.setLocation(jl1.getX()+10,jl1.getY());
                        jl1.setIcon(img3);
                        break;
                    case 40:
                        jl1.setLocation(jl1.getX(),jl1.getY()+10);
                        break;
                    case 32:
                        cp.add(jl2);
                        jl2.setIcon(img2);
                        jl2.setBounds(jl1.getX()+20,jl1.getY(),50,150);
                        t1.start();
                }
            }
        });
    }
}
