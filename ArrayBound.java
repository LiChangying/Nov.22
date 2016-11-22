import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ArrayBound {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayBound window = new ArrayBound();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArrayBound() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JFormattedTextField codeField = new JFormattedTextField(NumberFormat.getInstance());
		codeField.setBounds(116, 39, 213, 26);
		frame.getContentPane().add(codeField);
		
		
		JTextArea out = new JTextArea();
		out.setBounds(10, 114, 414, 86);
		frame.getContentPane().add(out);
		
		JButton but = new JButton("\u786E\u5B9A");
		but.setBounds(341, 40, 93, 23);
		frame.getContentPane().add(but);
		but.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String[] str = {"sing a song","play a game","doing something","come on !","thanks"};
				if(e.getSource()==but){
					int index = ((Number)codeField.getValue()).intValue();//返回一个int型数据，如果不加intValue()则会返回Integer对象
					try{
						out.setText(str[index]);
					}catch(Exception e1){
						out.setText("bye-bye");
					}
				}
			}
		});
		
		JLabel note = new JLabel("\u6570\u636E\u8F93\u5165");
		note.setBounds(58, 40, 48, 23);
		frame.getContentPane().add(note);
		
		
	}
}
