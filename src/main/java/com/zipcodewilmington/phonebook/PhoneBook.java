package com.zipcodewilmington.phonebook;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map)
    {
        this.phonebook = map;
    }

    public PhoneBook()
    {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber)
    {
        phonebook.put(name, Collections.singletonList(phoneNumber));

    }

    public void addAll(String name, String... phoneNumbers)
    {
        phonebook.put(name, List.of(phoneNumbers));
    }

    public void remove(String name)
    {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name, String phoneNumber)
    {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name)
    {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)
    {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet())
            {
                if(entry.getValue().contains(phoneNumber))
                    {
                        return entry.getKey();
                    }

            }
        return "";
    }

    public List<String> getAllContactNames()
    {

        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap()
    {
        return phonebook;
    }
}
