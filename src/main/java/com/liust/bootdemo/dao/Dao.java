package com.liust.bootdemo.dao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liust.bootdemo.bean.Person;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class Dao {
    public    Person[] getData(){
        Reader reader=null;
        try {
            Resource res = new ClassPathResource("data.json");
            //in = new FileInputStream(packageSearchPath);
            reader= new InputStreamReader(res.getInputStream(), "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().create();
        //反序列化,从指定的流中将Json反序列化为指定java对象
        Person[] persons = gson.fromJson(reader,    Person[].class);
        return persons;
    }
    public List<Person> arrToList(Person[] people){
        List<Person> list=new ArrayList<>();
        for (int i = 0; i <people.length ; i++) {
            list.add(people[i]);
        }
        return list;
    }

}
