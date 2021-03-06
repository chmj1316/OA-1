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

import com.icss.hit.bean.CheckPower;
import com.icss.hit.bean.ManageRoomBean;
import com.icss.hit.bean.interfaces.manageRoomDao;
import com.icss.hit.hibernate.vo.Room;
import com.icss.hit.struts.form.AlterRoomForm;

/** 
 * 用于修改房间内容，并且更新
 * Creation date: 08-10-2009
 * @author 赵颖申
 * XDoclet definition:
 * @struts.action input="/manageAllRooms.do" validate="true"
 * @struts.action-forward name="roomAlter.successd" path="/alterRoom.do"
 */
public class RoomAlterAction extends Action {
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
		// 当前用户ID
		long userId = -1;
		if( request.getSession().getAttribute("UserId") != null ){
			userId = Long.parseLong(request.getSession().getAttribute("UserId").toString());
		}else{
			return mapping.findForward("NullLogin");
		}
		// 判断用户权限
		CheckPower check = new CheckPower(userId);
		check.getPower();
		if( !check.check(CheckPower.ADMIN_ROOM)){
			return mapping.findForward("NullLogin");
		}
		
		manageRoomDao manageRoom = new ManageRoomBean();
		Room room = new Room();
		if(request.getParameter("roomID")==null)
		{
			request.setAttribute("rid", request.getAttribute("rid"));
			request.setAttribute("rname",request.getAttribute("rname"));
			request.setAttribute("rcontain", request.getAttribute("rcontain"));
			request.setAttribute("rInfo", request.getAttribute("rInfo"));
			return mapping.findForward("roomAlter.successd");
		}
		else
		{
		
			room = manageRoom.readRoom(Long.parseLong(request.getParameter("roomID")));
			request.setAttribute("rid", room.getRId());
			request.setAttribute("rname",room.getRName());
			request.setAttribute("rcontain", room.getRContain());
			request.setAttribute("rInfo", room.getRInfo());
			return mapping.findForward("roomAlter.successd");
		}
	}
}