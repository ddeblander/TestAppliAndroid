package com.example.myapplication.modele;

import java.util.ArrayList;
import java.util.List;

public class Maison
{
    private List<Person> inHouse = new ArrayList<>();

    public void populate()
    {
        Person p = new Person(0,"Deblander","David");
        inHouse.add(p);
        p = new Person(1,"Leroy","Coralie");
        inHouse.add(p);
        p = new Person(2,"Zbla","Alien");
        inHouse.add(p);
        p = new Person(3,"Chein","Pikachu");
        inHouse.add(p);
    }

    public List<Person> GetList()
    {
        return inHouse;
    }
    public void AddListPerson(Person p)
    {
        inHouse.add(p);
    }


    public void SetList(List<Person> lp)
    {
        this.inHouse=lp;
    }
}
