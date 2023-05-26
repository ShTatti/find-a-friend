package by.fpmibsu.findafriend.controller.models;

import by.fpmibsu.findafriend.entity.AnimalAdvert;
import by.fpmibsu.findafriend.entity.Place;

import java.util.Date;

public class AnimalAdvertModel {
    public int advertId;
    public int userId;
    public String title;
    public String description;
    public String animalType;
    public Date creationDate;
    public Place place;
    public Date birthDate;
    public char sex;
    public boolean isCastrated;
    public int shelterId;
    public String shelterName;

    public AnimalAdvertModel(int advertId, int userId, String title, String description,
                             String animalType, Date creationDate, Place place, Date birthDate,
                             char sex, boolean isCastrated, int shelterId, String shelterName) {
        this.advertId = advertId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.animalType = animalType;
        this.creationDate = creationDate;
        this.place = place;
        this.birthDate = birthDate;
        this.sex = sex;
        this.isCastrated = isCastrated;
        this.shelterId = shelterId;
        this.shelterName = shelterName;
    }

    public static AnimalAdvertModel of(AnimalAdvert animalAdvert, int shelterId, String shelterName) {
        return new AnimalAdvertModel(
                animalAdvert.getId(),
                animalAdvert.getOwner().getId(),
                animalAdvert.getTitle(),
                animalAdvert.getDescription(),
                animalAdvert.getAnimalType(),
                animalAdvert.getCreationDate(),
                animalAdvert.getPlace(),
                animalAdvert.getBirthdate(),
                animalAdvert.getSex().getValue(),
                animalAdvert.isCastrated(),
                shelterId,
                shelterName
        );
    }
}