package com.xyd.lametest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.xyd.lametest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'lametest' library on application startup.
    static {
        System.loadLibrary("lametest");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(getLameVersion());
    }

    /**
     * A native method that is implemented by the 'lametest' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String getLameVersion();
}