package mygroup.ibm.maven_json_binding;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			ObjectMapper mapper= new ObjectMapper();
			Student theStudent=mapper.readValue(new File("demo-lite.json"), Student.class);
			
			String[] temp= theStudent.getLanguage();
			StringBuilder sb=new StringBuilder();
			for(String str:temp)
			sb.append(str);
			
			System.out.println(theStudent.getFirstName()+" "+theStudent.getLastName());
			System.out.println(theStudent.getCountry());
			System.out.println(theStudent.getAddress().getCity());
			System.out.println(theStudent.getAddress().getLandmark());
			System.out.println(sb.toString());
		}
       catch(Exception e)
		{
    	   e.printStackTrace();
		}
	}

}
