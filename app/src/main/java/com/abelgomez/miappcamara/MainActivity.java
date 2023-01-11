package com.abelgomez.miappcamara;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnCamara;
    ImageView imgView;
    String rutaImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamara = findViewById(R.id.BtnCamara);
        imgView = findViewById(R.id.imagenView);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });

//        btnCamara.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                   camaraLuecher.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
//
//
//               // abrirCamara();
//
//            }
//        });

        ////////////////////////////////////////////////////////////////
//        btnCamara.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    abrirCamara();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });


//        btnCamara.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                //  camaraLuecher.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
//                abrirCamara();
//
//
//            }
//        });

    }


    public void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if(intent.resolveActivity(getPackageManager()) != null){
        File imagenArchivo = null;
        try {
            imagenArchivo = crearImagen();
        }catch ( IOException ex){
            Log.e("Error", ex.toString());
        }
        if(imagenArchivo != null){
            Uri fotouri = FileProvider.getUriForFile(this,"com.abelgomez.miappcamara.fileprovider", imagenArchivo);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,fotouri);

            startActivityForResult(intent,1);
        }

        //}
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            //Bundle extras = data.getExtras();
            Bitmap imgBitmap = BitmapFactory.decodeFile(rutaImagen);
            imgView.setImageBitmap(imgBitmap);
        }
    }

    private File crearImagen() throws IOException {
        String nombreImagen = "fotoabel_";
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imagen = File.createTempFile(nombreImagen,".jpg",directorio);
        rutaImagen = imagen.getAbsolutePath();
        return imagen;



    }




























//    private void abrirCamara() {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//
//
//     //  if (intent.resolveActivity(getPackageManager()) != null) {
//            File imagenArchivo = null;
//
//            try {
//                imagenArchivo = crearImagen();
//            } catch (IOException ex) {
//
//                Log.e("ERROR me", ex.toString());
//            }
//
//            if (imagenArchivo != null) {
//
//                Uri fotoUri = FileProvider.getUriForFile(this, "com.abelgomez.miappcamara.fileprovider", imagenArchivo);
//                intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
//                startActivityForResult(intent, 1);
//
//
//            }
//
//      //  }
//    }
//
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1 && resultCode == RESULT_OK) {
//            Bitmap imgBitmap = BitmapFactory.decodeFile(rutaImagen);
//            imagenView.setImageBitmap(imgBitmap);
//        }
//    }
//


/////////////////////////////////////////////////////////////
//    ActivityResultLauncher<Intent> camaraLuecher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
//        @Override
//        public void onActivityResult(ActivityResult result) {
//            if (result.getResultCode() == RESULT_OK) {
//
//                Bundle extras = result.getData().getExtras();
//                Bitmap imgBitmap = (Bitmap) extras.get("data");
//                imagenView.setImageBitmap(imgBitmap);
//
//            }
//        }
//    });


//    private File crearImagen() throws IOException {
//
//        String nombreImagen = "fotoAbel_";
//        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//
//        File imagen = File.createTempFile(nombreImagen, ".jpg", directorio);
//
//
//        rutaImagen = imagen.getAbsolutePath();
//        return imagen;
//
//    }


    ///////////////////////////////////////////////////////

//    private void abrirCamara() throws IOException {
//        // PARA CAPTURAR IMAGEN
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        File imagenArchivo = null;
//
//        try {
//            imagenArchivo = crearImagen();
//
//        } catch (IOException ex) {
//            Log.e("Error", ex.toString());
//        }
//
//
//        if (imagenArchivo != null) {
//            Uri fotoUri = FileProvider.getUriForFile(this, "com.example.myapplication.fileprovider", imagenArchivo);
//            intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
//        }
//
//        startActivityForResult(intent, 1);
//
//    }
//
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 1 && resultCode == RESULT_OK) {
//            // Bundle extras = data.getExtras();
//            //Bitmap imgBitmap = (Bitmap) extras.get("data");
//            Bitmap imgBitmap = BitmapFactory.decodeFile(rutaImagen);
//
//            ImageView.setImageBitmap(imgBitmap);
//        }
//    }
//
//
//    private File crearImagen() throws IOException {
//
//        String nombreImagen = "foto_";
//        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File imagen = File.createTempFile(nombreImagen, ".jpg", directorio);
//
//        rutaImagen = imagen.getAbsolutePath();
//        return imagen;
//
//    }
}