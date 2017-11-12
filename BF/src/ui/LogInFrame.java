package ui;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import rmi.RemoteHelper;
import java.awt.BorderLayout;
import java.awt.Color;

public class LogInFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	public LogInFrame() {

		JFrame frame = new JFrame("Log In");
		frame.setLayout(new BorderLayout());

		JLabel northBlank = new JLabel(" ");
		JLabel southBlank = new JLabel(" ");
		JLabel eastBlank = new JLabel("      ");
		JLabel westBlank = new JLabel("      ");

		frame.add(southBlank, BorderLayout.SOUTH);
		frame.add(northBlank, BorderLayout.NORTH);
		frame.add(eastBlank, BorderLayout.EAST);
		frame.add(westBlank, BorderLayout.WEST);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(4, 1));
		
		JPanel userNamePanel = new JPanel();
		userNamePanel.setLayout(new GridLayout(1, 2));
		JLabel userNameLabel = new JLabel("    User name:");
		userNamePanel.add(userNameLabel);
		JTextField userNameTextArea = new JTextField(1);
		userNameTextArea.setBackground(Color.WHITE);
		userNameTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
		userNamePanel.add(userNameTextArea);
		centerPanel.add(userNamePanel);

		JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(new GridLayout(1, 2));
		JLabel passwordLabel = new JLabel("    password:");
		passwordPanel.add(passwordLabel);
		JPasswordField passwordTextArea = new JPasswordField(1);
		passwordTextArea.setBackground(Color.WHITE);
		passwordTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
		passwordPanel.add(passwordTextArea);
		centerPanel.add(passwordPanel);

		JPanel warningPanel = new JPanel();
		JLabel warningLabel = new JLabel();
		warningLabel.setForeground(Color.RED);
		warningPanel.add(warningLabel);
		centerPanel.add(warningPanel);

		JPanel operatePanel = new JPanel();
		operatePanel.setLayout(new GridLayout());
		// 左侧空白
		JLabel leftLabel = new JLabel();
		operatePanel.add(leftLabel);
		// 登陆按钮
		JButton logInButton = new JButton("Log in");
		logInButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				username = userNameTextArea.getText();
				password = passwordTextArea.getPassword().toString();
				try {
					if (RemoteHelper.getInstance().getUserService().login(username, password)) {
						frame.dispose();
						new MainFrame(username);		
					} else {
							warningLabel.setText("Username or password is wrong!");				
					}
				} catch (RemoteException re) {
					re.printStackTrace();
				}
			}
		});
		operatePanel.add(logInButton);
		// 中间空白
		JLabel middleLabel = new JLabel();
		operatePanel.add(middleLabel);
		// 注册按钮
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				username = userNameTextArea.getText();
				password = new String(passwordTextArea.getPassword());
				try {
					if (RemoteHelper.getInstance().getUserService().register(username, password)) {
//						warningLabel.setText("name is right");
						frame.dispose();
						new MainFrame(username);
					} else {
						warningLabel.setText("User already exists!");
					}
				} catch (RemoteException re) {
					re.printStackTrace();
				}

			}
		});
		
		operatePanel.add(registerButton);
		// 右侧空白
		JLabel rightLabel = new JLabel();
		operatePanel.add(rightLabel);
		
		// 将操作面板加入中央面板
		centerPanel.add(operatePanel);
		centerPanel.setForeground(new Color(113,191,234));
		
		frame.add(centerPanel, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setLocation(650, 300);
		frame.setResizable(false);
		frame.setVisible(true);

	}

}

                   
