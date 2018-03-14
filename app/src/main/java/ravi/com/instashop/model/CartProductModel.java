package ravi.com.instashop.model;

/**
 * Created by nikpatel on 14/03/18.
 */

public class CartProductModel {

    String cart_id,p_id,p_name,p_q,p_image;
    int p_price,p_total;
    public CartProductModel() {
    }

    public CartProductModel(String cart_id, String p_id, String p_name, String p_q, String p_image, int p_price, int p_total) {
        this.cart_id = cart_id;
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_q = p_q;
        this.p_image = p_image;
        this.p_price = p_price;
        this.p_total = p_total;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_q() {
        return p_q;
    }

    public void setP_q(String p_q) {
        this.p_q = p_q;
    }

    public String getP_image() {
        return p_image;
    }

    public void setP_image(String p_image) {
        this.p_image = p_image;
    }

    public int getP_price() {
        return p_price;
    }

    public void setP_price(int p_price) {
        this.p_price = p_price;
    }

    public int getP_total() {
        return p_total;
    }

    public void setP_total(int p_total) {
        this.p_total = p_total;
    }
}
