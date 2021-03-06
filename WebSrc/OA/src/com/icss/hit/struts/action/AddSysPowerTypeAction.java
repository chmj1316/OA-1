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

import com.icss.hit.bean.SysPowerTypeBean;
import com.icss.hit.bean.interfaces.SysPowerTypeDao;
import com.icss.hit.hibernate.vo.SysPower;
import com.icss.hit.hibernate.vo.SysPowerType;
import com.icss.hit.struts.form.AddSysPowerTypeForm;

/** 
 * 添加系统权限分类
 * Creation date: 08-09-2009
 * @author xw-pc
 * XDoclet definition:
 * @struts.action path="/addSysPowerType" name="addSysPowerTypeForm" input="/newSysPowerType.do" scope="request" validate="true"
 */
public class AddSysPowerTypeAction extends Action {
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
		AddSysPowerTypeForm addSysPowerTypeForm = (AddSysPowerTypeForm) form;// TODO Auto-generated method stub
		SysPowerTypeDao std = new SysPowerTypeBean();
		//实例化一个系统权限，添加权限分类到系统权限
		SysPower sp = new SysPower();
		SysPowerType spt =new SysPowerType();
		sp.setSpName(addSysPowerTypeForm.getSp_name());
		spt.setSptId(Long.parseLong(addSysPowerTypeForm.getSpt_name()));
		sp.setSysPowerType(spt);
		//插入系统权限到数据库
		if(std.addSysPower(sp))
		{
			return mapping.findForward("AddSysPower.succeed");
		}
		else
		{
			return mapping.findForward("AddSysPower.faild");
		}
	}
}