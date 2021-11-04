package ru.job4j.stream;

public class Cat {
    private String name;
    private int age;
    private String gender;
    private String breed;
    private String hairColor;
    private String eyeColor;
    private int weight;

    @Override
    public String toString() {
        return "Cat{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", gender='" + gender + '\''
                + ", breed='" + breed + '\''
                + ", hairColor='" + hairColor + '\''
                + ", eyeColor='" + eyeColor + '\''
                + ", weight=" + weight
                + '}';
    }

    static class Builder {
        private String name;
        private int age;
        private String gender;
        private String breed;
        private String hairColor;
        private String eyeColor;
        private int weight;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildAge(int age) {
            this.age = age;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Builder buildBreed(String breed) {
            this.breed = breed;
            return this;
        }

        Builder buildHairColor(String hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        Builder buildEyeColor(String eyeColor) {
            this.name = eyeColor;
            return this;
        }

        Builder buildWeight(int weight) {
            this.weight = weight;
            return this;
        }

        Cat build() {
            Cat cat = new Cat();
            cat.age = age;
            cat.breed = breed;
            cat.eyeColor = eyeColor;
            cat.hairColor = hairColor;
            cat.name = name;
            cat.gender = gender;
            cat.weight = weight;
            return cat;

        }
    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        Cat cat = builder.buildName("Musya")
                .buildAge(3)
                .buildBreed("British")
                .buildGender("Girl")
                .buildHairColor("Grey")
                .buildEyeColor("Blue")
                .buildWeight(5)
                .build();
        System.out.println(cat);
    }

}
