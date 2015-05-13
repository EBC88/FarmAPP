package com.carpo.myapplication;




import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class editar extends ActionBarActivity implements OnClickListener, AdapterView.OnItemSelectedListener {







    String[] tipo = {"Seleccione Tipo de medicamento", "Inyectado","Comprimido","Jarabe","Topico"};
    String[] dosis1 = {"Seleccione la Dosis","1 pastilla","2 pastillas", "3 pastillas", "4 pastillas"};
    String[] dosis2 = {"Seleccione la Dosis","1 cc","2 cc", "3 cc", "4 cc"};
    String[] dosis3 = {"Seleccione la Dosis","1 cucharadita","2 cucharaditas", "3 cucharaditas", "4 cucharaditas"};
    String[] dosis4 = {"Seleccione la Dosis","2 aplicaciones", "3 aplicaciones", "4 aplicaciones"};
    String[] frec = {"Seleccione Frecuencia", "1 vez al dia", "2 veces al dia", "cada 4 horas", "cada 6 horas", "cada 8 horas"};
    String[] sonid = {"Seleccione Alarma", "Alarm 1", "Alarm 2", "Alarm 3"};
    String[] desbloq = {"Seleccione desbloqueo","Deslizar", "Puzzle"};
    String[] horas = {"00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30","06:00","06:30","07:00","07:30","08:00", "08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00",
            "12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30", "21:00","21:30","22:00","22:30","23:00","23:30"};

    Spinner spin0, spin1, spin2, spin3, spin4, spin5;

    private EditText textAviso;
    private EditText textMed;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar);












        //tomar datos de textAviso y guardarlos en NAV para pasarlos a MainActivity
        /*Intent intent = new Intent(nuevactividad.this, MainActivity.class);
        intent.putExtra("NAV", textAviso.getText().toString() );
        startActivity(intent);*/


        //definir editText
        textAviso = (EditText) findViewById(R.id.editAviso);
        textMed = (EditText) findViewById(R.id.editMed);


        //escuchador evento click boton
    Button btlisto = (Button) findViewById(R.id.button5);
        btlisto.setOnClickListener(this);

        View btCan = findViewById(R.id.Cancel);
        btCan.setOnClickListener(this);

        //ASIGNACION DE CAMPOS A LOS SPINNERS
        spin0 = (Spinner) findViewById(R.id.spinner);
        spin0.setOnItemSelectedListener(this);
        ArrayAdapter <String> c = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,tipo);
        c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin0.setAdapter(c);

        spin1 = (Spinner) findViewById(R.id.spinner2);
        spin1.setOnItemSelectedListener(this);
        spin1.setEnabled(false);

        spin2 = (Spinner) findViewById(R.id.spinner3);
        spin2.setOnItemSelectedListener(this);
        ArrayAdapter <String> d = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,frec);
        d.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(d);
        spin2.setEnabled(false);

        spin3 = (Spinner) findViewById(R.id.spinner4);
        spin3.setOnItemSelectedListener(this);
        ArrayAdapter <String> f = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sonid);
        f.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(f);
        spin3.setEnabled(false);

        spin4 = (Spinner) findViewById(R.id.spinner5);
        spin4.setOnItemSelectedListener(this);
        ArrayAdapter <String> g = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,desbloq);
        g.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin4.setAdapter(g);
        spin4.setEnabled(false);

        spin5 = (Spinner) findViewById(R.id.spinner7);
        spin5.setOnItemSelectedListener(this);
        ArrayAdapter <String> h = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,horas);
        g.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin5.setAdapter(h);
        spin5.setEnabled(false);




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



        if(parent.equals(spin0)){
            spin1.setEnabled(true);
            spin2.setEnabled(true);
            spin3.setEnabled(true);
            spin4.setEnabled(true);
            spin5.setEnabled(true);
            if (spin0.getSelectedItem().equals("Comprimido"))
            {
                ArrayAdapter <String> s1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,dosis1);
                s1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin1.setAdapter(s1);
            }
            else if(spin0.getSelectedItem().equals("Inyectado"))
            {
                ArrayAdapter <String> s2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,dosis2);
                s2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin1.setAdapter(s2);
            }
            else if (spin0.getSelectedItem().equals("Jarabe"))
            {
                ArrayAdapter <String> s3 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,dosis3);
                s3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin1.setAdapter(s3);
            }
            else if (spin0.getSelectedItem().equals("Topico"))
            {
                ArrayAdapter <String> s4 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,dosis4);
                s4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin1.setAdapter(s4);
            }
            else if (spin0.getSelectedItem().equals("Seleccione Tipo de medicamento"))
            {
                spin1.setEnabled(false);
                spin2.setEnabled(false);
                spin3.setEnabled(false);
                spin4.setEnabled(false);
                spin5.setEnabled(false);
            }
        }

    }


    @Override
    public void onClick(View v) {
        // respuesta a V
        // communicator.respond(v);
        if (v.getId() == R.id.button5) {
            String check = textAviso.getText().toString();
            String check1 = textMed.getText().toString();
            if (check.matches("")) {
                Toast.makeText(this, "Por favor ingresa un nombre para el aviso", Toast.LENGTH_SHORT).show();
                return;
            } else {
                if (check1.matches("")) {
                    Toast.makeText(this, "por favor ingrese un nombre para el medicamento", Toast.LENGTH_SHORT).show();
                } else {
                    if (spin1.isEnabled()) {

                        //Insertar a la categoria
                        //extraer texto de los spinners
                        String aviso1 = textAviso.getText().toString();
                        String medic1 = textMed.getText().toString();
                        String tipos = spin0.getSelectedItem().toString();
                        String dosiss = spin1.getSelectedItem().toString();
                        String frecuencias = spin2.getSelectedItem().toString();
                        String alarmas = spin3.getSelectedItem().toString();
                        String desbloqueos = spin4.getSelectedItem().toString();
                        String horas = spin5.getSelectedItem().toString();

                        Integer id = getIntent().getExtras().getInt("ID");
                        //creacion de la base de datos
                        dbManager manager = new dbManager(this);
                        //escritura en la base de datos
                        manager.setId(id);
                        manager.update(aviso1, medic1, tipos, dosiss, frecuencias, alarmas, desbloqueos, horas);

                        //creación del intent
                        Intent intent = new Intent(editar.this, MainActivity.class);
                        //Aviso de escritura en db
                        Toast.makeText(this, "Se han guardado los cambios", Toast.LENGTH_SHORT).show();
                        //iniciar la actividad
                        startActivity(intent);

                        finish();

                    } else {
                        Toast.makeText(this, "Selección un tipo de medicamento", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            }


        }
        if (v.getId() == R.id.Cancel) {
            Intent salir = new Intent(editar.this, verdatos.class);
            Integer id = getIntent().getExtras().getInt("ID");
            Bundle bcd = new Bundle();
            bcd.putInt("ID", id);
            salir.putExtras(bcd);
            startActivity(salir);
            finish();
        }
    }




    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




}