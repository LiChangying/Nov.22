import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ArrayReverseString {

	private JFrame frame;
	private JTextField input;
	private JTextArea output;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayReverseString window = new ArrayReverseString();
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
	public ArrayReverseString() {
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
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u4E00\u4E2A\u5B57\u7B26\u4E32");
		lblNewLabel.setBounds(10, 10, 96, 15);
		frame.getContentPane().add(lblNewLabel);
		
		input = new JTextField();
		input.setBounds(115, 7, 294, 21);
		frame.getContentPane().add(input);
		input.setColumns(10);

		output = new JTextArea();
		output.setBounds(115, 38, 294, 21);
		frame.getContentPane().add(output);
		output.setColumns(10);
		
		JButton button = new JButton("\u53CD\u8F6C");
		button.setBounds(10, 35, 93, 23);
		frame.getContentPane().add(button);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 68, 399, 183);
		frame.getContentPane().add(textArea);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==button){
					String str = input.getText();
					char[] str1 = str.toCharArray();
					for(int i=0;i<(int)(str1.length/2);i++){
						char temp = str1[i];
						str1[i] = str1[str1.length-i-1];
						str1[str1.length-i-1] = temp;
						textArea.append("第"+(i+1)+"次循环:\t");
						for(char c:str1){//这段程序最重要的就是遍历程序这块
							textArea.append(c+"");
						}
						textArea.append("\n");
					}
					String outputStr = new String(str1);
					output.setText(outputStr);
				}
			}
		});
		
	}

}
