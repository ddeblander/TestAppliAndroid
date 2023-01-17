package com.example.myapplication.modele;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable
{
    private String name,surname;
    private int id;
    public Person(int id, String name, String surname)
    {
        this.id=id;
        this.name=name;
        this.surname=surname;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public int getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public void setSurname(String name)
    {
        this.surname=name;
    }
    public String getSurname()
    {
        return surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.surname);

    }
    protected Person(Parcel in)
    {
        this.name=in.readString();
        this.surname=in.readString();
    }
    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
