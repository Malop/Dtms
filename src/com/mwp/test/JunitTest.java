package com.mwp.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mwp.control.LoginController;
import com.mwp.thread.MyThreadPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-mvc.xml"})
public class JunitTest {

	//@Autowired
	//PartyMemberService partyMemberService;
	
	@Autowired
	LoginController loginController;
	

	static CountDownLatch coutDownLatch = new CountDownLatch(20);
	private MockMvc mockMvc; 
	//private MockHttpServletRequestBuilder mockHttpServletRequestBuilder;
	@Before  
    public void setup() {  
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build(); 
    }
	@Test
	public void HttpPostTest(){
		try {
			CloseableHttpClient client = HttpClients.createDefault();
	        String url="http://localhost:8080/Dtms/index/login";
	        HttpPost post=new HttpPost(url);
	        List<NameValuePair> param=new ArrayList<NameValuePair>();
	        param.add(new BasicNameValuePair("username","admin"));
	        param.add(new BasicNameValuePair("password","111"));
	        UrlEncodedFormEntity entity=new UrlEncodedFormEntity(param,"utf-8");
	        post.setEntity(entity);
		    CloseableHttpResponse response = client.execute(post);
		    HttpEntity res = response.getEntity();
		    InputStream content = res.getContent();
		    System.out.println(IOUtils.toString(content));
	     } catch (Exception e) {
	         e.printStackTrace();
         }
	}
	
	public void test() {
		try {
			System.out.println("+++++++++++11111");
			MyThreadPool mtp = new MyThreadPool();
			for(int i=0;i<20;i++){
				WorkerThread t = new WorkerThread(mockMvc);
				
				mtp.execute(t);
			}
			coutDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class WorkerThread extends Thread{
        private MockMvc mockMvc ;
        
        WorkerThread(MockMvc mockMvc){
        	this.mockMvc = mockMvc;
        }

        @Override
        public void run() {
        	System.out.println("线程"+Thread.currentThread()+"启动");
        	try {  
	            ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders.post("/index/login")  
	                    .param("username", "admin").param("password", "aaa"));
	            MvcResult mr = ra.andReturn();  
	            String result = mr.getResponse().getContentAsString();  
	            System.out.println("+++++++++++"+result);  
	            coutDownLatch.countDown();
	        } catch (Exception e) {  
	            Assert.fail("fail");  
	            e.printStackTrace();  
	        } 
        }
    }
}
