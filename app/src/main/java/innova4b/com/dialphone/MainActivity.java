package innova4b.com.dialphone;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialPhone(View view) {
        if (checkPermission("android.permission.CALL_PHONE")) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:0034620775220"));
            startActivity(intent);
        }
    }

    private boolean checkPermission(String permission) {
        int permisionCheck = ContextCompat.checkSelfPermission(this, permission);
        return (permisionCheck == PackageManager.PERMISSION_GRANTED);
    }
}
