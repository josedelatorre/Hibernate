package Main;

import DAO.*;
import Models.*;

public class Main {
	public static void main(String args[]) {
		ProfesorDAO dao = new ProfesorDAO();

		for (Profesor p : dao.find())
			System.out.println(p);

	}
}
