package co.springboot.jackson;

import java.io.IOException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.springboot.jackson.model.MainParser;
import co.springboot.jackson.model.SecondParser;

@SpringBootApplication
public class SpringJacksonApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(SpringJacksonApplication.class, args);
		
		String inputJson="{  \"email\":\"abc@123.com\",  \"did_you_mean\":\"abc@me.com\",  \"user\":\"abc\",  \"domain\":\"123.com\",  \"format_valid\":true,  \"mx_found\":false,  \"smtp_check\":false,  \"catch_all\":null,  \"role\":false,  \"disposable\":false,  \"free\":true,  \"score\":0.16}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			//input et objet parsés et return dans un objet "mp"
			MainParser mp = mapper.readValue(inputJson,MainParser.class);
			System.out.println("Parsing to JSON object ----------------------------------------");
			System.out.println(mp.getScore());
			System.out.println(mp.getEmail());
			System.out.println(mp.getDomain());
			System.out.println("Ending parsing to JSON object --------------------------------------");
		}catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Lire des données JSON à partir d'un URL
		ObjectMapper mapper2 = new ObjectMapper();
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
			SecondParser sp = mapper2.readValue(url, SecondParser.class);
			System.out.println("Second Parsing to JSON Object ...........................");
			System.out.println(sp.getTitle());
			System.out.println(sp.getId());
			System.out.println(sp.getUserId());
			System.out.println("Ending parsing to JSON Object ............................");
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
