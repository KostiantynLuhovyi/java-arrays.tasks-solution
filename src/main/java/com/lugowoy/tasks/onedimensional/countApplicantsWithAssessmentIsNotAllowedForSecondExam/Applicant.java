package com.lugowoy.tasks.onedimensional.countApplicantsWithAssessmentIsNotAllowedForSecondExam;

import java.io.Serializable;

/** Created by Konstantin Lugowoy on 23-Feb-17. */

public class Applicant implements Serializable {

    private int rating;

    public Applicant(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Applicant[" +
                "rating=" + rating +
                ']';
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
