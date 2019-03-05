package com.example.game;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlaygameActivity extends AppCompatActivity {
    private int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgame);
        new alterPic().execute();
        //set font
        TextView text=(TextView)findViewById(R.id.hint);

        Typeface typeFace = Typeface.createFromAsset(getAssets(),"fonts/font_one.TTF");
        text.setTypeface(typeFace);
    }



    public void clickPic1(View v){
        String picTag=v.getTag().toString();
        String hintTag=((TextView) findViewById(R.id.hint)).getTag().toString();
        if (picTag==hintTag) {
            score++;
            ((TextView) findViewById(R.id.score)).setText(String.valueOf(score));
            new alterPic().execute();
        }
        else
        {
            Intent intent = new Intent();
            intent.setClass(PlaygameActivity.this, DeadActivity.class);
            intent.putExtra("score",String.valueOf(score));
            this.finish();
            startActivity(intent);
        }
    }
    public void clickPic2(View v){
        String picTag=v.getTag().toString();
        String hintTag=((TextView) findViewById(R.id.hint)).getTag().toString();
        if (picTag==hintTag){
            score++;
            ((TextView) findViewById(R.id.score)).setText(String.valueOf(score));
            new alterPic().execute();
        }
        else
        {
            Intent intent = new Intent();
            intent.setClass(PlaygameActivity.this, DeadActivity.class);
            intent.putExtra("score",String.valueOf(score));
            this.finish();
            startActivity(intent);
        }
    }
    public void clickPic3(View v){
        String picTag=v.getTag().toString();
        String hintTag=((TextView) findViewById(R.id.hint)).getTag().toString();
        if (picTag==hintTag){
            score++;
            ((TextView) findViewById(R.id.score)).setText(String.valueOf(score));
            new alterPic().execute();
        }
        else
        {
            Intent intent = new Intent();
            intent.setClass(PlaygameActivity.this, DeadActivity.class);
            intent.putExtra("score",String.valueOf(score));
            this.finish();
            startActivity(intent);        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        new alterPic().execute();
        //set font
        TextView text=(TextView)findViewById(R.id.hint);

        Typeface typeFace = Typeface.createFromAsset(getAssets(),"fonts/font_one.TTF");
        text.setTypeface(typeFace);
    }

    public void clickPic4(View v){
        String picTag=v.getTag().toString();
        String hintTag=((TextView) findViewById(R.id.hint)).getTag().toString();
        if (picTag==hintTag){
            score++;
            ((TextView) findViewById(R.id.score)).setText(String.valueOf(score));
            new alterPic().execute();
        }
        else
        {
            Intent intent = new Intent();
            intent.setClass(PlaygameActivity.this, DeadActivity.class);
            intent.putExtra("score",String.valueOf(score));
            this.finish();
            startActivity(intent);
        }
    }


    private class alterPic extends AsyncTask<String, Void, String> {
        private ImageView imageView1=findViewById(R.id.imageView1);
        private ImageView imageView2=findViewById(R.id.imageView2);
        private ImageView imageView3=findViewById(R.id.imageView3);
        private ImageView imageView4=findViewById(R.id.imageView4);
        protected String[] picList = {"bear", "bird", "cat", "elephant", "fish", "flower", "giraff", "honey", "house", "hypo", "kangaroo", "leo", "lion", "pig", "rhino", "sun", "tiger", "wolf"};
        protected int[] images={R.drawable.bear,
                R.drawable.bird,
                R.drawable.cat,
                R.drawable.elephant,
                R.drawable.fish,
                R.drawable.flower,
                R.drawable.giraffe,
                R.drawable.honey,
                R.drawable.house,
                R.drawable.hypo,
                R.drawable.kangaroo,
                R.drawable.leo,
                R.drawable.lion,
                R.drawable.pig,
                R.drawable.rhino,
                R.drawable.sun,
                R.drawable.tiger,
                R.drawable.wolf};
        @Override
        protected String doInBackground(String ...params) {
            int index[] = randomCommon(0, picList.length - 1, 4);
            changePic(index,picList);
            changeHint(picList,index);
            return index.toString();

        }

        private int[] randomCommon(int min, int max, int n) {
            if (n > (max - min + 1) || max < min) {
                return null;
            }
            int[] result = new int[n];
            int count = 0;
            while (count < n) {
                int num = (int) (Math.random() * (max - min)) + min;
                boolean flag = true;
                for (int j = 0; j < n; j++) {
                    if (num == result[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result[count] = num;
                    count++;
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(String source) {
            //Toast.makeText(getApplicationContext(), source, Toast.LENGTH_SHORT).show();

        }

        private void changePic(int [] index,String [] picList){
            imageView1.setImageResource(images[index[0]]);
            imageView1.setTag(picList[index[0]]);
            imageView2.setImageResource(images[index[1]]);
            imageView2.setTag(picList[index[1]]);
            imageView3.setImageResource(images[index[2]]);
            imageView3.setTag(picList[index[2]]);
            imageView4.setImageResource(images[index[3]]);
            imageView4.setTag(picList[index[3]]);
        }
        private void changeHint(String[] nameList,int []index){
            int hintIndex = (int) (Math.random() * 10 )%4;
            ((TextView) findViewById(R.id.hint)).setText(nameList[index[hintIndex]]);
            ((TextView) findViewById(R.id.hint)).setTag(nameList[index[hintIndex]]);
        }

    }


}
