//该程序实现的主要功能是计算用户输入一组数的最小值，但是输入格式有严格的要求，必须以正确的格式输入，否则程序将报错，

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ArrayMinValue {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayMinValue window = new ArrayMinValue();
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
	public ArrayMinValue() {
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
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u5728\u6587\u672C\u6846\u4E2D\u8F93\u5165\u591A\u4E2A\u6570\u5B57\uFF0C\u4EE5\u7A7A\u683C\u9694\u5F00\uFF0C\u4F8B\u5982\uFF1A1 2 3 45 666 \u2026\u2026");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 424, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 32, 414, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(113, 76, 311, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton ji = new JButton("\u8BA1\u7B97");
		ji.setBounds(10, 72, 93, 23);
		frame.getContentPane().add(ji);
		
		JLabel note = new JLabel("\u6CE8\u610F\uFF1A\u5728\u8F93\u5165\u6570\u5B57\u7684\u65F6\u5019\u5FC5\u987B\u4E25\u683C\u6309\u7167\u6BCF\u4E2A\u6570\u5B57\u4E4B\u95F4\u4E00\u4E2A\u7A7A\u683C\u7684\u65B9\u6CD5\u8F93\u5165\uFF0C\u5426\u5219\u7A0B\u5E8F\u5C06\u53D1\u751F\u9519\u8BEF");
		note.setBounds(10, 121, 414, 130);
		frame.getContentPane().add(note);
		ji.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==ji){
					String str = textField.getText().trim();
					for(int i=0;i<str.length();i++){
						char charAt = str.charAt(i);
						if(!Character.isDigit(charAt)&&charAt !=' '){
							//JOptionPane.showMessageDialog(null,"输入包含非数字内容")；
							textField.setText("");
							return;
						}
					}
					String[] numStrs = str.split(" ");
					int[] numArray = new int[numStrs.length];
					//转换输入为整数数组
					for(int i=0;i<numArray.length;i++){
						numArray[i] = Integer.valueOf(numStrs[i]);
					}
					int min = numArray[0];
					for(int j = 0;j<numArray.length;j++){
						if(min>numArray[j]){
							min = numArray[j];
						}
					}
					lblNewLabel_1.setText("数组中最小的数是："+min);
				}
			}
		});
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});
	}
}
