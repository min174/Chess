import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StartUp {
    JFrame frame = new JFrame();
    JButton start = new JButton("Start");
    ImageIcon imageIcon = new ImageIcon("icon.png");

    public StartUp() {
		start.setBounds(150,200,200,40);
		start.setFocusable(false);
		
		frame.add(start);
		
        frame.setTitle("Chess!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
        frame.setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
		frame.setVisible(true);
		
	}
}
