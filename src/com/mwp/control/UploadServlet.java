package com.mwp.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UploadServlet extends HttpServlet {
	
	public UploadServlet(){
		super();
	}
	
	public void destroy() {
		super.destroy();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		this.doPost(request, response);
//		response.setContentType(CONTENT_TYPE);
		response.setCharacterEncoding("GBK");
		request.setCharacterEncoding("GBK");
		
        PrintWriter out = response.getWriter();
        DiskFileItemFactory fac = new DiskFileItemFactory();
        //���û����ļ���С
        fac.setSizeThreshold(1024*1024);
        //�����ļ�λ�ã�����ȡ����Ĭ�ϵ�λ��
        fac.setRepository(fac.getRepository());
        ServletFileUpload upload = new ServletFileUpload(fac);
        //������������ϴ����ļ���С��������5MB
        upload.setFileSizeMax(1024*1024*5);
        List fileList = null;
        try {
            fileList = upload.parseRequest(request);
        } catch (FileUploadException ex) {
//            response.sendRedirect("admin/upload.jsp?result=size");
            response.sendRedirect("/index.jsp");
            ex.printStackTrace();
            return;
        }
        Iterator iter = fileList.iterator();
        while(iter.hasNext()){
            FileItem fileItem = (FileItem)iter.next();
            if(!fileItem.isFormField()){
                String name = fileItem.getName();
                String fileSize = new Long(fileItem.getSize()).toString();
                if(name == null || name.equals("") || fileSize.equals("0"))
                    continue;
                //��ȡ�����ļ���
                name = name.substring(name.lastIndexOf("\\")+1);
                //�洢�ļ�
                File saveFile = new File("d:\\upload\\"+name);
                try {
                    fileItem.write(saveFile);
                } catch (Exception ex1) {
                    ex1.printStackTrace();
                    return;
                }
            }
        }
        
        request.getRequestDispatcher("/index.jsp")
    	.forward(request, response);
        out.close();
//        response.sendRedirect("/index.jsp");
     
	}
	
	public void init() throws ServletException {
	}
}
