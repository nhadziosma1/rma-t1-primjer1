package ba.unsa.etf.rma.VJ_18033;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private Button dugmeVan;
    private TextView tekstVan;
    private ListView listViewVan;

    private ArrayAdapter ulancaniAdapter;
    private ArrayList<String> unosiKorisnika = new ArrayList<>();
    private EditText editujMe;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //predlaze id-eve svih elemenata sa prozaora kao upises "R.id. "
        dugmeVan = (Button) findViewById(R.id.dugmeVan);
        //mora se izvrsiti cast u TexzView, jer ova metoda vraca "View" tip
        tekstVan = (TextView) findViewById(R.id.TVVan);
        listViewVan = (ListView) findViewById(R.id.listaPogled);
        editujMe = (EditText) findViewById(R.id.editujMe);

        //Kada se u konstuktoru zeli koristiti neki od vec integrisanih layouta kao sto je "simple_list_item_1", mora se ispred "R", koji predtsvlja
        // oznaku za resource, stajati i "android"
        //ulancaniAdapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, unosiKorisnika);

        //treci parametar konstruktora: The id of the TextView within the layout resource to be populated
        ulancaniAdapter = new ArrayAdapter(getBaseContext(), R.layout.element_liste, R.id.Itemname, unosiKorisnika);

        listViewVan.setAdapter(ulancaniAdapter);

        dugmeVan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                unosiKorisnika.add(0, editujMe.getText().toString());
                //unosiKorisnika.add(0, tekstVan.getText().toString());
                ulancaniAdapter.notifyDataSetChanged();
            }
        });
    }
}
