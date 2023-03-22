package com.example.sp23_n5_quanlybaiguixemayhappy;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.sp23_n5_quanlybaiguixemayhappy.DoiMatKhau.TaiKhoanFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainChinh  extends AppCompatActivity {
    Toolbar toolbar;
    FragmentTransaction ft;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager =getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.nav_QR:
                    DisplayPage("QR");
                    return true;
                case R.id.nav_QLGX:
                    DisplayPage("QLGX");
                    return true;
                case R.id.nav_Thongke:
                    DisplayPage("Thống Kê");
                    return true;
                case R.id.nav_Taikhoan:
                    TaiKhoanFragment changeFragment = new TaiKhoanFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.content_frame,changeFragment)
                            .commit();
            }
            return false;
        }
    };
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            BottomNavigationView navView = findViewById(R.id.nav_view);
            navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            toolbar = findViewById(R.id.toolbar1);
            setSupportActionBar(toolbar);
            toolbar.setTitle("Navigation Sample");

            DisplayPage("QR");
        }

       private void DisplayPage(String page) {
//            Fragment fragment = null;
//            try {
//                switch (page) {
//                    case "quanlyguixe":
//                        fragment = new quanlyguixe();
//                        break;
//                    case "taikhoan":
//                        fragment = new taikhoan();
//                        break;
//                    case "thongke":
//                        fragment = new thongke();
//                        break;
//                    case "home_qr":
//                        fragment = new home_qr();
//                        break;
//                }
//
//            if (fragment != null) {
//                toolbar.setTitle(page.substring(0, 1) + page.substring(1));
//                ft = getSupportFragmentManager().beginTransaction();
//                ft.add(R.id.content_frame, fragment);
//                ft.commit();
//            }
//
//        } catch (Exception ex) {
//        Toast.makeText(MainActivity.this, ex.getMessage().toString(), Toast.LENGTH_LONG).show();
//    }
//
}

}

