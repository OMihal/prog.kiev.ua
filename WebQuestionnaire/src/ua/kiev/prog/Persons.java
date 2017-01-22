package ua.kiev.prog;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Persons
{
    private AtomicInteger counter = new AtomicInteger();
    private Map<Integer, Person> arr =
        Collections.synchronizedMap(new HashMap<Integer, Person>());

    // singleton section
    private static Persons ourInstance = new Persons();

    public static Persons getInstance()
    {
        return ourInstance;
    }

    private Persons()
    {
    }

    private int find(Person person)
    {
        Set<Map.Entry<Integer, Person>> set = arr.entrySet();
        for (Map.Entry<Integer, Person> entry : set)
        {
            if (person.equals(entry.getValue()))
            {
                return entry.getKey();
            }
        }
        return -1;
    }

    public synchronized int addOrUpdate(Person person)
    {
        int id = find(person);
        if (id == -1)
        {
            id = counter.incrementAndGet();
        }
        arr.put(id, person);
        return id;
    }
    public int getCount()
    {
        return arr.size();
    }
    public int getAverageAge()
    {
        int ageSum = 0;
        Set<Map.Entry<Integer, Person>> set = arr.entrySet();
        for (Map.Entry<Integer, Person> entry : set)
        {
            ageSum += entry.getValue().getAge();
        }
        return ageSum/arr.size();
    }
}
