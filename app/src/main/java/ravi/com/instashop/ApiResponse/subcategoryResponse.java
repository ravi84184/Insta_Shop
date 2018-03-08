package ravi.com.instashop.ApiResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ravi.com.instashop.model.SubcatModel;
import ravi.com.instashop.model.catModel;

/**
 * Created by Parth on 23-Feb-18.
 */

public class subcategoryResponse {


    @SerializedName("status")
    private int status;
    @SerializedName("sub_categories")
    private List<SubcatModel> sub_categories;

    public subcategoryResponse(int status, List<SubcatModel> sub_categories) {
        this.status = status;
        this.sub_categories = sub_categories;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<SubcatModel> getSub_categories() {
        return sub_categories;
    }

    public void setSub_categories(List<SubcatModel> sub_categories) {
        this.sub_categories = sub_categories;
    }
}