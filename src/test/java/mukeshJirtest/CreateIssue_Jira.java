package mukeshJirtest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateIssue_Jira {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
Issuename issue=new Issuename("issuetype");
Project project=new Project("project");
Payload payload=new Payload("summary","description",project,issue);
Fields f=new Fields(payload);

ObjectMapper obj= new ObjectMapper();
//String carAsString = obj.writeValueAsString(f);

String carAsString =obj.writerWithDefaultPrettyPrinter().writeValueAsString(f);
System.out.println(carAsString);

//Fields field=new Fields("fields");
	}

}
 