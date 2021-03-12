package iset.master.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iset.master.spring.model.Article;
import iset.master.spring.model.Categorie;
import iset.master.spring.repository.ArticleRepository;
import iset.master.spring.repository.CategorieRepository;
@Controller
public class CategorieController {
	
	
	@Autowired
	CategorieRepository categorieRepository;
	
	 @RequestMapping(value="/categorie")
	  public String articles (Model model,
			  				  @RequestParam (name="page", defaultValue="0") int p,
			  				  @RequestParam (name="size", defaultValue="5") int s,
			  				  @RequestParam (name="motCle", defaultValue="") String mc)
	    {
		 
		Page<Categorie> pagearticles = categorieRepository.chercherParMotCle("%"+mc+"%", new PageRequest(p, s));
		  model.addAttribute("listecategories", pagearticles.getContent());
		  int[] pages = new int[pagearticles.getTotalPages()];
		  model.addAttribute("pages", pages);
		  model.addAttribute("size", s);
		  model.addAttribute("pageCourante", p);
		  model.addAttribute("motCle", mc);
		  return "categorie";
	  }
	  

}
