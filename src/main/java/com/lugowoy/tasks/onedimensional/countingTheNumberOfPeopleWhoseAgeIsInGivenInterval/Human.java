package com.lugowoy.tasks.onedimensional.countingTheNumberOfPeopleWhoseAgeIsInGivenInterval;

/** Created by Konstantin Lugowoy on 14.05.2017. */

public class Human {

    private String name;
    private int age;

    public Human() {
     this.name = "name";
    }

    @Override
    public String toString() {
        return "Human[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ']';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.name = this.name + age;
    }

}
