package iset.master.spring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import iset.master.spring.model.Article;
import iset.master.spring.model.Detail_Entree;
import iset.master.spring.model.Detail_Sortie;
import iset.master.spring.model.Entree;
import iset.master.spring.repository.ArticleRepository;
import iset.master.spring.repository.Detail_EntreeRepository;
import iset.master.spring.repository.Detail_SortieRepository;

@Controller
public class StockController {
	
	@Autowired
	  ArticleRepository articleRepository;
	@Autowired
Detail_EntreeRepository detail_entreeRepository;
	@Autowired
	Detail_SortieRepository detail_SortieRepository;
	
	 @RequestMapping(value="/Stock")
	  public String articles (Model model,
				  @RequestParam (name="page", defaultValue="0") int p,
				  @RequestParam (name="size", defaultValue="5") int s,
				  @RequestParam (name="motCle", defaultValue="") String mc)
{

//Page<Article> pagearticles = articleRepository.chercherParMotCle("%"+mc+"%", new PageRequest(p, s));
		 Page<Object[]> pagearticles = articleRepository.stock("%"+mc+"%", new PageRequest(p, s));
		 int[] pages = new int[pagearticles.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		 
		// Object[][] pagearticles = articleRepository.stock();
		 for (Object[] row: pagearticles) {
			    System.out.println("ID: " + row[0]);
			    System.out.println("Désignation: " + row[1]);
			    System.out.println("Qté stock: " + row[2]);
			    System.out.println("prix: " + row[3]);
			    System.out.println("Somme: " + row[4]);
			    
			//      <span th:unless="${a[6] = null && a[5] != null}" th:text="${a[5]}"></span>

		 }

;
		 model.addAttribute("listeArticles", pagearticles);
return "EtatStock";


}

		
		
	 @RequestMapping(value="/mouvement",method=RequestMethod.GET)
	  public String detailEntree (Model model, Long id,
			  
			  @RequestParam (name="tsortie", defaultValue="0") double tsortie,
				  @RequestParam (name="tentree", defaultValue="0") double tentree 
			  
			  )
	  
	  
	  
	  
	  {
		  List<Detail_Entree> DE=detail_entreeRepository.findByDetailAEntree(id);
		  
		  List<Detail_Sortie> DS=detail_SortieRepository.findByDetailASortie(id);
		  
		  
		// Entree E =(Entree) entreeRepository.findById(id).orElse(null);
		  model.addAttribute("detail_sortie", DS);
		  model.addAttribute("detail_entree", DE);
		  model.addAttribute("tsortie", tsortie);
		  model.addAttribute("tentree", tentree);
		  return "mouvement";
	  }	  
		  
		  
	  

}
