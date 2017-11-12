package serviceImpl;

import java.rmi.RemoteException;

import service.UserService;
import usersinfo.UserList;
public class UserServiceImpl implements UserService {

	@Override
	public boolean login(String username, String password) throws RemoteException {
		UserList userList = new UserList();
		boolean res = userList.verifyUserInfo(username, password);
		return res;
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		return true;
	}

	@Override
	public boolean register(String username, String password) throws RemoteException {
		UserList userList = new UserList();
		if (userList.addUser(username, password)) {
			return true;
		} else {
			return false;
		}
	}

}
