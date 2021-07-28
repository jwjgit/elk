package com.example.elk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.elk.ferris_wheel.SampleKotlinActivity;
import com.royrodriguez.transitionbutton.TransitionButton;

public class Login extends AppCompatActivity {
        private TransitionButton transitionButton;
        private EditText et_account,et_password;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            transitionButton = findViewById(R.id.transition_button);
            et_account=findViewById(R.id.editText);
            et_password=findViewById(R.id.editText2);
            et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());

            transitionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start the loading animation when the user tap the button
                    transitionButton.startAnimation();

                    // Do your networking task or background work here.
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            boolean isSuccessful = false;
                            if(et_account.getText().toString().equals("jwjailjy")&&et_password.getText().toString().equals("20190523")){
                                isSuccessful=true;
                            }


                            // Choose a stop animation if your call was succesful or not
                            if (isSuccessful) {
                                transitionButton.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                                    @Override
                                    public void onAnimationStopEnd() {
                                        //Intent intent = new Intent(getBaseContext(), SampleKotlinActivity.class);
                                        Intent intent = new Intent(getBaseContext(),MainActivity .class);
                                        intent.putExtra("login","login");
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                        startActivity(intent);
                                    }
                                });
                            } else {
                                transitionButton.stopAnimation(TransitionButton.StopAnimationStyle.SHAKE, null);
                                if (!et_account.getText().toString().equals("jwjailjy")) {
                                    Toast.makeText(Login.this, "love", Toast.LENGTH_LONG).show();

                                }
                                if (!et_password.getText().toString().equals("20190523")) {
                                    Toast.makeText(Login.this, "重要的日子都记错了，生气！！！", Toast.LENGTH_LONG).show();

                                }
                            }
                        }
                    }, 2000);
                }
            });
        }



    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {


            try{
                String statu=getIntent().getStringExtra("start");
                if(statu.equals("start")){

                }
            }catch (Exception e){

            }


            return   true;

        }

        return  super.onKeyDown(keyCode, event);

    }
}
