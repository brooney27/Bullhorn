package customTools;

import java.util.ArrayList;
import model.Bhuser;

public class TableUtil {
	public static String generateTable(ArrayList<Bhuser> users){
		StringBuilder output = new StringBuilder();
		output.append("<table><tr>");
		output.append("<th>ID</th><th>Name</th><th>Email</th></tr>");
		
		for(int i = 0; i<users.size();i++){
			output.append("<tr>");
			output.append("<td>"+users.get(i).getBhuserid()+"</td>");
			output.append("<td>"+users.get(i).getUsername()+"</td>");
			output.append("<td>"+users.get(i).getUseremail()+"</td>");
			output.append("</tr>");
		}
		output.append("</table>");
		
		return output.toString();
	}
}

