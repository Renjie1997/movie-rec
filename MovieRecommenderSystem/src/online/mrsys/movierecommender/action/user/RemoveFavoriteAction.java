package online.mrsys.movierecommender.action.user;

import com.opensymphony.xwork2.ActionContext;

import online.mrsys.movierecommender.action.base.BaseAction;
import online.mrsys.movierecommender.action.base.WebConstant;
import online.mrsys.movierecommender.domain.Favorite;

public class RemoveFavoriteAction extends BaseAction {
    
    private static final long serialVersionUID = 3320036867922514503L;
    
    private Favorite favorite;

    public Favorite getFavorite() {
        return favorite;
    }

    public void setFavorite(Favorite favorite) {
        this.favorite = favorite;
    }

    @Override
    public String execute() throws Exception {
    	ActionContext actionContext = ActionContext.getContext();
		if (userManager.deleteFavorite(getFavorite())) {
			return SUCCESS;
		}
		actionContext.getSession().put(WebConstant.INTERCEPT, "Cannot remove favorite");
		return ERROR;
    }
    
}
