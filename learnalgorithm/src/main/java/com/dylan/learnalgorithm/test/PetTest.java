package com.dylan.learnalgorithm.test;

/**
 * @author Dylan
 * @Date : Created in 17:15 2021/5/18
 * @Description :
 * @Function :
 */
public class PetTest {
    private String type;

    public PetTest(String type) {
        this.type = type;
    }

    public String getPetType(){
        return type;
    }

}
class Dog extends PetTest{
    public Dog(String type) {
        super(type);
    }
}
class Cat extends PetTest{
    public Cat(String type) {
        super(type);
    }
}

class Test{
    public static void main(String[] args) {
        Dog dog = new Dog("Dog");
        Cat cat = new Cat("Cat");
        System.out.println(dog.getPetType());
        System.out.println(cat.getPetType());
    }
}
