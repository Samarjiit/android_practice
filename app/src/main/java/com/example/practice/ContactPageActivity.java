package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ContactPageActivity extends AppCompatActivity {
    DatabaseHandler db;
    EditText etName, etNumber;
    Button btnAddContact;
    ListView lvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);

        db = new DatabaseHandler(this);
        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        lvContacts = findViewById(R.id.lvContacts);
        btnAddContact = findViewById(R.id.btnAddContact);

        ContactListAdapter adapter = new ContactListAdapter((Context) ContactPageActivity.this, db.getAllContacts());
        lvContacts.setAdapter(adapter);

        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ContactPageActivity.this, "CLicked : "+db.getContact(i+1).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String number = etNumber.getText().toString();
                db.addContact(new Contact(name, number));
                adapter.notifyDataSetChanged();
                recreate();
            }
        });

    }
}