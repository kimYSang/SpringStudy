package kr.ac.skuniv;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SampleControllerTest {
	
	private static final Logger logger =
			LoggerFactory.getLogger(SampleControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mockMvc; // 브라우저에서 요청과 응답을 의미하는 객체
	
	@Before
	public void setup() {  // 테스트를 진행할 때마다 가상의 요청과 응답을 처리하기 위해 @Before 애노테이션으로 테스트 메소드 실행전 MockMvc 객체 생성
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.info("setup.....................");
	}
	
	@Test
	public void testDoA() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/doA"));	
	}
}
