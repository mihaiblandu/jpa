package jpa.tutorial.jpa_repo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@NamedQueries(value = {
		@NamedQuery(name = "query_get_all_reviews",
				query = "Select  r  From Review r")
})
public class Review {

	@Id
	@GeneratedValue
	private Integer id;

	@Enumerated(EnumType.STRING)
	private ReviewRating rating;

	private String description;

	@ManyToOne
	@JsonIgnoreProperties("reviews")
	private Course course;

	protected Review() {
	}

	public Review(ReviewRating rating, String description) {
		this.rating = rating;
		this.description = description;
	}


}