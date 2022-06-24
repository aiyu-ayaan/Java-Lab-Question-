package brishti;

// Class and Objects   
/*
 * Class is a blueprint for an object.
 * Object is an instance of a class.
 *
 *  #How to define class ?
 *  => access modifier + class  + className
 *
 * type of access modifier
 *  => public, private, protected, default
 *
 *
 *
 *
 * */


public class Alien {
    String name;
    int age;

    String color;

    int height;


    //default Constructor
    public Alien() {
        name = "Ayaan";
        age = 22;
        color = "Brown";
        height = 5;
    }

    public Alien(String name, int age, String color, int height) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.height = height;
    }

    public void alienDetail() {
        //print detail
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Color: " + color);
        System.out.println("Height: " + height);
    }

    public static void printClassName(){
        System.out.println("Alien");
    }
}
