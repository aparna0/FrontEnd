
package player;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Frontend implements ActionListener
{
JButton open,upload,start;
JFrame fr;
JLabel bg;
JPanel header;
JRadioButton micro,aud;
JRadioButton r1;
JTextField tx;
int flag;
 FileDialog fd;
    Frontend()
   {
       //font
       Font f=new Font("serif",Font.BOLD,40);
//frame
    fr=new JFrame();
    fr.setSize(700,500);
    fr.setLayout(null);
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    //background
ImageIcon img=new ImageIcon("C:\\Users\\Shree\\Desktop\\jr\\IMG_20190106_223533.jpg");
 bg=new JLabel("",img,JLabel.CENTER);
 Image img2=img.getImage();
 Image img3=img2.getScaledInstance(700,500,Image.SCALE_SMOOTH);
 img=new ImageIcon(img3);
     bg.setBounds(0,0,700,500);
     fr.add(bg);
     
     
   //header
    header=new JPanel();
    header.setBackground(new Color(0,0,0,20));
    header.setBounds(100,90,500,300);
   bg.add(header);
     JLabel name=new JLabel("Subtitle Generater...");
   name.setFont(f);
   name.setForeground(Color.BLUE);
   name.setBounds(200,30,400,50);
   bg.add(name);
   
  //radiobutton
  Font f1=new Font("serif",Font.BOLD,23);
  ButtonGroup group=new ButtonGroup();
  micro=new JRadioButton("micophone",false);
   aud =new JRadioButton("audio",false);
   group.add(micro);
   group.add(aud);
   micro.setFont(f1);
   aud.setFont(f1);
   micro.addActionListener(this);
   aud.addActionListener(this);
   micro.setBounds(180,120,150,30);
   aud.setBounds(400,120,150,30);
   bg.add(micro);
   bg.add(aud);
  open=new JButton("setect file");
  open.setEnabled(false);
  
   
    open.setBounds(400,180,150,40);
    open.setFont(new Font("serif",Font.BOLD,20));
    bg.add(open);
    open.addActionListener(this);
     upload=new JButton("upload");
      upload.setEnabled(false);
     upload.setBounds(400,240,150,40);
     upload.setFont(new Font("serif",Font.BOLD,20));
     bg.add(upload);
 upload.addActionListener(this);
    fr.setVisible(true);
    start=new JButton("start");
    start.setFont(new Font("serif",Font.BOLD,20));
     start.setEnabled(false);
    start.setBounds(400,300,150,40);
    bg.add(start);
     tx=new JTextField();
    tx.setBounds(150,180,210,40);
    tx.setFont(new Font("serif",Font.PLAIN,20));
    bg.add(tx);
}
   public void actionPerformed(ActionEvent ae)
   {
      
       if(ae.getSource()==micro)
       {   //System.out.print("fdf");
           flag=1;
           open.setEnabled(true);
       }
       if(ae.getSource()==aud)
       {
       flag=0;
       open.setEnabled(true);
       }
        if(ae.getSource()==open)
       {  
           upload.setEnabled(true);
           if(flag==1)
           {
               
             fd=new FileDialog(fr,"creating a file",FileDialog.SAVE);
             fd.setSize(500,300);
             fd.setVisible(true);
           }
          if(flag==0)
           {
               fd=new FileDialog(fr,"creating a file",FileDialog.LOAD);
                 fd.setSize(500,300);
             fd.setVisible(true);
           }
           
       }
       if(ae.getSource()==upload)
       {   tx.setText(fd.getFile());
            start.setEnabled(true);
       }
       if(ae.getSource()==start)
       {
           
       }
   }
    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable()
       {
           public void run()
           {
               Frontend p=new Frontend();
           }
       });
    
}

   
}
