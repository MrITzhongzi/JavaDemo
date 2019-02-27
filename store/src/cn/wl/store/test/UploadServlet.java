package cn.wl.store.test;

import jdk.internal.util.xml.impl.Input;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = -4187075130535308117L;
    private int maxFileSize = 1024 * 1024 * 10;
    private int maxMemSize = 100 * 1024;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> map = new HashMap<>();
       DiskFileItemFactory fac = new DiskFileItemFactory();
       ServletFileUpload upload = new ServletFileUpload(fac);
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem item :
                    fileItems) {
                if (item.isFormField()) {
                    System.out.println("普通项-------------------------------------");
                    System.out.println(item.getFieldName());
                    System.out.println(item.getName());
                    System.out.println(item.getSize());
                    System.out.println(item.getInputStream());
                    map.put(item.getFieldName(), item.getString("utf-8"));
                } else {
                    System.out.println("上传项-------------------------------------");
                    System.out.println(item.getFieldName());
                    System.out.println(item.getName());
                    System.out.println(item.getSize());

                    InputStream is = item.getInputStream();
                    String realPath = getServletContext().getRealPath("/");
                    File file = new File(realPath, item.getName());
                    if(!file.exists()){
                        file.createNewFile();
                    }

                    OutputStream os = new FileOutputStream(file);
                    IOUtils.copy(is, os);
                    IOUtils.closeQuietly(is);
                    IOUtils.closeQuietly(os);
                    map.put("userhead", realPath + item.getName());
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    protected void doPost2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            //未检测到上传请求
            System.out.println("未检测到上传请求");
            return;
        }

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(maxFileSize);
        String path = getServletContext().getRealPath("/") + "/";
        diskFileItemFactory.setRepository(new File(path));

        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setSizeMax(maxFileSize);

        try {
            List<FileItem> list = servletFileUpload.parseRequest(request);

            Iterator<FileItem> iterator = list.iterator();
            while (iterator.hasNext()) {
                FileItem fi = (FileItem) iterator.next();
                if (!fi.isFormField()) {

                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

                    //写入文件
                    File file = new File(path + System.currentTimeMillis() / 1000 + ".jpg");
                    fi.write(file);
                }
            }
            System.out.println("上传成功");
        } catch (Exception e) {
            System.out.println("上传失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
