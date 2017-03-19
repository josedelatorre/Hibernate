package Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import DAO.ProfesorDAO;


public class Main {
	
	
	public static void main(String args[]) {
		
		ApplicationContext context =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		ProfesorDAO dao=context.getBean(ProfesorDAO.class);

		
		dao.probando();
		

	}
}
