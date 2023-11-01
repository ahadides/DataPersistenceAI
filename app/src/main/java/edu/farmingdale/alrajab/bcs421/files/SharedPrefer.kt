package edu.farmingdale.alrajab.bcs421.files

import androidx.appcompat.app.AppCompatActivity
import edu.farmingdale.alrajab.bcs421.R
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import edu.farmingdale.alrajab.bcs421.databinding.ActivityMainBinding
import edu.farmingdale.alrajab.bcs421.databinding.ActivitySharedPreferBinding


class SharedPrefer : AppCompatActivity() {
    private val PREFS_NAME = "MyPrefsFile" // SharedPreferences file name
    private lateinit var binding: ActivitySharedPreferBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_prefer)
        binding = ActivitySharedPreferBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences: SharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        // Load the data when the activity starts

        binding.saveButton.setOnClickListener {
            val firstName = binding.firstNameEditText.text.toString()
            val lastName = binding.lastNameEditText.text.toString()
            binding.firstNameEditText.setText("")
            binding.lastNameEditText.setText("")
            // Save the user's data in SharedPreferences
            editor.putString("firstName", firstName)
            editor.putString("lastName", lastName)
            editor.apply()
        }

        binding.readButton.setOnClickListener {
            // Read and display the user's data from SharedPreferences
            val savedName = sharedPreferences.getString("firstName", "")+ " " + sharedPreferences.getString("lastName", "")

            binding.textView.setText(savedName)
        }

        binding.updateButton.setOnClickListener {
            val updatedFirstName = binding.firstNameEditText.text.toString()
            val updatedLastName = binding.lastNameEditText.text.toString()
            binding.firstNameEditText.setText("")
            binding.lastNameEditText.setText("")
            // Update the user's data in SharedPreferences
            editor.putString("firstName", updatedFirstName)
            editor.putString("lastName", updatedLastName)
            editor.apply()
            binding.textView2.setText(updatedFirstName+ " "+updatedLastName)
        }
    }


}