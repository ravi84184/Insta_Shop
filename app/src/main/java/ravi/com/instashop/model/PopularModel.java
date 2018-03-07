package ravi.com.instashop.model;

/**
 * Created by nikpatel on 07/03/18.
 */

public class PopularModel {

    private String lan;
    private int img;

    public PopularModel(String lan, int img) {
        this.lan = lan;
        this.img = img;
    }


    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
