package com.example.ContentProviderTutorial;

import android.app.Activity;
import android.os.Bundle;

public class MyActivity extends Activity {
  private MyDatabaseHelper mDatabaseHelper;

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mDatabaseHelper = new MyDatabaseHelper(this);
  }
}