package com.example.tech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    private  static final String url="https://futursity.com/course/api/top_courses";
    private  static final String SECOND_url="https://futursity.com/course/api/categories";

    RecyclerView recview,recievw2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recview = (RecyclerView) findViewById(R.id.recview);

        recievw2=findViewById(R.id.second_recycler);


        recview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        recievw2.setLayoutManager(new GridLayoutManager(this,2));

        processdata();

        anotherprocessdata();


    }



    public void processdata()
    {

        StringRequest request=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                GsonBuilder builder=new GsonBuilder();
                Gson gson=builder.create();
                Model data[]=gson.fromJson(response,Model[].class);

                myadapter adapter=new myadapter(data);
                recview.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        }
        );


        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);

    }


    private void anotherprocessdata() {

        StringRequest request1=new StringRequest(SECOND_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                ModelCategory categorydata[] = gson.fromJson(response, ModelCategory[].class);

                SecondAdapter secondAdapter = new SecondAdapter(categorydata);
                recievw2.setAdapter(secondAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();


            }
        }
        );

        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request1);
    }






}