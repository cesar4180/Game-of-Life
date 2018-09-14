package SemestreTres;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.Timer;
public class GameLifeGraphic extends JFrame implements ActionListener
{
    public int tf=50, tc=50, contador=0;
    public int mat[][] = new int [tf][tc];
    public int Nmat[][]= new int [tf][tc];
    private JButton boton = new JButton();
    private JPanel panel = new JPanel();
    public static void main (String [] args)
    {
        GameLifeGraphic window = new GameLifeGraphic();
        window.setVisible(true);
        window.setSize(1000,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public GameLifeGraphic()
    {
        Container contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());
        
        panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setPreferredSize(new Dimension(800,800));
        
        contenedor.add(panel);
        
        boton= new JButton("Next");
        contenedor.add(boton);
        boton.addActionListener(this);
        boton.setPreferredSize(new Dimension(100,70));
        
        for(int cv=1; cv<=(int)(tf*tc)*.2;cv++)
       {
           int f,c;
           do
           {
               f=(int)(Math.random()*tf);
               c=(int)(Math.random()*tc);
           }while(mat[f][c]==1);
           mat[f][c]=1;
       }
    }
    public void actionPerformed(ActionEvent event)
    {
      Graphics papel = panel.getGraphics();
      papel.setColor(Color.black);
      papel.fillRect(0,0,800,800);
      papel.setColor(Color.red);
      pintar(papel,mat);
      for (int f=0; f<tf;f++)
      {
          for (int c=0; c<tc; c++)
          {
              int contador=0;
              if (f-1>=0&&c+1<tc&&mat[f-1][c+1]==1)
              {
                 contador++;
              }
              if (f-1>=0&&mat[f-1][c]==1)
              {
                  contador++;
              }
              if (f-1>=0&&c-1>=0&&mat[f-1][c-1]==1)
              {
                  contador++;
              }
              if (c-1>=0&&mat[f][c-1]==1)
              {
                  contador++;
              }
              if (f+1<tf&&c-1>=0&&mat[f+1][c-1]==1)
              {
                  contador++;
              }
              if (f+1<tf&&mat[f+1][c]==1)
              {
                  contador++;
              }
              if (f+1<tf&&c+1<tc&&mat[f+1][c+1]==1)
              {
                  contador++;
              }
              if (c+1<tc&&mat[f][c+1]==1)
              {
                  contador++;
              }
              
              if (mat[f][c]==1&&contador==2||mat[f][c]==1&&contador==3)
              {
                  Nmat[f][c]=1;
              }
              else if (mat[f][c]==0&&contador==3)
              {
                  Nmat[f][c]=1;
              }
          }
      }
      mat=Nmat;
      Nmat=new int [tf][tc];
    }
    public void pintar(Graphics papel, int mat[][])
    {
        for (int i=0;i<tf;i++)
        {
            for (int j=0; j<tc; j++)
            {
                if (mat[i][j]==1)
                {
                    papel.drawOval(j*16,i*16,16,16);
                }
            }
        }
    }
}
