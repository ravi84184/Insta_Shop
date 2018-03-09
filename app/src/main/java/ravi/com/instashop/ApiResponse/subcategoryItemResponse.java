package ravi.com.instashop.ApiResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ravi.com.instashop.model.SubcatItemModel;
import ravi.com.instashop.model.SubcatModel;

/**
 * Created by Parth on 23-Feb-18.
 */

public class subcategoryItemResponse {


    @SerializedName("status")
    private int status;
    @SerializedName("products")
    private List<SubcatItemModel> products;

    public subcategoryItemResponse(int status, List<SubcatItemModel> products) {
        this.status = status;
        this.products = products;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<SubcatItemModel> getProducts() {
        return products;
    }

    public void setProducts(List<SubcatItemModel> products) {
        this.products = products;
    }
}