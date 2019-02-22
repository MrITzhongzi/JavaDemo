package cn.wl.store.web.servlet;

import cn.wl.store.domain.Cart;
import cn.wl.store.domain.CartItem;
import cn.wl.store.domain.Product;
import cn.wl.store.service.ProductService;
import cn.wl.store.service.serviceImp.ProductServiceImp;
import cn.wl.store.web.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

public class CartServlet extends BaseServlet {
    // 添加购物项 到购物车
    public String addCartItemToCart(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (null == cart) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        String pid = req.getParameter("pid");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        ProductService productService = new ProductServiceImp();
        Product product = productService.findProductByPid(pid);
        CartItem cartItem = new CartItem();
        cartItem.setNum(quantity);
        cartItem.setProduct(product);
        cart.addCartItemToCart(cartItem);
        req.getSession().setAttribute("cart", cart);
        resp.sendRedirect("/jsp/cart.jsp");
        return null;
    }

    public String removeCartItem (HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        String pid = req.getParameter("pid");
        cart.removeCartItem(pid);
        resp.sendRedirect("/jsp/cart.jsp");
        return null;
    }

    public String clearCart (HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clearCart();
        resp.sendRedirect("/jsp/cart.jsp");
        return null;
    }

}
