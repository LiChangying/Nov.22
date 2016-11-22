import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

//*****************程序实现主要功能**********************//
//在文本框中输入抽奖者姓名，显示在文本域中，并且每个姓名都以回车符分开，用一个rand
//随机函数产生随机数，生成中奖者，将中奖者的相关信息与奖励显示在文本域中

//*******************程序正文***********************//
public class ChouJiang {

	private JFrame frame;
	private JTextField input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChouJiang window = new ChouJiang();
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
	public ChouJiang() {
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
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u62BD\u5956\u4EBA\u5458\u540D\u5355\uFF0C\u6BCF\u4E2A\u540D\u5B57\u540E\u52A0\u56DE\u8F66\u7ED3\u675F");
		lblNewLabel.setBounds(10, 10, 210, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea personnelArea = new JTextArea();
		personnelArea.setBounds(10, 62, 100, 189);
		frame.getContentPane().add(personnelArea);
		
		input = new JTextField();
		input.setBounds(10, 31, 100, 21);
		frame.getContentPane().add(input);
		input.setColumns(10);
		input.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e1){
				if(e1.getKeyChar()!='\n') return;
				String name = input.getText();
				if(name.isEmpty()) return;
				personnelArea.append(name + "\n");
				input.setText("");
			}
		});
		
		JTextArea note = new JTextArea("");
		note.setBounds(146, 35, 174, 216);
		frame.getContentPane().add(note);
		
		JButton choujiang = new JButton("\u62BD\u5956");
		choujiang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String perstring = personnelArea.getText();
				String[] personnelArray = perstring.split("\n");
				int index = (int)(Math.random()*personnelArray.length);
				String formatArg = "本次抽取观众人员：\n\t%1$s\n恭喜%1$s成为本次幸运观众"
						+"\n\n我们将为%1$s颁发:\n\t过期的酸奶20箱";
				String info = String.format(formatArg, personnelArray[index],personnelArray[index+1]);
				note.setText(info);
			}
		});
		choujiang.setBounds(331, 148, 93, 23);
		frame.getContentPane().add(choujiang);
		
		JButton exit = new JButton("\u9000\u51FA");
		exit.setBounds(331, 201, 93, 23);
		frame.getContentPane().add(exit);
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(1);
			}
		});
	}
}
