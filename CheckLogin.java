//实现主要功能：
//1 用户登录验证程序
//2 如果用户名密码输入错误可以重置
//3 登陆成功失败都有显示
//4 登陆成功后，可以点击reback按钮重置程序，重新进行登陆验证
//5 不管是登陆成功与否，输入用户名和密码的文本框中内容都会清除

import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
class LoginCheck{
	private String name;
	private String password;
	public LoginCheck(String name,String password){
		this.name = name;
		this.password = password;
	}
	
	public boolean validate() {
		// TODO Auto-generated method stub
		if("lichangying".equals(name)&&"123456".equals(password)){
			return true;
		}else{
			return false;
		}
	}
}
public class CheckLogin {

	private JFrame frame;
	private JTextField nameText;
	private JPasswordField passText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckLogin window = new CheckLogin();
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
	public CheckLogin() {
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
		
		
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setBounds(25, 22, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(25, 59, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		nameText = new JTextField();
		nameText.setBounds(83, 19, 66, 21);
		frame.getContentPane().add(nameText);
		nameText.setColumns(10);
		
		passText = new JPasswordField();
		passText.setBounds(83, 56, 66, 21);
		frame.getContentPane().add(passText);
		
		JLabel infoLab = new JLabel("\u7528\u6237\u767B\u5F55\u7CFB\u7EDF");
		infoLab.setBounds(25, 95, 298, 46);
		frame.getContentPane().add(infoLab);
		
		
		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.setBounds(178, 18, 93, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==btnNewButton){
					String name = nameText.getText();
					String password = new String(passText.getPassword());
					LoginCheck log = new LoginCheck(name,password);
					if(log.validate()){
						infoLab.setText("succeed");
						nameText.setText("");
					}else{
						infoLab.setText("failed");
						passText.setText("");
					}
				}
			}
		});
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(178, 55, 93, 23);
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){
				if(arg1.getSource()==reset){
					nameText.setText("");
					passText.setText("");
					infoLab.setText("\u7528\u6237\u767B\u5F55\u7CFB\u7EDF");
				}
			}
		});
		frame.getContentPane().add(reset);
		
		JButton reback = new JButton("reback");
		reback.setBounds(178, 107, 93, 23);
		frame.getContentPane().add(reback);
		reback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg2){
				if(arg2.getSource()==reback){
					infoLab.setText("\u7528\u6237\u767B\u5F55\u7CFB\u7EDF");
					nameText.setText("");
					passText.setText("");
				}
			}
		});
		
	
	}

}
