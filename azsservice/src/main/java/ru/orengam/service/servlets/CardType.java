package ru.orengam.service.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.orengam.unipos.TradeGoods;
import ru.orengam.unipos.extdebit.ExtDebitRequest;
import static ru.orengam.unipos.InsertionFlag.*;

/**
 * Servlet implementation class CardType
 */
public class CardType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cardType = 1;
		ExtDebitRequest request = new ExtDebitRequest(1, cardType, 0, CARD_INSERT, new TradeGoods(dose, cost, code));
	}

}
