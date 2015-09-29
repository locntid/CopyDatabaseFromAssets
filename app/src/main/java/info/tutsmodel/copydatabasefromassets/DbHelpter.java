package info.tutsmodel.copydatabasefromassets;
/**
 * Created by locnt_000 on 9/29/2015.
 */
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DbHelpter {
	Context context;
	SQLiteDatabase db;
	public DbHelpter(Context context){
		this.context= context;
		AssetDatabaseOpenHelper assetDB =  new AssetDatabaseOpenHelper(context);
		db =  assetDB.StoreDatabase();
	}
	
	
	private ArrayList<String> getCities(String sql,String...selectionArgs){
		ArrayList<String> contents = new ArrayList<String>();
		
		// đọc từng cột từ database mới copy từ file assets vào như bình thường
		Cursor c = db.rawQuery(sql, selectionArgs);
		while(c.moveToNext()){
			contents.add(c.getString(0));
		}
		c.close();
		return contents;
	}
	public ArrayList<String> danhSach() {
		String sql = "select * from city ";
		return getCities(sql);
	}
}
	