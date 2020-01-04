package com.zfx.cloud;

import com.zfx.cloud.entities.Dept;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Dept dept = new Dept();
        dept.setDeptno(1L).setDname("RD1").setDb_source("DB01");

        System.out.println(dept);
    }
}
