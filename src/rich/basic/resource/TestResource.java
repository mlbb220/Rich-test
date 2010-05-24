/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rich.basic.resource;

import rich.date.TestCalendar;

/**
 *
 * @author 
 */
public class TestResource {

    public static String getClassPath(Class className){
        return className.getResource("").getPath();
    }

    public static void main(String[] args ){
        
        System.out.println(getClassPath(TestCalendar.class));
        System.out.println(getClassPath(TestResource.class));
        System.out.println(TestResource.class.getResource("/").getPath());
    }
}
