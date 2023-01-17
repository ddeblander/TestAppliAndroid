package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.modele.Maison;
import com.example.myapplication.modele.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText idCode=null,nom=null,prenom=null;
    private Button save=null;
    private ListView lv=null;
    private ArrayAdapter<Person> adpt;


    private Person pact=null;
    private Person pInsert=null;
    private Maison m=null;
    public static final String MAISON = "Maison";

    public static final String PACT = "person actuel";

    public static final String LISTPERSON = "liste Person";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        m = new Maison();
        m.populate();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null)
        {
            pact=(Person) savedInstanceState.getParcelable(PACT);

            ArrayList<Person> listPerson= savedInstanceState.getParcelableArrayList(LISTPERSON);
        }
        idCode=findViewById(R.id.idCode);
        nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);
        save=findViewById(R.id.idSaveButton);
        lv=findViewById(R.id.listView);

        loadList();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                pact=m.GetList().get(position);
                idCode.setText(String.valueOf(pact.getId()));
                nom.setText(pact.getName());
                prenom.setText(pact.getSurname());
            }
        });
    }
    public void clickSave(View v)
    {

        String str=idCode.getText().toString();
        try
        {
            int id=Integer.parseInt(str);
            pInsert = new Person(id,nom.getText().toString(),prenom.getText().toString());
            m.AddListPerson(pInsert);
            Toast toast=Toast.makeText(this,String.valueOf(id), Toast.LENGTH_SHORT);
            toast.show();
            initText();
            loadList();
        }
        catch (Exception e)
        {
            Toast toast=Toast.makeText(this, R.string.ExceptionINT, Toast.LENGTH_LONG);
            toast.show();
        }



    }
    private void loadList()
    {
        adpt= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,m.GetList());

        lv.setAdapter(adpt);
    }
    private void initText()
    {
        idCode.setText("");
        nom.setText("");
        prenom.setText("");

    }
}