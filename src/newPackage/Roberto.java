package newPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Roberto
 */
@WebServlet("/roberto")
public class Roberto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		Cookie biscotto = new Cookie("name",name);
		response.addCookie(biscotto);
		Cookie biscotto2 = new Cookie("surname",surname);
		response.addCookie(biscotto2);
		Cookie biscotto3 = new Cookie("email",email);
		response.addCookie(biscotto3);
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
		{
			for (Cookie bisc : cookies)
			{
				
				if ("name".equals(bisc.getName()))
				{
					if (name == null || name.equals(""))
					{
						name = bisc.getValue();
					}
				}
				if ("surname".equals(bisc.getName()))
				{
					if (surname == null || surname.equals(""))
					{
						surname = bisc.getValue();
					}
					
				}
				if ("email".equals(bisc.getName()))
				{
					if (email == null || email.equals(""))
					{
						email = bisc.getValue();
					}
				}
				
			}
		
		}
		StringBuilder html = new StringBuilder();
		html.append("<!doctype html><html>");
		html.append("<head><title>Roberto</title></head>");
		html.append("<body><h1>Dati personali</h1>");
		html.append("<p><ul><li>");
		html.append(name);
		html.append("</li>");
		html.append("<li>" + surname);
		html.append("</li>");
		html.append("<li>" + email);
		html.append("</li></ul></p>");
		html.append("</body></html>");
		
		
		
		PrintWriter out = response.getWriter();
		out.println(html.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
