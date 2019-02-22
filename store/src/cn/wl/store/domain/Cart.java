package cn.wl.store.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
    private double total; // 总计（积分）
    private List<CartItem> list = new ArrayList<>();


    public double getTotal() {
        double total = 0;
        for (CartItem cartItem : list) {
            total += cartItem.getProduct().getShop_price() * cartItem.getNum();
        }
        return total;
    }

    public List<CartItem> getList() {
        return list;
    }

    public void clearCart() {
        list.clear();
    }

    public void removeCartItem(String pid) {
        Iterator<CartItem> iterator = list.iterator();
        while (iterator.hasNext()) {
            CartItem cartItem = iterator.next();
            if (cartItem.getProduct().getPid().equals(pid)) {
                iterator.remove();
            }
        }
    }

    public void addCartItemToCart(CartItem cartItem) {
//        getTotal();
        boolean flag = false;
        for (CartItem ci : list) {
            if (ci.getProduct().getPid().equals(cartItem.getProduct().getPid())) {
                flag = true;
                ci.setNum(ci.getNum() + cartItem.getNum());
            }
        }
        if (!flag) {
            list.add(cartItem);
        }
    }
}
