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
import iset.master.spring.model.Entree;
import iset.master.spring.model.Fournisseur;
import iset.master.spring.model.Magasin;
import iset.master.spring.repository.ArticleRepository;
import iset.master.spring.repository.CategorieRepository;
import iset.master.spring.repository.Detail_EntreeRepository;
import iset.master.spring.repository.EntreeRepository;
import iset.master.spring.repository.FournisseurRepository;
import iset.master.spring.repository.MagasinRepository;

@Controller
public class EntreeController {

	@Autowired
Detail_EntreeRepository detail_entreeRepository;
	@Autowired
	EntreeRepository entreeRepository;
	@Autowired
	  ArticleRepository articleRepository;

		@Autowired
	  CategorieRepository categorieRepository;


		
		@Autowired
		FournisseurRepository fournisseurRepository;
		
		@Autowired
		MagasinRepository magasinRepository;
	
	
	@RequestMapping(value="/detailE",method=RequestMethod.GET)
	  public String detailEntree (Model model, Long id)
	  {
		  List<Detail_Entree> DE=detail_entreeRepository.findByentree(id);
		 Entree E =(Entree) entreeRepository.findById(id).orElse(null);
		  model.addAttribute("entree", E);
		  model.addAttribute("detail_entree", DE);
		  return "detailEntree";
	  }
	
	  @RequestMapping(value="/entree")
	  public String entrees (Model model,
			  				  @RequestParam (name="page", defaultValue="0") int p,
			  				  @RequestParam (name="size", defaultValue="5") int s,
			  				  @RequestParam (name="motCle", defaultValue="") String mc)
	    {
		 
		Page<Entree> pageEntrees = entreeRepository.chercherEntree("%"+mc+"%", new PageRequest(p, s));
		  model.addAttribute("listeEntrees", pageEntrees.getContent());
		 int[] pages = new int[pageEntrees.getTotalPages()];
		  model.addAttribute("pages", pages);
		  model.addAttribute("size", s);
		  model.addAttribute("pageCourante", p);
		  model.addAttribute("motCle", mc);
		  //List<Entree> listE=entreeRepository.findAll();
		 // model.addAttribute("listeE", listE);
		  return "entree";
	  }
	  
	  @RequestMapping(value="/NEntree",method=RequestMethod.GET)
	  public String formEntree (Model model)
	  {
		  
		  List<Fournisseur> f = fournisseurRepository.findAll();
		  List<Magasin> m = magasinRepository.findAll();
		  List<Article> c = articleRepository.findAll();
		  int maxid =entreeRepository.maxEntree();
		  
		  model.addAttribute("article", c);
		  model.addAttribute("magasin", m);
		  model.addAttribute("fournisseur", f);
		  model.addAttribute("maxid", maxid);
		  return "formEntree";
	  }
	  
	
}
