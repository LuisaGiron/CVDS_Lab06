package edu.eci.cvds.servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonParseException;

import edu.eci.cvds.servlet.model.Todo;

/**
 * 
 * @author Luisa Bermudez - Daniela Ladino
 * @version 1 (21/09/2022)
 */

@WebServlet(
		urlPatterns = "/otherServlet"
)
public class OtherServlet  extends SampleServlet{
	private List<Todo> todaLaLista;
	
	public OtherServlet() {
		super();
		todaLaLista = new ArrayList<Todo>();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int idLista = Integer.parseInt(req.getParameter("id")); 
			Todo t = Service.getTodo(idLista);
			if(!(t==null)) {
				todaLaLista.add(t);
				writeTable(resp);
			}else {
				writeNotFound(resp);
			}
			
		}catch(MalformedURLException me) {
			writeInternalServerError(resp);
			
		}catch(IOException ie) {
			writeNotFound(resp);
			
		}catch(Exception  e) {
			e.printStackTrace();
			writeBadRequest(resp);
			
		}
	}
	
	private void writeTable(HttpServletResponse resp)throws IOException {
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.getWriter().write(Service.todosToHTMLTable(todaLaLista));		
	}
	
	private void writeNotFound(HttpServletResponse resp)throws IOException {
		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		resp.getWriter().write("404 NOT FOUND");
	}
	
	private void writeBadRequest(HttpServletResponse resp) throws IOException {
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		resp.getWriter().write("400 BAD REQUEST");
	}
	
	private void writeInternalServerError(HttpServletResponse resp) throws IOException {
		resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		resp.getWriter().write("500 INTERNAL SERVER ERROR");
	}
}
