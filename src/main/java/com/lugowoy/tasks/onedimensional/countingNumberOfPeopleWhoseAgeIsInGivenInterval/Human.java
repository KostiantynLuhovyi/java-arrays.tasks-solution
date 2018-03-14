package com.lugowoy.tasks.onedimensional.countingNumberOfPeopleWhoseAgeIsInGivenInterval;

import com.lugowoy.helper.other.DeepCloning;

import java.io.Serializable;
import java.util.Objects;

/** Created by Konstantin Lugowoy on 14.05.2017. */

public class Human implements Serializable, Cloneable {

    private String name;
    private int age;

    public Human() {
     this.name = "name";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getAge() == human.getAge() &&
                Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getAge());
    }

    @Override
    public String toString() {
        return "Human[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ']';
    }

    @Override
    public Human clone() {
        Human human = new Human();
        try {
            human = (Human) super.clone();
            human.setAge(this.getAge());
            human.name = DeepCloning.CLONER.deepClone(this.name);
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return human;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.name = this.name + age;
    }



}
