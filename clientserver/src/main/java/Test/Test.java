package Test;

import java.io.IOException;
import java.io.OutputStream;

public class Test {
	public static void main(String args[]){
		try {
		    // Execute command
		    String command = "cmd /c start cmd.exe";
		    Process child = Runtime.getRuntime().exec(command);

		    // Get output stream to write from it
		    OutputStream out = child.getOutputStream();

		    out.write("cd C:/ /r/n".getBytes());
		    out.flush();
		    out.write("dir /r/n".getBytes());
		    out.close();
		} catch (IOException e) {
		}
	}
}
