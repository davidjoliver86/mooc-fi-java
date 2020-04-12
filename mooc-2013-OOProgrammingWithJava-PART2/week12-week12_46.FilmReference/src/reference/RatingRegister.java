/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author davido
 */
public class RatingRegister {
    
    Map<Film, List<Rating>> ratings;
    Map<Person, Map<Film, Rating>> personalRatings;
    
    public RatingRegister() {
        this.ratings = new HashMap<Film, List<Rating>>();
        this.personalRatings = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating) {
        if (this.ratings.get(film) == null) {
            this.ratings.put(film, new ArrayList<Rating>());
        }
        this.ratings.get(film).add(rating);
    }
    
    public void addRating(Person person, Film film, Rating rating) {
        if (this.personalRatings.get(person) == null) {
            this.personalRatings.put(person, new HashMap<Film, Rating>());
        }
        this.personalRatings.get(person).put(film, rating);
        this.addRating(film, rating);
    }
    
    public Rating getRating(Person person, Film film) {
        if (this.personalRatings.get(person) == null) {
            return Rating.NOT_WATCHED;
        }
        if (this.personalRatings.get(person).containsKey(film)) {
            return this.personalRatings.get(person).get(film);
        }
        else {
            return Rating.NOT_WATCHED;
        }
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (this.personalRatings.containsKey(person)) {
            return this.personalRatings.get(person);
        }
        return new HashMap<Film, Rating>();
    }
    
    public List<Person> reviewers() {
        return new ArrayList<Person>(this.personalRatings.keySet());
    }
    
    public List<Rating> getRatings(Film film) {
        return this.ratings.get(film);
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        return this.ratings;
    }
}
