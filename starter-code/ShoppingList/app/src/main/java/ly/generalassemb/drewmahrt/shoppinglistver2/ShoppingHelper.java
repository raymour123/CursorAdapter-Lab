package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*** Created by raymour on 7/12/16.
 */
public class ShoppingHelper extends SQLiteOpenHelper {

    private static ShoppingHelper instance;

    private static final int DATABASE_VERSION = 7;
    public static final String DATABASE_NAME = "SHOPPING_DB";
    public static final String EXAMPLE_LIST_TABLE_NAME = "SHOPPING_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_ITEM_DESCRIPTION = "DESCRIPTION";
    public static final String COL_ITEM_PRICE = "PRICE";
    public static final String COL_ITEM_TYPE = "TYPE";

    public static final String[] EXAMPLE_COLUMNS = {COL_ID,COL_ITEM_NAME, COL_ITEM_DESCRIPTION, COL_ITEM_PRICE, COL_ITEM_TYPE};

    private static final String CREATE_EXAMPLE_LIST_TABLE = "CREATE TABLE " + EXAMPLE_LIST_TABLE_NAME+ "(" +
            COL_ID + "INTEGER PRIMARY KEY, " +
            COL_ITEM_NAME + " TEXT" +
            COL_ITEM_DESCRIPTION + "TEXT" +
            COL_ITEM_PRICE + "TEXT" +
            COL_ITEM_TYPE + "TEXT )";

    public static ShoppingHelper getInstance(Context context){
        if (instance == null) {
            instance = new ShoppingHelper(context);
        }
        return instance;
     }

    private ShoppingHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { sqLiteDatabase.execSQL(CREATE_EXAMPLE_LIST_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + EXAMPLE_LIST_TABLE_NAME);
        this.onCreate(sqLiteDatabase);

    }

    public Cursor getShoppingList(){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(EXAMPLE_LIST_TABLE_NAME, EXAMPLE_COLUMNS, null, null, null, null, null, null);
        return cursor;
    }
}
