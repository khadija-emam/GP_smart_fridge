package com.example.khadija.smartfridge.Recipes;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.khadija.smartfridge.R;
import com.example.khadija.smartfridge.RecipiesDetails.RecipieDetailsActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecipiesActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<RecipiesClass>> {
    private static final int RECIPIES_LOADER_ID =1;
    private static final String LOG_TAG = RecipiesActivity.class.getName();
    View LoadingIndicator ;

    public static final String RECIPIES_URL ="";
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipies);
        LoadingIndicator= findViewById(R.id.progressBar);
        LoaderManager loaderManager = getLoaderManager();

        // Initialize the loader. Pass in the int ID constant defined above and pass in null for
        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
        // because this activity implements the LoaderCallbacks interface).
        loaderManager.initLoader(RECIPIES_LOADER_ID, null, this);


        GridView RgridView = findViewById(R.id.recipiesGrid);
        final RecipiesAdapter adapter =new RecipiesAdapter(this,R.layout.recipies_view,new ArrayList<RecipiesClass>());
        RgridView.setAdapter(adapter);
        RgridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                RecipiesClass recipiesClass =adapter.getItem(position);
                Intent RIntent=new Intent(RecipiesActivity.this, RecipieDetailsActivity.class);
                RIntent.putExtra("RecipieKey", (Serializable) recipiesClass);
                startActivity(RIntent);
            }
        });

    }

    @Override
    public Loader<List<RecipiesClass>> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<List<RecipiesClass>> loader,List<RecipiesClass> RecipiesList) {

    }

    @Override
    public void onLoaderReset(Loader<List<RecipiesClass>> loader) {

    }
}
