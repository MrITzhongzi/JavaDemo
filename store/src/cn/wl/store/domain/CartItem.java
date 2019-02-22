package cn.wl.store.domain;

public class CartItem {
    private Product product; //携带 购物项 的三种参数
    private int num;
    private double subTotal;

    public CartItem() {
    }

    public CartItem(Product product, int num, double subTotal) {
        this.product = product;
        this.num = num;
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getSubTotal(){
        return product.getShop_price() * num;
    }
}
