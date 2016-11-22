import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

//*****************����ʵ����Ҫ����**********************//
//���ı���������齱����������ʾ���ı����У�����ÿ���������Իس����ֿ�����һ��rand
//�����������������������н��ߣ����н��ߵ������Ϣ�뽱����ʾ���ı�����

//*******************��������***********************//
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
				String formatArg = "���γ�ȡ������Ա��\n\t%1$s\n��ϲ%1$s��Ϊ�������˹���"
						+"\n\n���ǽ�Ϊ%1$s�䷢:\n\t���ڵ�����20��";
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
