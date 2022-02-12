package mirim.msg.sora_godong;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

//db와 관련된 작업을 하는 클래스
public class DbHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "calendar_db";

    private Context context;
    private static final String TODAY_DATE = "today_date";
    private static final String QUESTION = "question";
    private static final String TODAY_DIARY = "today_diary";


    //생성자
    public DbHelper(@Nullable Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

/*
    public void insert(Character today_date, String question, String today_diary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TODAY_DATE, String.valueOf(today_date));
        cv.put(QUESTION, question);
        cv.put(TODAY_DIARY,today_diary);
        long result = db.insert(DATABASE_NAME,null, cv);

        if (result == -1)
        {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "데이터 추가 성공", Toast.LENGTH_SHORT).show();
        }
    }
*/
    //table 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE calendar(today_date VARCHAR(20) NOT NULL, question TEXT NOT NULL, today_diary TEXT, PRIMARY KEY(today_date))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS calendar");
        onCreate(db);
    }
}
