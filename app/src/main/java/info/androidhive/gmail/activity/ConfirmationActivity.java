package info.androidhive.gmail.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alimuzaffar.lib.pin.PinEntryEditText;

import info.androidhive.gmail.R;
import info.androidhive.gmail.helper.Font;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        TextView myTextView = (TextView) findViewById(R.id.customer_name);
        Font.PROXIMA_NOVA.apply(this, myTextView);


        Font.PROXIMA_NOVA.apply(this, (TextView) findViewById(R.id.tvExchange));
        Font.PROXIMA_NOVA.apply(this, (TextView) findViewById(R.id.tvConfirmPassword));


        final PinEntryEditText pinEntry = (PinEntryEditText) findViewById(R.id.txt_pin_entry);
        if (pinEntry != null) {
            pinEntry.setInputType(InputType.TYPE_CLASS_NUMBER);

//            pinEntry.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() {
//                @Override
//                public void onPinEntered(CharSequence str) {
//                    Toast.makeText(ConfirmationActivity.this, "PIN: " + str, Toast.LENGTH_SHORT).show();
//                }
//            });

            pinEntry.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                            (i == KeyEvent.KEYCODE_ENTER)) {
                        Toast.makeText(ConfirmationActivity.this, "PIN: " + pinEntry.getText(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                    return false;
                }
            });
        }

        Button btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfirmationActivity.this, "PIN: " + pinEntry.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
