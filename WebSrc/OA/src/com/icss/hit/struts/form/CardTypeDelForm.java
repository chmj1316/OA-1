/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.icss.hit.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.icss.hit.bean.CardTypeBean;
import com.icss.hit.bean.interfaces.CardTypeDao;

/** 
 * MyEclipse Struts
 * Creation date: 08-01-2009
 * 
 * XDoclet definition:
 * @struts.form name="cardTypeAddForm"
 */
public class CardTypeDelForm extends ActionForm {
	/*
	 * Generated fields
	 */
	
	/** cardTypeID property */
	private String cardtypeid;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		ActionErrors errors = new ActionErrors();
		long typeID = Long.parseLong(cardtypeid);
		System.out.println(typeID);
		CardTypeDao cardType = new CardTypeBean();
		boolean hasCard = cardType.hasCard(typeID);
		
		if(hasCard==true)errors.add("CardExist", new ActionMessage("CardExist.Exist"));
		
		return errors;
		
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	public String getCardtypeid() {
		return cardtypeid;
	}

	public void setCardtypeid(String cardtypeid) {
		this.cardtypeid = cardtypeid;
	}



	
}