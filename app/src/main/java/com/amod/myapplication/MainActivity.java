package com.amod.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {
    Button button_work;
    TextView textView_result;
public  static final String KEY_TASK_DATA="Key_data";
    public  static final String KEY_TASK_OUTPUT="Key_data_output";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data data=new Data.Builder().putString(KEY_TASK_DATA,"I am sending data").build();
        final OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(AmodWorker.class)
                .setInputData(data).build();
        button_work = (Button) findViewById(R.id.button_work);
        textView_result = (TextView) findViewById(R.id.textView_result);
        button_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkManager.getInstance(getApplicationContext()).enqueue(oneTimeWorkRequest);
            }
        });

        WorkManager.getInstance(getApplicationContext()).getWorkInfoByIdLiveData(oneTimeWorkRequest.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        textView_result.setText(workInfo.getState().name());
                    }
                });

    }
}
