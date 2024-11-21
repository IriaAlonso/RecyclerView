package com.example.recyclerview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ContactoAdaptador.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Crear conjunto de datos
        ArrayList<Contacto> contactoArrayList = new ArrayList<>(Arrays.asList(new Contacto[]{
                new Contacto("Vi","vi@gmail.com","111111", R.drawable.vi),
                new Contacto("Caitlyn", "caitlyn@gmail.com","222222", R.drawable.caitlyn),
                new Contacto("Jinx", "jinx@gmail.com","333333", R.drawable.jinx),
                new Contacto("Jayce", "jayce@gmail.com","444444", R.drawable.jayce),
                new Contacto("Viktor", "viktor@gmail.com","555555", R.drawable.viktor),
                new Contacto("Ekko", "ekko@gmail.com","666666", R.drawable.ekko),
                new Contacto("Heimerdinger", "heimerdinger@gmail.com","777777", R.drawable.heimerdinger),
                new Contacto("Ambessa", "ambessa@gmail.com","888888", R.drawable.ambessa),
                new Contacto("Singed", "singed@gmail.com","999999", R.drawable.singed)
        }));
        ContactoAdaptador contactoAdapter = new ContactoAdaptador(this, contactoArrayList, this);

        RecyclerView rvContactos = findViewById(R.id.rv_contactos);
        rvContactos.setLayoutManager(new LinearLayoutManager(this));
        rvContactos.setAdapter(contactoAdapter);



    }

    @Override
    public void onItemClick(Contacto contacto, int position) {
        String mensaje = "";
        switch (contacto.getNombre().toLowerCase()) {
            case "vi":
                mensaje = "La Agente de Piltover";
                break;
            case "caitlyn":
                mensaje = "La Sheriff de Piltover";
                break;
            case "jinx":
                mensaje = "La Bala Perdida";
                break;
            case "jayce":
                mensaje = "El Defensor del Mañana";
                break;
            case "viktor":
                mensaje = "El Heraldo de las Máquinas";
                break;
            case "ekko":
                mensaje = "El Chico que Quebró el Tiempo";
                break;
            case "heimerdinger":
                mensaje = "El Inventor Venerado";
                break;
            case "ambessa":
                mensaje = "Matriarca de la Guerra";
                break;
            case "singed":
                mensaje = "El Químico Loco";
                break;
            default:
                mensaje = "falta informacion";
        }
        Toast.makeText(this, contacto.getNombre() + ": " + mensaje, Toast.LENGTH_SHORT).show();
    }
}