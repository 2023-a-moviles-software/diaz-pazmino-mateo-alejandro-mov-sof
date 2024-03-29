package com.example.debersqlite.Activies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.debersqlite.CRUD.GenreDAO
import com.example.debersqlite.DB.DataBase
import com.example.debersqlite.R
import com.google.android.material.snackbar.Snackbar

class CreateGenresView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_genres_view)
        val createButton = findViewById<Button>(R.id.btn_crear_genero)
        createButton.setOnClickListener {
            if(checkFields()){
                createGenre()
                clearFields()
                showSnackbar("Genero Creada")
            }else{
                showSnackbar("No se ha podido crear el Genero")
            }

        }
    }

    fun createGenre(){
        val nameText =  findViewById<TextView>(R.id.input_name_genre_new).text.toString()
        val ratingText =  findViewById<TextView>(R.id.input_rating_genre_new).text.toString().toDouble()
        val durationText = findViewById<TextView>(R.id.input_duration_genre_new).text.toString().toInt()
        val directorText = findViewById<TextView>(R.id.input_director_genre_new).text.toString()
        DataBase.tableGenre?.create(nameText,ratingText,durationText,directorText)
    }

    fun clearFields(){
        findViewById<TextView>(R.id.input_name_genre_new).text = ""
        findViewById<TextView>(R.id.input_rating_genre_new).text = ""
        findViewById<TextView>(R.id.input_duration_genre_new).text = ""
        findViewById<TextView>(R.id.input_director_genre_new).text = ""
    }

    fun showSnackbar(text: String){
        Snackbar.make(findViewById(R.id.cl_genres_new),text, Snackbar.LENGTH_LONG)
            .setAction("Action",null).show()
    }

    fun checkFields():Boolean{
        return !(findViewById<TextView>(R.id.input_name_genre_new).text.toString() == "" ||
                findViewById<TextView>(R.id.input_rating_genre_new).text.toString() == "" ||
                findViewById<TextView>(R.id.input_duration_genre_new).text.toString() == "" ||
                findViewById<TextView>(R.id.input_director_genre_new).text.toString() == "")
    }
}