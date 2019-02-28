package cn.wl.store.web.servlet;

import cn.wl.store.domain.Category;
import cn.wl.store.domain.PageModel;
import cn.wl.store.domain.Product;
import cn.wl.store.service.CategoryService;
import cn.wl.store.service.ProductService;
import cn.wl.store.service.serviceImp.CategoryServiceImp;
import cn.wl.store.service.serviceImp.ProductServiceImp;
import cn.wl.store.utils.UUIDUtils;
import cn.wl.store.utils.UploadUtils;
import cn.wl.store.web.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminProductServlet extends BaseServlet {

    public String findAllProductsWithPage(HttpServletRequest req, HttpServletResponse resp) {
        int curNum = Integer.parseInt(req.getParameter("num"));
        ProductService productService = new ProductServiceImp();
        try {
            PageModel pm = productService.findAllProductsWithPage(curNum);
            req.setAttribute("page", pm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/admin/product/list.jsp";
    }

    public String addProductUI(HttpServletRequest req, HttpServletResponse resp) {
        CategoryService categoryService = new CategoryServiceImp();
        List<Category> allCats = null;
        try {
            allCats = categoryService.getAllCats();
            req.setAttribute("allCats", allCats);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/admin/product/add.jsp";
    }

    public String addProduct(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String> map = new HashMap<>();
        Product product = new Product();
        try {
            /*
             *   解析以文件上传的方式 传到服务器的 数据
             * */
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> fileItems = upload.parseRequest(req);
            for (FileItem item :
                    fileItems) {
                if (item.isFormField()) {
                    //普通项  :        拿到键 和  值
                    map.put(item.getFieldName(), item.getString("utf-8"));
                } else {
                    //要保存的文件的名称
                    String oldFileName = item.getName();
                    //要保存的文件名称
                    String newFileName = UploadUtils.getUUIDName(oldFileName);
                    //上传项
                    InputStream inputStream = item.getInputStream();
                    String realPath = getServletContext().getRealPath("/products");
                    String dir = UploadUtils.getDir(newFileName);
                    String path = realPath + dir;
                    //内存中生命一个目录
                    File newDir = new File(path);
                    if(!newDir.exists()){
                        newDir.mkdirs();
                    }
                    File finalFile = new File(newDir, newFileName);
                    if(!finalFile.exists()){
                        finalFile.createNewFile();
                    }
                    //建立输出流
                    OutputStream os = new FileOutputStream(finalFile);
                    IOUtils.copy(inputStream, os);
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(os);

                    map.put("pimage", "/products" + dir + "/" + finalFile.getName());
                }
            }

            BeanUtils.populate(product,map);
            product.setPid(UUIDUtils.getId());
            product.setPdate(new Date());
            product.setPflag(0);

            ProductService productService = new ProductServiceImp();
            productService.saveProduct(product);

            resp.sendRedirect("/store/AdminProductServlet?method=findAllProductsWithPage&num=1");
        } catch (Exception e) {

        }
        return null;
    }

}
