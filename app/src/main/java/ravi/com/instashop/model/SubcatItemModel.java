package ravi.com.instashop.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nikpatel on 08/03/18.
 */

public class SubcatItemModel {
    @SerializedName("product_id")
    String product_id;
    @SerializedName("product_name")
    String product_name;
    @SerializedName("mrpPrice")
    String mrpPrice;
    @SerializedName("wholesalerPrice")
    String wholesalerPrice;
    @SerializedName("weightSize")
    String weightSize;
    @SerializedName("quantity")
    String quantity;

    @SerializedName("product_image")
    String product_image;

    public SubcatItemModel() {
    }

    public SubcatItemModel(String product_id, String product_name, String mrpPrice, String wholesalerPrice, String weightSize, String quantity, String product_image) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.mrpPrice = mrpPrice;
        this.wholesalerPrice = wholesalerPrice;
        this.weightSize = weightSize;
        this.quantity = quantity;
        this.product_image = product_image;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getMrpPrice() {
        return mrpPrice;
    }

    public void setMrpPrice(String mrpPrice) {
        this.mrpPrice = mrpPrice;
    }

    public String getWholesalerPrice() {
        return wholesalerPrice;
    }

    public void setWholesalerPrice(String wholesalerPrice) {
        this.wholesalerPrice = wholesalerPrice;
    }

    public String getWeightSize() {
        return weightSize;
    }

    public void setWeightSize(String weightSize) {
        this.weightSize = weightSize;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }
}



