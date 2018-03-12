package ravi.com.instashop.DatabseHelper;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DB_VERSION = 1;

    private static final String DB_NAME = "cart.db";

    private static final String TABLE_NAME = "my_cart";

    ArrayList<String> ID_ArrayList = new ArrayList<String>();
    ArrayList<String> DAIRY_NAME_ArrayList = new ArrayList<String>();
    ArrayList<String> DAIRY_DATE_ArrayList = new ArrayList<String>();
    ArrayList<String> NOTES = new ArrayList<String>();

    private static final String COLUMN_CARTID = "cart_id";
    private static final String COLUMN_PRODUCT_ID = "product_id";
    private static final String COLUMN_PRODUCT_PRICE = "product_price";
    private static final String COLUMN_PRODUCT_QNTY = "prooduct_qnty";


    String crt_tbl = "CREATE TABLE if not exists " + TABLE_NAME + " ( "
            + COLUMN_CARTID + " INTEGER PRIMARY KEY, " + COLUMN_PRODUCT_ID + " TEXT," + COLUMN_PRODUCT_PRICE + " TEXT," + COLUMN_PRODUCT_QNTY + " TEXT" + ");";

    private Cursor cursor;

    private String query;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        // TODO Auto-generated constructor stub


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(crt_tbl);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);


    }

    public int noOfRecord(){

        SQLiteDatabase db = this.getWritableDatabase();
        return  db.rawQuery("SELECT * FROM " +TABLE_NAME, null).getCount();

    }

    public void Insert(String PId, String price, String qnty) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_PRODUCT_ID, PId);
        values.put(COLUMN_PRODUCT_PRICE, price);
        values.put(COLUMN_PRODUCT_QNTY, qnty);

        db.insert(TABLE_NAME, null, values);

        db.close();

    }

    public void Edit(String PId, String price, String qnty) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_PRICE, price);
        values.put(COLUMN_PRODUCT_QNTY, qnty);
        db.update(TABLE_NAME, values, COLUMN_PRODUCT_ID + "= " + PId, null);
        db.close();

    }


    public int Delete(String PId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        db.delete(TABLE_NAME, COLUMN_PRODUCT_ID + "= " + PId, null);
        db.close();
        return 0;
    }
}
