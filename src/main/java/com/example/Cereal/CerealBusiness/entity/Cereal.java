package com.example.Cereal.CerealBusiness.entity;

import javax.persistence.*;

@Entity
@Table(name="cereals")
public class Cereal {
    private  int sodium;
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue Not sure if this is needed. Will automatically be created in database as Serial.

    private int id;

    @Column(name ="brandname")
    private String brandname;
    @Column(name ="mfr")
    private String mfr;
    @Column(name="type")
    private String type;

    public Cereal() {

    }

    public Cereal(String brandname) {
        this.brandname = brandname;
    }

    public Cereal(String brandname, String mfr, String type, int calories, int protein, int fat, int sodium, int fiber, int carbo, int sugars, int potass, int vitamins, int shelf, int weight, float cups, String rating) {
        this.brandname = brandname;
        this.mfr = mfr;
        this.type = type;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.fiber = fiber;
        this.carbo = carbo;
        this.sugars = sugars;
        this.potass = potass;
        this.vitamins = vitamins;
        this.shelf = shelf;
        this.weight = weight;
        this.cups = cups;
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "CerealEntity{" +
                "id=" + id +
                ", brandname='" + brandname + '\'' +
                ", mfr='" + mfr + '\'' +
                ", type='" + type + '\'' +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", fiber=" + fiber +
                ", carbo=" + carbo +
                ", sugars=" + sugars +
                ", potass=" + potass +
                ", vitamins=" + vitamins +
                ", shelf=" + shelf +
                ", weight=" + weight +
                    ", cups=" + cups +
                ", rating=" + rating +
                '}';
    }

    public Cereal(int id, String brandname, String mfr, String type, int calories, int protein, int fat, int sodium, int fiber, int carbo, int sugars, int potass, int vitamins, int shelf, int weight, float cups, String rating) {
        this.id = id;
        this.brandname = brandname;
        this.mfr = mfr;
        this.type = type;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.fiber = fiber;
        this.carbo = carbo;
        this.sugars = sugars;
        this.potass = potass;
        this.vitamins = vitamins;
        this.shelf = shelf;
        this.weight = weight;
        this.cups = cups;
        this.rating = rating;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getFiber() {
        return fiber;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }

    public int getCarbo() {
        return carbo;
    }

    public void setCarbo(int carbo) {
        this.carbo = carbo;
    }

    public int getSugars() {
        return sugars;
    }

    public void setSugars(int sugars) {
        this.sugars = sugars;
    }

    public int getPotass() {
        return potass;
    }

    public void setPotass(int potass) {
        this.potass = potass;
    }

    public int getVitamins() {
        return vitamins;
    }

    public void setVitamins(int vitamins) {
        this.vitamins = vitamins;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getCups() {
        return cups;
    }

    public void setCups(float cups) {
        this.cups = cups;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Column(name="calories")
    private int calories;
    @Column
    private int protein;
    @Column
    private int fat;
    @Column
    private int fiber;
    @Column
    private int carbo;
    @Column
    private int sugars;
    @Column
    private int potass;
    @Column
    private int vitamins;
    @Column
    private int shelf;
    @Column
    private int weight;


    @Column(name="cups")
    private float cups;
    @Column(name="rating")
    private String rating;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
