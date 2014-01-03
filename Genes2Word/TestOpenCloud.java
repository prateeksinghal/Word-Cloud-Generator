import java.util.*;
import java.io.*;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.SwingUtilities;

public class TestOpenCloud {
    protected void initUI() {
	File f=new File("Top100");
	String Str;
	String WORDS[]=new String[100];
	int FREQ[]=new int[100];
	String shuffle[]=new String[100];
	ArrayList<String> shuffling = new ArrayList<String>();
	int count=0,i,temp=1000000;
	try{
	Scanner br=new Scanner(f);
	
	while (br.hasNextLine()) 
			{
				Str=br.nextLine();
				shuffling.add(Str);
			}
		br.close();
	}catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		Collections.shuffle(shuffling);
		for(String str : shuffling)
		{
			
			WORDS[count]=str.substring(0,str.indexOf(' '));
				FREQ[count]=Integer.parseInt(str.substring(str.indexOf(' ')+1,str.length()));
				if(FREQ[count]<temp)
					temp=FREQ[count];
				count++;
		}	
        JFrame frame = new JFrame(TestOpenCloud.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        //Cloud cloud = new Cloud();
        Random random = new Random();
        for (i=0;i<100;i++) {
            
       
			final int red = (int) (Math.random() * 150);
			final int green = (int) (Math.random() * 150);
			final int blue = (int) (Math.random() * 150);
            final JLabel label = new JLabel(WORDS[i]);
            label.setOpaque(false);
            label.setFont(new Font("Andalus", Font.PLAIN, ((FREQ[i]*11)/temp)));
			Color color=new Color(red,green,blue);
			label.setForeground(color);
            panel.add(label);
        }
        frame.add(panel);
        frame.setSize(1366, 768);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestOpenCloud().initUI();
            }
        });
    }

}