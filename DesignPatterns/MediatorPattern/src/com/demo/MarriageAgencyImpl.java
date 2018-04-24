package com.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介所实现类
 */
public class MarriageAgencyImpl implements MarriageAgency{
    List<Man> men = new ArrayList<Man>();   //男会员
    List<Woman> women = new ArrayList<Woman>();   //女会员

    @Override
    public void pair(Person person) {
        if (person.sex == Sex.MALE){
            for (Woman w:women){
                if (w.age == person.requestAge){
                    System.out.println(person.name+"和"+w.name+"配对成功!");
                    return;
                }
            }
        }else if(person.sex == Sex.FEMALE){
            for (Man m:men){
                if (m.age == person.requestAge){
                    System.out.println(person.name+"和"+m.name+"配对成功!");
                }
            }
        }
        System.out.println(person.name+"未找到合适人选!!!");
    }

    @Override
    public void register(Person person) {
        if (person.sex == Sex.MALE){
            men.add((Man) person);
        }else if (person.sex == Sex.FEMALE){
            women.add((Woman) person);
        }
    }
}
