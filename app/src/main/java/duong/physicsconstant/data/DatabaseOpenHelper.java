package duong.physicsconstant.data;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import duong.physicsconstant.MainActivity;

/**
 * Created by duong on 12/21/2016.
 */

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static  final String DATABASE_NAME = "PhysicsData.db";
    private static final int DATABASE_VERSION = 3;

    public DatabaseOpenHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade();
    }

    public Cursor getItem(String table){
        Cursor result;
        SQLiteDatabase database = getReadableDatabase();
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables(table);
        String[] projection = new String[]{"0 _id", "NAME", "VALUE"
        };
        result = sqLiteQueryBuilder.query(database,projection, null, null, null, null, null);
        result.moveToFirst();
        return result;
    }
}
