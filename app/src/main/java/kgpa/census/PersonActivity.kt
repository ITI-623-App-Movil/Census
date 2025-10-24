package kgpa.census

import Controller.PersonController
import Entity.Person
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PersonActivity : AppCompatActivity() {
    lateinit var txtID: EditText
    lateinit var txtName: EditText
    lateinit var txtFLastName: EditText
    lateinit var txtSLastName: EditText
    lateinit var txtPhone: EditText
    lateinit var txtEmail: EditText
    lateinit var txtProvince: EditText
    lateinit var txtState: EditText
    lateinit var txtDistrict: EditText
    lateinit var txtBirthday: EditText
    lateinit var txtAddress: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_person)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.TableLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtID = findViewById<EditText>(R.id.txtID_person)
        txtName = findViewById<EditText>(R.id.txtName_person)
        txtFLastName = findViewById<EditText>(R.id.txtFLastName_person)
        txtSLastName = findViewById<EditText>(R.id.txtSLastName_person)
        txtPhone = findViewById<EditText>(R.id.txtPhone_person)
        txtEmail = findViewById<EditText>(R.id.txtEmail_person)
        txtProvince = findViewById<EditText>(R.id.txtProvince_person)
        txtState = findViewById<EditText>(R.id.txtState_person)
        txtDistrict = findViewById<EditText>(R.id.txtDistrict_person)
        txtBirthday = findViewById<EditText>(R.id.txtBirthday_person)
        txtAddress = findViewById<EditText>(R.id.txtAddress_person)

        var btnSave = findViewById<Button>(R.id.btnSave_person)
        btnSave.setOnClickListener(View.OnClickListener { view ->
            savePerson()
        })
    }

    fun savePerson() {
        try {
            val person: Person = Person()
            person.ID = txtID.text.toString()
            person.Name = txtName.text.toString()
            person.FLastName = txtFLastName.text.toString()
            person.SLastName = txtSLastName.text.toString()
            person.Phone = txtPhone.text.toString().toInt()
            person.Email = txtEmail.text.toString()
            // person.Birthday = txtBirthday.text.toString()
            // person.Province = txtProvince.text.toString()
            person.State = txtState.text.toString()
            person.District = txtDistrict.text.toString()
            person.Address = txtAddress.text.toString()

            if (validationData()) {
                var personController = PersonController(this)
                personController.addPerson(person)
            } else {

            }
        } catch (e: Exception) {
            Toast.makeText(this,e.message.toString(),
                Toast.LENGTH_SHORT).show()
        }
    }

    fun validationData(): Boolean {
        return true
    }
}