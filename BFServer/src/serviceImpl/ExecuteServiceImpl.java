package serviceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import service.ExecuteService;
import service.UserService;

public class ExecuteServiceImpl implements ExecuteService {
	
	

	
    //������ʵ��
	@Override
	public String execute(String code, String param) throws RemoteException {
		// TODO Auto-generated method stub

				 
				 String result = "";
				 ArrayList<Integer> loopindex = new ArrayList<Integer>();
				char[]  clist= code.toCharArray();
				char[] params = param.toCharArray();
				int[] s = new int[2048];
				 int sindex = 0;//stack
				 int pindex = 0;//param
				 int cindex = 0;

				while (cindex < clist.length) {
					switch (clist[cindex]) {
					case ',':
						s[sindex] = params[pindex];
						pindex++;
						cindex++;
						break;
					case '.':
						result += (char) s[sindex];
						cindex++;
						break;
					case '+':
						s[sindex]++;
						cindex++;
					break;
					case '-':
						s[sindex]--;
						cindex++;
						break;
					case '>':
						sindex++;
						cindex++;
						break;
					case '<':
						sindex--;
						cindex++;
						break;
					case '[':
						if (s[sindex] == 0) {
							cindex++;
							while (clist[cindex] != ']') {
								cindex++;
							}
							cindex++;
						} else {
							loopindex.add(cindex);
							cindex++;
						}
						break;
					case ']':
						if (s[sindex] != 0) {
							cindex = loopindex.get(loopindex.size() - 1) + 1;
						} else {
							cindex++;
							loopindex.remove(loopindex.size() - 1);
						}
						break;
					}
				}

				return result;
			}
	
	
	
	

		}


