package online.mrsys.movierecommender.dao.impl;

import java.util.List;

import online.mrsys.common.dao.impl.BaseDaoHibernate;
import online.mrsys.movierecommender.dao.RatingDao;
import online.mrsys.movierecommender.domain.Movie;
import online.mrsys.movierecommender.domain.Rating;
import online.mrsys.movierecommender.domain.User;

public class RatingDaoHibernate extends BaseDaoHibernate<Rating> implements RatingDao {
	
    @Override
	public Rating findById(Integer id){
    	List<Rating> ratings = find("select r from Rating r where r.id = ?0", id);
		if (ratings != null && ratings.size() >= 1)
			return ratings.get(0);
		return null;
    }
	
	@Override
	public List<Rating> findByUser(User user) {
		return find("select r from Rating r where r.user = ?0", user);
	}

	@Override
	public List<Rating> findByMovie(Movie movie) {
		return find("select r from Rating r where r.movie = ?0", movie);
	}

    @Override
    public Rating findByUserAndMovie(User user, Movie movie) {
        List<Rating> ratings = find("select r from Rating r where r.user = ?0 and r.movie = ?1", user, movie);
        if (ratings != null && ratings.size() >= 1) {
            return ratings.get(0);
        }
        return null;
    }

}
