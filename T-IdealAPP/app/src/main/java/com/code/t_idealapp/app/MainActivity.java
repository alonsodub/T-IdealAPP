package com.code.t_idealapp.app;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.app.ActionBar.Tab;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setup_navigationDrawer();
        setup_actionBar();
    }

    public void setup_navigationDrawer() {

        DrawerLayout mDrawerLayout;
        ListView mDrawerList;
        ArrayList<Item>NavItems;
        TypedArray NavIcons;
        String[] items;
        NavAdapter mNavAdapter;

        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.lista);
        View header = getLayoutInflater().inflate(R.layout.header,null);
        mDrawerList.addHeaderView(header);

        NavIcons=getResources().obtainTypedArray(R.array.items_icons);
        items = getResources().getStringArray(R.array.items);
        NavItems = new ArrayList<Item>();

        NavItems.add(new Item(items[0],NavIcons.getResourceId(0,-1)));
        NavItems.add(new Item(items[1],NavIcons.getResourceId(1,-1)));
        NavItems.add(new Item(items[2],NavIcons.getResourceId(2,-1)));
        NavItems.add(new Item(items[3],NavIcons.getResourceId(3,-1)));
        NavItems.add(new Item(items[4],NavIcons.getResourceId(4,-1)));

        mNavAdapter = new NavAdapter(this,NavItems);
        mDrawerList.setAdapter(mNavAdapter);


    }
    public void setup_actionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        Tab tab1 = actionBar.newTab()
                .setText(R.string.tab1)
                .setTabListener(new TabsListener<Mi_Cuenta>
                        (this, "cuenta", Mi_Cuenta.class));
        actionBar.addTab(tab1);
        Tab tab2 = actionBar.newTab()
                .setText(R.string.tab2)
                .setTabListener(new TabsListener<Mi_Solicitudes>
                        (this, "perfil", Mi_Solicitudes.class));
        actionBar.addTab(tab2);
        Tab tab3 = actionBar.newTab()
                .setText(R.string.tab3)
                .setTabListener(new TabsListener<Mi_CV>
                        (this, "cv", Mi_CV.class));
        actionBar.addTab(tab3);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_button:
                openSearch();
                return true;
            case R.id.settings_button:
                openSettings();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void openSettings() {
        toast("Nada en settings");
    }
    private void openSearch() {
        toast("Nada que buscar");
    }
    public void toast (String s){
        Context c = getApplicationContext();
        Toast t = Toast.makeText(c,s,Toast.LENGTH_SHORT);
        t.show();
    }

}
