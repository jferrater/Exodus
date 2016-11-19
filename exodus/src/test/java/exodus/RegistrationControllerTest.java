package exodus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.joffryferrater.exodus.controllers.Application;
import com.github.joffryferrater.exodus.dataservice.repositories.AccountRepo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
//@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RegistrationControllerTest {

	
	@Autowired
	private WebApplicationContext webContext;
	

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webContext).build();
	}
	   
	@Test
	public void test200OKRegistration() throws Exception {
		String data = jsonRegistrationData("", "Joffry Ferrater", "joffry.ferrater@gmail.com", "1234abcd");
		this.mockMvc.perform(post("/registration").contentType(MediaType.APPLICATION_JSON).content(data))
	                    .andDo(print())
	                    .andExpect(status().isOk())
	                    .andExpect(content().json(data));
	}
	
	private String jsonRegistrationData (String username, String fullName, String email, String password) {
		String data = "{"
						+ "	\"Username\": \""+username+"\","
						+ "	\"Full Name\": \""+fullName+"\","
						+ "	\"Email\": \""+email+"\","
						+ "	\"Password\": \""+password+"\""
						+ "}";
		return data;
	}
}
