package ravi.com.instashop.DatabseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import ravi.com.instashop.activity.SubcatActivity;

/**
 * Created by obaro on 02/04/2015.
 */
public class ExampleDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "ExampleDBHelper";
    public static final String DATABASE_NAME = "Cart.db";
    private static final int DATABASE_VERSION = 1;

    public static final String CART_TABLE_NAME = "cart_master";
    public static final String CART_COLUMN_CART_ID = "_id";
    public static final String CART_COLUMN_PID = "p_id";
    public static final String CART_COLUMN_PNAME = "p_name";
    public static final String CART_COLUMN_PPRICE = "p_price";
    public static final String CART_COLUMN_PQNTY = "p_qnty";
    public static final String CART_COLUMN_PTOTAL = "p_total";
    public static final String CART_COLUMN_PIMG = "p_image";

    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;

    public ExampleDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + CART_TABLE_NAME +
                        "(" + CART_COLUMN_CART_ID + " INTEGER PRIMARY KEY, " +
                        CART_COLUMN_PID + " TEXT, " +
                        CART_COLUMN_PNAME + " TEXT, " +
                        CART_COLUMN_PPRICE + " TEXT, " +
                        CART_COLUMN_PQNTY + " INTEGER, " +
                        CART_COLUMN_PTOTAL + " FLOAT(8,4)," +
                        CART_COLUMN_PIMG + " TEXT );"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CART_TABLE_NAME);
        onCreate(db);
    }
    public int totleamount(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM(" + CART_COLUMN_PTOTAL + ") as Total FROM " + CART_TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            int total = cursor.getInt(cursor.getColumnIndex("Total"));
            return total;
        }
        return 0;
    }

    public int insertCart(String Pid ,String Pname, String Pprice, int Pqnty,String Pimage) {

        float Ppricefloat = Float.parseFloat(Pprice);
        Log.e("", "insertCart: " +Pprice );
        float total = Pqnty * Ppricefloat;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CART_COLUMN_PID, Pid);
        contentValues.put(CART_COLUMN_PNAME, Pname);
        contentValues.put(CART_COLUMN_PPRICE, Pprice);
        contentValues.put(CART_COLUMN_PQNTY, Pqnty);
        contentValues.put(CART_COLUMN_PTOTAL, total);
        contentValues.put(CART_COLUMN_PIMG, Pimage);
        //delete for 1,update for cartQ,insert 0,error 200
        Cursor cur = getProduct(Pid);
        if (cur.moveToNext()) {
            int cartQ = cur.getInt(4);

            if (cartQ > 0) {
                if (Pqnty == 0) {
                   // deleteFromCart(Pid);
                    Log.d("###", "Remove from cart due to 0");
                    return 1;
                } else {
                    cartQ++;
                    updateCart(Pid, Ppricefloat, cartQ);
                    Log.d("###", "Update Cart due to repeted item with qnty ->" + cartQ);
                    return cartQ;
                }
            }
        } else {
            db.insert(CART_TABLE_NAME, null, contentValues);
            Log.d("###", "Inserted ");
            return 0;
        }
        cur.close();
        db.close();
        return 200;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CART_TABLE_NAME);
        return numRows;
    }

    public boolean updateCart(String Pid, float Pprice, int Pqnty) {

        float total = Pqnty * Pprice;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CART_COLUMN_PPRICE, Pprice);
        contentValues.put(CART_COLUMN_PQNTY, Pqnty);
        contentValues.put(CART_COLUMN_PTOTAL, total);

        db.update(CART_TABLE_NAME, contentValues, CART_COLUMN_PID + " = ? ", new String[]{Pid});
        return true;
    }

    public Integer deleteFromCart(String Pid) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = getProduct(Pid);
        if (cur.moveToNext()) {
            int Q = cur.getInt(4) - 1;
            Log.e(TAG, "deleteFromCart: Q " +Q );
            Log.e(TAG, "deleteFromCart: p " +Pid );
            float P = cur.getFloat(3);
            if (Q >= 1) {
                updateCart(Pid, P, Q);
                Log.d("###", "Update from cart due to > 0" + Q);
                return Q;
            } else {
                int re = db.delete(CART_TABLE_NAME,
                        CART_COLUMN_PID + " = ? ",
                        new String[]{Pid});
                Log.d("###", "Delete from cart " + re);
                return 0;
            }
        }
        return 200;
    }


    public Cursor getProduct(String Pid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from cart_master where p_id = ?", new String[]{String.valueOf(Pid)});
        return res;
    }

    public Cursor getAllProduct() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + CART_TABLE_NAME, null);
        return res;
    }

    public void EmptyTabel() {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(CART_TABLE_NAME, null, null);
    }
}