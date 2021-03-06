/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.icss.hit.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.icss.hit.bean.interfaces.*;
import com.icss.hit.bean.*;
import com.icss.hit.hibernate.vo.*;
/** 
 * MyEclipse Struts
 * Creation date: 07-28-2009
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="UserInfo.error" path="/login/login.jsp"
 * @struts.action-forward name="UserInfo.succeed" path="/info/UserInfo.jsp"
 */
/**
 * @author xw-pc
 *
 */
public class UserInfoAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		long userId = 1;
		if( request.getSession().getAttribute("UserId") != null ){
			userId = Long.parseLong(request.getSession().getAttribute("UserId").toString());
		}else{
			return mapping.findForward("NullLogin");
		}
		
		UserInfo info = new UserInfoBean();
		SysUser user = info.getUserInfo(userId);
		// 设置头像输出的路径
		user.setPath(request.getRealPath("/headphoto/")+"\\");
		//System.out.println(request.getRealPath("/headphoto/")+"\\");
		request.setAttribute("userInfo",user);
		return mapping.findForward("UserInfo.succeed");
	}
}