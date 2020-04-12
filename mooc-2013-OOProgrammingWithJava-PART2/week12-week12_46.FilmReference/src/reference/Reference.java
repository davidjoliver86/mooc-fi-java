/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author davido
 */
public class Reference {
    
    private RatingRegister ratingRegister;

    public Reference(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }
    
    private Film getHighestRatedFilm() {
        // get the overall highest rated film
        Map<Film, List<Rating>> ratings = ratingRegister.filmRatings();
        List<Film> films = new ArrayList<Film>(ratings.keySet());
        Collections.sort(films, new FilmComparator(ratingRegister.filmRatings()));
        return films.get(0);
    }
    
    public Film recommendFilm(Person person) {
        if (this.ratingRegister.personalRatings.get(person) == null) {
            return getHighestRatedFilm();
        }
        // find person with best similarity in taste
        Person mostSimilar = getMostSimilarTastes(person);
        if (mostSimilar == null) {
            return null;
        }
        return recommendFilm(person, mostSimilar);
    }
    
    private Film recommendFilm(Person recomendee, Person recommender) {
        // film recommended should be the highest rated one the recommendee has seen
        // that the asker has not
        Map<Film, Rating> recommendeeSeen, recommenderSeen;
        recommendeeSeen = this.ratingRegister.getPersonalRatings(recomendee);
        recommenderSeen = this.ratingRegister.getPersonalRatings(recommender);
        Film bestFilm = null;
        
        // anything film with a negative score isn't worth recommending
        int bestRatingValue = Rating.NOT_WATCHED.getValue();
        
        for (Film film : recommenderSeen.keySet()) {
            // they've already seen this movie
            if (recommendeeSeen.containsKey(film)) {
                continue;
            }
            if (recommenderSeen.get(film).getValue() > bestRatingValue) {
                bestFilm = film;
            }
        }
        return bestFilm;
    }

    private Person getMostSimilarTastes(Person person) {
        Map<Person, Integer> similarities = new HashMap<Person, Integer>();
        Map<Film, Rating> myRatings = this.ratingRegister.getPersonalRatings(person);
        for (Person reviewer : this.ratingRegister.reviewers()) {
            int similarityScore = 0;
            if (reviewer.equals(person)) {
                continue;
            }
            Map<Film, Rating> reviewerRatings = this.ratingRegister.getPersonalRatings(reviewer);
            for (Film film : myRatings.keySet()) {
                if (reviewerRatings.containsKey(film)) {
                    similarityScore += (myRatings.get(film).getValue() * reviewerRatings.get(film).getValue());
                }
            }
            similarities.put(reviewer, similarityScore);
        }
        // return highest score
        if (similarities.isEmpty()) {
            return null;
        }
        List<Person> persons = new ArrayList<Person>(similarities.keySet());
        Collections.sort(persons, new PersonComparator(similarities));
        return persons.get(0);
    }

}
