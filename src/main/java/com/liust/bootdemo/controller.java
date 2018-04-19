package com.liust.bootdemo;

import com.liust.bootdemo.bean.Person;
import com.liust.bootdemo.dao.Dao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class controller {
    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    @ResponseBody
    private Object getPerson(){
        Dao dao=new Dao();
        List<Person> list= dao.arrToList(dao.getData());
        return list;
    }
    @RequestMapping("/")
    public String welcome(){
        return "index";

    }
    @RequestMapping("/name")
    public String name(Map<String, Object> map) {
        map.put("name", "Clark");

        System.out.println("============================================");
        return "hello";
    }

}
