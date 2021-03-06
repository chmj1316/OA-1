/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.icss.hit.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.icss.hit.bean.WorkListBean;
import com.icss.hit.bean.interfaces.WorkList;
import com.icss.hit.hibernate.vo.Schedule;

/** 
 * 待办事项清单(前5项)
 * Creation date: 08-05-2009
 * @author 朱金彪
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="planList.succeed" path="/work/planList.jsp"
 */
public class PlanListAction extends Action {
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
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 当前登录用户ID
		long id=-1;
		if( request.getSession().getAttribute("UserId") != null ){
			id = Long.parseLong(request.getSession().getAttribute("UserId").toString());
		}else{
			return mapping.findForward("NullLogin");
		}
		
		List<Schedule> list = null;
		if( id != -1){
			WorkList work = new WorkListBean();
			list = work.getFiveWorkPlan(id);
			request.setAttribute("planList", list);
		}
		return mapping.findForward("planList.succeed");
	}
}