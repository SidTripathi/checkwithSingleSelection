package com.tuist.sudhanshu.checkwithsingleselection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity  extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Model> modelArrayList;
    private CustomAdapter customAdapter;
    private Button btnselect, btndeselect, btnnext;
    private  String[] animallist = new String[]{"Lion", "Tiger", "Leopard", "Cat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        btnnext = (Button) findViewById(R.id.next);

        modelArrayList = getModel(false);
        customAdapter = new CustomAdapter(this,modelArrayList);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);
            }
        });


    }

    private ArrayList<Model> getModel(boolean isSelect){
        ArrayList<Model> list = new ArrayList<>();
        for(int i = 0; i < 4; i++){

            Model model = new Model();
            model.setSelected(isSelect);
            model.setAnimal(animallist[i]);
            list.add(model);
        }
        return list;
    }
}
