package com.example.kingofread;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private TextView tvEmpty;
    private ListView listBook;
    private String[] bookTitles;
    private String[] bookDescriptions;
    private Integer[] bookCovers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = new TextView(this);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("List of Books");

        bookTitles = new String[]{"cac cu co cau",
                                "co lam thi moi",
                                "co an",
                                "khong lam",
                                "ma doi co an"
                                , "lieu thi an nhieuuuuuuuuuu hsdjfsdhfjksksdfs dkfldj", "khong lieu", "thi an it", "can cu", "thi bu", "sieng nang"
                , "nguy hiem mot ti", "nhung trong", "tam", "kiem soat"};
        bookDescriptions = new String[]{"cac cu co cau", "co lam thi moi", "co an", "khong lam", "ma doi co an"
                , "lieu thi an nhieu ok jdhwjk kdsj osfji lslfjo kii kkklo", "khong lieu", "thi an it", "can cu", "thi bu", "sieng nang"
                , "nguy hiem mot ti", "nhung trong", "tam", "kiem soat"};
        bookCovers = new Integer[]{
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.india,
                R.drawable.china,
                R.drawable.nepal,
                R.drawable.bhutan,
                R.drawable.vietnam,
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,};


        tvEmpty =findViewById(R.id.tv_book_empty);
        listBook = findViewById(R.id.lv_book);
        listBook.addHeaderView(textView);
        if(bookTitles.length>0) tvEmpty.setVisibility(View.GONE);

        DataAdapter adapter = new DataAdapter(this,bookTitles,bookDescriptions,bookCovers);
        listBook.setAdapter(adapter);

        listBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"You Selected " + bookTitles[position-1]+ " as Country", Toast.LENGTH_SHORT).show();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}