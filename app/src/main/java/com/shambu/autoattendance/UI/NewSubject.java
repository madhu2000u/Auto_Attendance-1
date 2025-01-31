package com.shambu.autoattendance.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.textfield.TextInputEditText;
import com.shambu.autoattendance.AutoAttendanceData;
import com.shambu.autoattendance.DataClasses.SubjectPojo;
import com.shambu.autoattendance.DataClasses.SubjectSchedulePojo;
import com.shambu.autoattendance.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewSubject extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.subcode_edt)
    TextInputEditText subCode;
    @BindView(R.id.subName_edt)
    TextInputEditText subName;
    @BindView(R.id.profName_edt)
    TextInputEditText profName;
    @BindView(R.id.minper_edt)
    TextInputEditText subMinPercentage;

    @BindView(R.id.add_button)
    Button addButton;

    @BindView(R.id.mon_chk)
    CheckBox mon;
    @BindView(R.id.tue_chk)
    CheckBox tue;
    @BindView(R.id.wed_chk)
    CheckBox wed;
    @BindView(R.id.thur_chk)
    CheckBox thur;
    @BindView(R.id.fri_chk)
    CheckBox fri;
    @BindView(R.id.sat_chk)
    CheckBox sat;
    @BindView(R.id.sun_chk)
    CheckBox sun;

    @BindView(R.id.mon_from)
    TextView fmon;
    @BindView(R.id.tue_from)
    TextView ftue;
    @BindView(R.id.wed_from)
    TextView fwed;
    @BindView(R.id.thur_from)
    TextView fthur;
    @BindView(R.id.fri_from)
    TextView ffri;
    @BindView(R.id.sat_from)
    TextView fsat;
    @BindView(R.id.sun_from)
    TextView fsun;
    @BindView(R.id.mon_to)
    TextView tmon;
    @BindView(R.id.tue_to)
    TextView ttue;
    @BindView(R.id.wed_to)
    TextView twed;
    @BindView(R.id.thur_to)
    TextView tthur;
    @BindView(R.id.fri_to)
    TextView tfri;
    @BindView(R.id.sat_to)
    TextView tsat;
    @BindView(R.id.sun_to)
    TextView tsun;

    private static final String TAG = "NewSubject";
    private int mHour, mMin;
    private List<SubjectSchedulePojo> subSchedule;
    private SubjectPojo subjectData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_subject);
        ButterKnife.bind(this);

        fmon.setOnClickListener(this);
        tmon.setOnClickListener(this);
        ftue.setOnClickListener(this);
        ttue.setOnClickListener(this);
        fwed.setOnClickListener(this);
        twed.setOnClickListener(this);
        fthur.setOnClickListener(this);
        tthur.setOnClickListener(this);
        ffri.setOnClickListener(this);
        tfri.setOnClickListener(this);
        fsat.setOnClickListener(this);
        tsat.setOnClickListener(this);
        fsun.setOnClickListener(this);
        tsun.setOnClickListener(this);

        subSchedule = new ArrayList<>();

    }

    @Override
    public void onClick(View view) {
        TextView v = (TextView) view;
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int min) {
                if(hour/10 == 0){
                    if(min/10 == 0){
                        v.setText("0"+hour + ":0" + min);
                    }
                    else{
                        v.setText("0"+hour + ":" + min);
                    }
                }
                else {
                    if(min/10 == 0){
                        v.setText(hour + ":0" + min);
                    }
                    else{
                        v.setText(hour + ":" + min);
                    }
                }
            }
        }, mHour, mMin, true);
        timePickerDialog.show();
    }

    @OnClick(R.id.add_button)
    void saveSubject() {
        String firstTime = "";
        if (mon.isChecked()) {
            SubjectSchedulePojo ss = new SubjectSchedulePojo(subCode.getText().toString(),2,
                    getH(fmon), getM(fmon), getH(tmon), getM(tmon));
  //          firstTime = firstTimeFinder(firstTime, fmon);
            subSchedule.add(ss);
        }
        if (tue.isChecked()) {
            SubjectSchedulePojo ss = new SubjectSchedulePojo(subCode.getText().toString(),3,
                    getH(ftue), getM(ftue), getH(ttue), getM(ttue));
    //        firstTime = firstTimeFinder(firstTime, ftue);
            subSchedule.add(ss);
        }
        if (wed.isChecked()) {
            SubjectSchedulePojo ss = new SubjectSchedulePojo(subCode.getText().toString(),4,
                    getH(fwed), getM(fwed), getH(twed), getM(twed));
      //      firstTime = firstTimeFinder(firstTime, fwed);
            subSchedule.add(ss);
        }
        if (thur.isChecked()) {
            SubjectSchedulePojo ss = new SubjectSchedulePojo(subCode.getText().toString(),5,
                    getH(fthur), getM(fthur), getH(tthur), getM(tthur));
        //    firstTime = firstTimeFinder(firstTime, fthur);
            subSchedule.add(ss);
        }
        if (fri.isChecked()) {
            SubjectSchedulePojo ss = new SubjectSchedulePojo(subCode.getText().toString(),6,
                    getH(ffri), getM(ffri), getH(tfri), getM(tfri));
          //  firstTime = firstTimeFinder(firstTime, ffri);
            subSchedule.add(ss);
        }
        if (sat.isChecked()) {
            SubjectSchedulePojo ss = new SubjectSchedulePojo(subCode.getText().toString(),7,
                    getH(fsat), getM(fsat), getH(tsat), getM(tsat));
            //firstTime = firstTimeFinder(firstTime, fsat);
            subSchedule.add(ss);
        }
        if (sun.isChecked()) {
            SubjectSchedulePojo ss = new SubjectSchedulePojo(subCode.getText().toString(),1,
                    getH(fsun), getM(fsun), getH(tsun), getM(tsun));
            //firstTime = firstTimeFinder(firstTime, fsun);
            subSchedule.add(ss);
        }

  /*      SharedPreferences preferences = getApplicationContext().getSharedPreferences("AutoAtt", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("TimetableStartsAt", firstTimeFinderSS(firstTime,
                preferences.getString("TimetableStartsAt","")));
        editor.commit();  */

        subjectData = new SubjectPojo(Integer.parseInt(subMinPercentage.getText().toString()),
                subCode.getText().toString(), subName.getText().toString(), profName.getText().toString(), subSchedule);

        AutoAttendanceData sqlTable = new AutoAttendanceData(NewSubject.this);
        sqlTable.addNewSubtoSQL(subjectData);
        setResult(Activity.RESULT_OK);
        finish();
    }

  /*  private String firstTimeFinderSS(String sh, String tv){
        int fH, fM, shH, shM;
        fH = Character.getNumericValue(tv.charAt(0))*10 +
                Character.getNumericValue(tv.charAt(1))*1;
        fM = Character.getNumericValue(tv.charAt(3))*10 +
                Character.getNumericValue(tv.charAt(4))*1;
        if(!sh.equals("") && !tv.equals("")){
            shH = Character.getNumericValue(sh.charAt(0))*10 +
                    Character.getNumericValue(sh.charAt(1))*1;
            shM = Character.getNumericValue(sh.charAt(3))*10 +
                    Character.getNumericValue(sh.charAt(4))*1;

            if(shH>fH || (shH==fH && shM>fM)){
                if(fH/10 == 0){
                    if(fM/10 == 0){
                        sh = "0"+fH + ":0" + fM;
                    }
                    else{
                        sh = "0"+fH + ":" + fM;
                    }
                }
                else {
                    if(fM/10 == 0){
                        sh = fH + ":0" + fM;
                    }
                    else{
                        sh = fH + ":" + fM;
                    }
                }
            }
        } else {
            if(fH/10 == 0){
                if(fM/10 == 0){
                    sh = "0"+fH + ":0" + fM;
                }
                else{
                    sh = "0"+fH + ":" + fM;
                }
            }
            else {
                if(fM/10 == 0){
                    sh = fH + ":0" + fM;
                }
                else{
                    sh = fH + ":" + fM;
                }
            }
        }

        return sh;
    }

    private String firstTimeFinder(String sh, TextView tv){
        int fH, fM, shH, shM;
        fH = Character.getNumericValue(tv.getText().charAt(0))*10 +
                Character.getNumericValue(tv.getText().charAt(1))*1;
        fM = Character.getNumericValue(tv.getText().charAt(3))*10 +
                Character.getNumericValue(tv.getText().charAt(4))*1;
        if(!sh.equals("")){
            shH = Character.getNumericValue(sh.charAt(0))*10 +
                    Character.getNumericValue(sh.charAt(1))*1;
            shM = Character.getNumericValue(sh.charAt(3))*10 +
                    Character.getNumericValue(sh.charAt(4))*1;

            if(shH>fH || (shH==fH && shM>fM)){
                if(fH/10 == 0){
                    if(fM/10 == 0){
                        sh = "0"+fH + ":0" + fM;
                    }
                    else{
                        sh = "0"+fH + ":" + fM;
                    }
                }
                else {
                    if(fM/10 == 0){
                        sh = fH + ":0" + fM;
                    }
                    else{
                        sh = fH + ":" + fM;
                    }
                }
            }
        } else {
            if(fH/10 == 0){
                if(fM/10 == 0){
                    sh = "0"+fH + ":0" + fM;
                }
                else{
                    sh = "0"+fH + ":" + fM;
                }
            }
            else {
                if(fM/10 == 0){
                    sh = fH + ":0" + fM;
                }
                else{
                    sh = fH + ":" + fM;
                }
            }
        }

        return sh;
    }  */

    private int getH(TextView tv) {
        int h;
        String tvText = tv.getText().toString();
        Log.d(TAG, tvText);
        h = Integer.parseInt(String.valueOf(tvText.charAt(1))) * 1 + Integer.parseInt(String.valueOf(tvText.charAt(0))) * 10;

        return h;
    }

    private int getM(TextView tv) {
        int m;
        String tvText = tv.getText().toString();
        Log.d(TAG, tvText);
        m = Integer.parseInt(String.valueOf(tvText.charAt(4))) * 1 + Integer.parseInt(String.valueOf(tvText.charAt(3))) * 10;

        return m;
    }

}
