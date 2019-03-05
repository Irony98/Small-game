package com.example.game;

import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class DeadActivity extends AppCompatActivity {

    private DBHelper mHelper;
    private SQLiteDatabase mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead);
        mHelper = new DBHelper(this);
        mDatabase = mHelper.getWritableDatabase();
        //set font
        TextView text=(TextView)findViewById(R.id.btn_home);
        Typeface typeFace = Typeface.createFromAsset(getAssets(),"fonts/Elgethy Est Square.ttf");
        text.setTypeface(typeFace);
        text=(TextView)findViewById(R.id.text_dead);
        text.setTypeface(typeFace);
        text=(TextView)findViewById(R.id.text_gameover);
        text.setTypeface(typeFace);

        setScore();
        typeFace=Typeface.createFromAsset(getAssets(),"fonts/font_one.TTF");
        text=(TextView)findViewById(R.id.final_score);
        text.setTypeface(typeFace);
    }

    public void goHome(View view){
        Intent intent = new Intent();
        intent.setClass(DeadActivity.this, MainActivity.class);
        this.finish();
        startActivity(intent);
    }

    private void setScore(){
        Intent intent = getIntent();
        String score = intent.getStringExtra("score");
        ((TextView) findViewById(R.id.final_score)).setText(score);

    }

    // 表名
    // null。数据库如果插入的数据为null，会引起数据库不稳定。为了防止崩溃，需要传入第二个参数要求的对象
    // 如果插入的数据不为null，没有必要传入第二个参数避免崩溃，所以为null
    // 插入的数据
    private void insertData() {
        ContentValues values = new ContentValues();
        Intent intent = getIntent();
        String score = intent.getStringExtra("score");
        Calendar cal = Calendar.getInstance();
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mmmm-dddd hh:mm:ss");
        String cdate = sdf.format(cal.getTime());
        values.put(DBHelper.DATE, cdate);
        values.put(DBHelper.SCORE, score);
        mDatabase.insert(DBHelper.TABLE_NAME, null, values);
        Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
    }

    public class DBHelper extends SQLiteOpenHelper {
        // 数据库文件名
        public static final String DB_NAME = "my_database.db";
        // 数据库表名
        public static final String TABLE_NAME = "t_records";
        // 数据库版本号
        public static final int DB_VERSION = 1;
        public static final String DATE = "time";
        public static final String SCORE = "score";

        public DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            // 建表
            String sql = "create table " +
                    TABLE_NAME +
                    "(_id integer primary key autoincrement, " +
                    DATE + " varchar, " +
                    SCORE + " varchar"
                    + ")";

            db.execSQL(sql);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }


}
