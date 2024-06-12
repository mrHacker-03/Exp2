package com.example.exp2
//copy from below
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.exp2.R
import java.util.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userName = findViewById<EditText>(R.id.userName)
        val passw = findViewById<EditText>(R.id.passw)
        val addr = findViewById<EditText>(R.id.addr)
        val age = findViewById<EditText>(R.id.age)
        val dob = findViewById<EditText>(R.id.dob)
        val sub = findViewById<Button>(R.id.sub)
        val gender = findViewById<RadioGroup>(R.id.gender)
        val printer = findViewById<TextView>(R.id.printer)

        dob.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    dob.setText("${selectedDay}/${selectedMonth + 1}/${selectedYear}")
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
        sub.setOnClickListener {
            val selectedGender = when (gender.checkedRadioButtonId) {
                R.id.ma -> "Male"
                R.id.fe -> "Female"
                else -> ""
            }

            val i = "Name:${userName.text}\n" +
                    "Password:${passw.text}\n" +
                    "Address:${addr.text}\n" +

                    "Gender:${selectedGender}\n" +
                    "Age:${age.text}\n" +
                    "Date of Birth:${dob.text}\n"
            printer.text = i;
        }
    }
}
