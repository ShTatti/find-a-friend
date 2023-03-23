package by.fpmibsu.find_a_friend.entity;

import java.util.List;

public class Shelter {
    private int id;
    private String name;
    private List<User> administrators;
    private List<AnimalAdvert> animalAdverts;
    private Place place;

    public Shelter(int id, String name, List<User> administrators, List<AnimalAdvert> animalAdverts, Place place) {
        this.id = id;
        this.name = name;
        this.administrators = administrators;
        this.animalAdverts = animalAdverts;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<User> administrators) {
        this.administrators = administrators;
    }

    public List<AnimalAdvert> getAnimalAdverts() {
        return animalAdverts;
    }

    public void setAnimalAdverts(List<AnimalAdvert> animalAdverts) {
        this.animalAdverts = animalAdverts;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
