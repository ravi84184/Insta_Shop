package ravi.com.instashop.interfaces;


import ravi.com.instashop.ApiResponse.categoryResponse;
import ravi.com.instashop.ApiResponse.loginResponse;
import ravi.com.instashop.ApiResponse.msgResponse;
import ravi.com.instashop.ApiResponse.registerResponse;
import ravi.com.instashop.ApiResponse.subcategoryResponse;
import ravi.com.instashop.ApiResponse.updateProfileReasponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by android on 21/2/18.
 */

public interface ApiInterface {


    @FormUrlEncoded
    @POST("api.php")
    Call<categoryResponse> category
            (@Field("categories") String category);


    @FormUrlEncoded
    @POST("api.php")
    Call<subcategoryResponse> subcategory
            (@Field("category_id") String category_id);


    // Method for Register User

//    @FormUrlEncoded
//    @POST("mobileController.php")
//    Call<registerResponse> registerUser
//            (@Field("full_name") String full_name,
//             @Field("c_email") String c_email,
//             @Field("c_mobile") String c_mobile,
//             @Field("c_password") String c_password,
//             @Field("c_address1") String c_address1,
//             @Field("c_address2") String c_address2);
//
//    @FormUrlEncoded
//    @POST("mobileController.php")
//    Call<updateProfileReasponse> updateUser
//            (@Field("full_name_update") String full_name_update,
//             @Field("customer_id") String customer_id,
//             @Field("c_email") String c_email,
//             @Field("c_mobile") String c_mobile,
//             @Field("c_address1") String c_address1,
//             @Field("c_address2") String c_address2);
//
//    @FormUrlEncoded
//    @POST("mobileController.php")
//    Call<msgResponse> changePassword(
//            @Field("customer_id") String customer_id,
//            @Field("old_password") String oldPassword,
//            @Field("password") String newPassword);

}
