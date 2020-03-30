package com.example.collegeconnect;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User {

        public String Username;
        public String Email;
        public String Name;
        public String Password;
        public String Clgname;

        private static FirebaseDatabase firebaseDatabase;

        public User() {
            Username =null;
            Email =null;
            Name =null;
            Password =null;
            Clgname =null;
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String username, String email, String name, String password, String clgname) {
            this.Username = username;
            this.Email = email;
            this.Name =name;
            this.Password =password;
            this.Clgname=clgname;
        }

        public static boolean addUser(String username, String email, String name, String password, String clgname)
        {
            User user = new User(username,email,name,password,clgname);
            firebaseDatabase=FirebaseDatabase.getInstance();
            DatabaseReference myRef = firebaseDatabase.getReference();
            int dot = email.indexOf(".");
            myRef.child(email.substring(0,dot)).setValue(user);
            return true;
        }
}
