package usersinfoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserList {

	private ArrayList<User> userList = new ArrayList<User>();
	private File file = new File("UserInfo");

	public UserList() {
		try {
			FileWriter fw=new FileWriter(file,true);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String userInfoStr = br.readLine();
			while (userInfoStr != null) {
				String[] userInfo = userInfoStr.split(" ");
				User user = new User(userInfo[0], userInfo[1]);
				userList.add(user);
				userInfoStr = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public boolean verifyUserInfo(String username, String password) {
		boolean res = false;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).verify(username, password)) {
				res = true;
				break;
			}
		}
		return res;
	}

	public boolean addUser(String username, String password) {
		if (this.verifyUserInfo(username, password)) {
			return false;
		} else {
			userList.add(new User(username, password));
			this.writeFile();
			return true;
		}
	}

	public boolean writeFile() {
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(userList.get(userList.size() - 1).toString() + "\r\n");
			fw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return false;
	}

}
