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
import iset.master.spring.model.Client;
import iset.master.spring.model.Detail_Entree;
import iset.master.spring.model.Detail_Sortie;
import iset.master.spring.model.Entree;
import iset.master.spring.model.Fournisseur;
import iset.master.spring.model.Magasin;
import iset.master.spring.model.Sortie;
import iset.master.spring.repository.ArticleRepository;
import iset.master.spring.repository.CategorieRepository;
import iset.master.spring.repository.ClientRepository;
import iset.master.spring.repository.Detail_SortieRepository;
import iset.master.spring.repository.EntreeRepository;
import iset.master.spring.repository.FournisseurRepository;
import iset.master.spring.repository.MagasinRepository;
import iset.master.spring.repository.SortieRepository;

@Controller
public class SortieController {
	
	@Autowired
	SortieRepository sortieRepository;
	@Autowired

	Detail_SortieRepository detail_sortieRepository;
	
	@Autowired
	  ArticleRepository articleRepository;

		@Autowired
	  CategorieRepository categorieRepository;
		@Autowired
		ClientRepository clientRepository;


	
		
		@Autowired
		MagasinRepository magasinRepository;
	
	@RequestMapping(value="/sortie")
	  public String entrees (Model model,
			  				  @RequestParam (name="page", defaultValue="0") int p,
			  				  @RequestParam (name="size", defaultValue="5") int s,
			  				  @RequestParam (name="motCle", defaultValue="") String mc)
	    {
		 
		Page<Sortie> pageSorties = sortieRepository.chercherSortie("%"+mc+"%", new PageRequest(p, s));
		  model.addAttribute("listeSorties", pageSorties.getContent());
		 int[] pages = new int[pageSorties.getTotalPages()];
		  model.addAttribute("pages", pages);
		  model.addAttribute("size", s);
		  model.addAttribute("pageCourante", p);
		  model.addAttribute("motCle", mc);
		  //List<Entree> listE=entreeRepository.findAll();
		 // model.addAttribute("listeE", listE);
		  return "sortie";
	  }

	@RequestMapping(value="/detailS",method=RequestMethod.GET)
	  public String detailEntree (Model model, Long id)
	  {
		  List<Detail_Sortie> DS=detail_sortieRepository.findByDetailSortie(id);
		 Sortie S =(Sortie) sortieRepository.findById(id).orElse(null);
		  model.addAttribute("sortie", S);
		  model.addAttribute("detail_sortie", DS);
		  return "detailSortie";
	  }
	
	  @RequestMapping(value="/NSortie",method=RequestMethod.GET)
	  public String formEntree (Model model)
	  {
		  
		  List<Client> f = clientRepository.findAll();
		  List<Magasin> m = magasinRepository.findAll();
		  List<Article> c = articleRepository.findAll();
		  int maxid =sortieRepository.maxSortie();
		  
		  model.addAttribute("article", c);
		  model.addAttribute("magasin", m);
		  model.addAttribute("client", f);
		  model.addAttribute("maxid", maxid);
		  return "formSortie";
	  }
	
}
