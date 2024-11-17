package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
//"say-hello=>"Hello! What are you learning today?"
	//http://localhost:8080/
	@RequestMapping("say-hello")
	@ResponseBody
	public String SayHello() {
		return "Hello! What are you learning today?";
	}
	public String SayHelloHtml() {
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first html page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h2>My first html page body</h2>");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	@RequestMapping("say-hello-jsp")
	public String SayHelloJsp() {
		return "sayHello";
	}
	//Prefix and suffix will be added to sayHello,so that view can be resolved
}
