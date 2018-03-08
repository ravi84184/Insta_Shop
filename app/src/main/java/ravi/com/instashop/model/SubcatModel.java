package ravi.com.instashop.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nikpatel on 08/03/18.
 */

public class SubcatModel {
    @SerializedName("category_id")
    String category_id;
    @SerializedName("sub_category_name")
    String sub_category_name;
    @SerializedName("sub_category_id")
    String sub_category_id;

    public SubcatModel() {
    }

    public SubcatModel(String category_id, String sub_category_name, String sub_category_id) {
        this.category_id = category_id;
        this.sub_category_name = sub_category_name;
        this.sub_category_id = sub_category_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSub_category_name() {
        return sub_category_name;
    }

    public void setSub_category_name(String sub_category_name) {
        this.sub_category_name = sub_category_name;
    }

    public String getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(String sub_category_id) {
        this.sub_category_id = sub_category_id;
    }
}
