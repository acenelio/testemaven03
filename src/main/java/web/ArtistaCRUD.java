package web;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Artista;

@WebServlet("/ArtistaCRUD")
public class ArtistaCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
		EntityManager em = emf.createEntityManager();
		List<Artista> lista = (List<Artista>) em.createQuery("SELECT x FROM Artista x").getResultList();

		request.setAttribute("lista", lista);
		RequestDispatcher rd = request.getRequestDispatcher("listar-artistas.jsp");
		rd.forward(request, response);
	}

}
