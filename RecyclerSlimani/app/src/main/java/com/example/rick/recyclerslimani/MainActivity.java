package com.example.rick.recyclerslimani;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started!");

        initImagesBitmaps();
    }

    private void initImagesBitmaps(){
        Log.d(TAG, "initImagesBitmaps: preparing Images");

        mImageUrls.add("http://ensias.um5.ac.ma/sites/ensias.um5.ac.ma/files/styles/img_156_196/public/images/professor/abikmounia.jpg?itok=4OItm4Ag");
        mNames.add("Mme Mounia Abik");

        mImageUrls.add("http://ensias.um5.ac.ma/sites/ensias.um5.ac.ma/files/styles/img_156_196/public/images/professor/img-meh.jpg?itok=OuHXGXdZ");
        mNames.add("M Mahmoud Hamlaoui");

        mImageUrls.add("http://ensias.um5.ac.ma/sites/ensias.um5.ac.ma/files/styles/img_156_196/public/images/professor/salahbaina.jpg?itok=OGAz-3nM");
        mNames.add("M Salah Baina");

        mImageUrls.add("http://ensias.um5.ac.ma/sites/ensias.um5.ac.ma/files/styles/img_156_196/public/images/professor/sbounabat.jpg?itok=tjFNuj1p");
        mNames.add("M. BOUCHAIB BOUNABAT");

        mImageUrls.add("http://ensias.um5.ac.ma/sites/ensias.um5.ac.ma/files/styles/img_156_196/public/images/professor/ezzahid.jpg?itok=A3kHVXaG");
        mNames.add("Mme SOUMIA EZZAHID");

        mImageUrls.add("http://ensias.um5.ac.ma/sites/ensias.um5.ac.ma/files/styles/img_156_196/public/images/professor/houdabenbrahim.jpg?itok=0-yIMMp9");
        mNames.add("Mme Houda BENBRAHIM");

        mImageUrls.add("http://ensias.um5.ac.ma/sites/ensias.um5.ac.ma/files/styles/img_156_196/public/images/professor/radouane%20mrabet.jpg?itok=uYoSzYH2");
        mNames.add("M. Radouane MRABET");

        mImageUrls.add("http://ensias.um5.ac.ma/sites/ensias.um5.ac.ma/files/styles/img_156_196/public/images/professor/sdoukkali.jpg?itok=tvKZETud");
        mNames.add("M. Abdelaziz DOUKKALI SDIGUI ");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: Initializing the recylcler view");
        RecyclerView rv = findViewById(R.id.recycler_view);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this,mNames,mImageUrls);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
