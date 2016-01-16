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

import com.icss.hit.bean.WorkPlanBean;
import com.icss.hit.bean.interfaces.WorkPlanDao;
import com.icss.hit.component.PageBean;
import com.icss.hit.hibernate.vo.Schedule;

/** 
 * ʵ���˲鿴�ճ̰��ŵ�ҳ��ҵ���߼�
 * Creation date: 08-03-2009
 * @author ������
 * @struts.action validate="true"
 * @struts.action-forward name="WorkPlan.succeed" path="/work/workPlan.jsp"
 */
public class WorkPlanAction extends Action {
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
		long userId = 1L;
		if( request.getSession().getAttribute("UserId") != null ){
			userId = Long.parseLong(request.getSession().getAttribute("UserId").toString());
		}else{
			return mapping.findForward("NullLogin");
		}
		
		// �õ��û�ID
		if( request.getSession().getAttribute("UserId") != null ){
			userId = Long.parseLong(request.getSession().getAttribute("UserId").toString());
		}
		
		WorkPlanDao work = new WorkPlanBean();
		int count = work.getWordPlanCount(userId);
		int pageCount = 0;
		if( count != 0 ){
			// �õ���ҳ��
			pageCount = work.getPageCount(count, WorkPlanBean.PAGE_SIZE);
		}
		
		// ��ǰҳ��
		int pageNo = 1;
		if( request.getParameter("page") != null ){
			try{
				pageNo = Integer.parseInt(request.getParameter("page"));
			}catch( Exception e){
				pageNo = 1;
			}
		}
		
		// �õ���ǰҳ��������
		if( pageCount != 0){
			List<Schedule> list = work.getWorkPlanByPage(userId, pageNo);
			request.setAttribute("schList", list);
			
			// �����ҳ����Ϣ
			PageBean bean = new PageBean();
			bean.setTotal(pageCount);
			bean.setLink("./WorkPlan.do");
			bean.setThispage(pageNo);
			
			request.setAttribute("page", bean.getPageString());
		}
		return mapping.findForward("WorkPlan.succeed");
	}
}