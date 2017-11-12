package serviceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import service.IOService;

public class IOServiceImpl implements IOService {

	@Override
	public boolean writeFile(String file, String userId, String fileName) {
		File f = new File(userId + "_" + fileName);
		try {
			FileWriter fw = new FileWriter(f, false);
			fw.write(file);
			fw.flush();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String readFile(String userId, String fileName) {
		File f = new File(userId + "_" + fileName);
		String res = "";
		String temp = null;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while ((temp = br.readLine()) != null) {
				res += temp + "\n";
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String readFileList(String userId) {
		File f = new File("./");
		File[] files = f.listFiles();
		String res = "";
		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().startsWith(userId)) {
				String[] temp = files[i].getName().split("_");
				res += temp[1] + "\n";
			}
		}
		return res;
	}

}
