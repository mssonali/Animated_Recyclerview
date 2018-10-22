package com.sonali.recyclerviewanimation;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.sonali.recyclerviewanimation.Fragments.FragmentFallDown;

public class MainActivity extends AppCompatActivity implements FragmentFallDown.OnFragmentInteractionListener {

    RecyclerView recyclerview;
    MyAdapter adapter;
    private FloatingActionButton fab, fab1, fab2, fab3;
    boolean fabExpanded = false;
    RelativeLayout rrr, rrf, rrb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getControls();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fabExpanded == true) {
                    closeSubMenusFab();
                } else {
                    openSubMenusFab();
                }

                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });


        rrf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Bundle b = new Bundle();
                b.putString("type", "falldown");
                FragmentFallDown fallDown = new FragmentFallDown();
                fallDown.setArguments(b);
                transaction.replace(R.id.frame, fallDown, "falldown");
                transaction.commit();
            }
        });

        rrr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Bundle b = new Bundle();
                b.putString("type", "slidefromright");
                FragmentFallDown fallDown = new FragmentFallDown();
                fallDown.setArguments(b);
                transaction.replace(R.id.frame, fallDown, "falldown");
                transaction.commit();
            }
        });

        rrb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Bundle b = new Bundle();
                b.putString("type", "slidefrombottom");
                FragmentFallDown fallDown = new FragmentFallDown();
                fallDown.setArguments(b);
                transaction.replace(R.id.frame, fallDown, "falldown");
                transaction.commit();
            }
        });

    }

    public void getControls() {
        fab1 = this.findViewById(R.id.fab1);
        fab2 = this.findViewById(R.id.fab2);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        rrr = findViewById(R.id.rrr);
        rrf = findViewById(R.id.rrf);
        rrb = findViewById(R.id.rrb);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Bundle b = new Bundle();
        b.putString("type", "falldown");
        FragmentFallDown falldown = new FragmentFallDown();
        fragmentTransaction.replace(R.id.frame, falldown, "falldown");
        falldown.setArguments(b);
        fragmentTransaction.commit();

       /* int resId = R.anim.layout_animation_fall_down;
        recyclerview = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(linearLayoutManager);
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, resId);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setLayoutAnimation(animation);

        List<String> myList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            myList.add(i, "abcd");
        }
        adapter = new MyAdapter(myList, this);
        recyclerview.setAdapter(adapter);*/
    }


    //closes FAB submenus
    private void closeSubMenusFab() {

        rrf.setVisibility(View.GONE);
        rrr.setVisibility(View.GONE);
        rrb.setVisibility(View.GONE);
        rrr.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close));
        rrf.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close));
        rrb.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close));
        fab.setImageResource(android.R.drawable.ic_input_add);
        fabExpanded = false;
    }

    //Opens FAB submenus
    private void openSubMenusFab() {
        rrr.setVisibility(View.VISIBLE);
        rrf.setVisibility(View.VISIBLE);
        rrb.setVisibility(View.VISIBLE);

        rrr.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open));
        rrf.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open));
        rrb.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open));

        //Change settings icon to 'X' icon
        fab.setImageResource(R.drawable.ic_close_black_24dp);
        fabExpanded = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
