package service;
import java.rmi.RemoteException;
import java.rmi.Remote;


public interface ExecuteService extends Remote {
	public String execute(String code,String param)throws RemoteException;
}
