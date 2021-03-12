package iset.master.spring.web;





import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import iset.master.spring.model.Article;
import iset.master.spring.model.Categorie;
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
public class ArticleController {


	@Autowired
  ArticleRepository articleRepository;

	@Autowired
  CategorieRepository categorieRepository;
	
	@Autowired
 EntreeRepository entreeRepository;
	
	@Autowired
Detail_EntreeRepository detail_entreeRepository;
	
	@Autowired
	FournisseurRepository fournisseurRepository;
	
	@Autowired
	MagasinRepository magasinRepository;
	
	
	
  @RequestMapping(value="/index")
  public String articles (Model model,
		  				  @RequestParam (name="page", defaultValue="0") int p,
		  				  @RequestParam (name="size", defaultValue="5") int s,
		  				  @RequestParam (name="motCle", defaultValue="") String mc)
    {
	 
	Page<Article> pagearticles = articleRepository.chercherParMotCle("%"+mc+"%", new PageRequest(p, s));
	  model.addAttribute("listeArticles", pagearticles.getContent());
	  int[] pages = new int[pagearticles.getTotalPages()];
	  model.addAttribute("pages", pages);
	  model.addAttribute("size", s);
	  model.addAttribute("pageCourante", p);
	  model.addAttribute("motCle", mc);
	  return "article";
  }
  
  
  
  
  @RequestMapping(value="/delete",method=RequestMethod.GET)
  public String delete (Long id, int page, int size, String motCle)
  {
	  articleRepository.deleteById(id);
	  return "redirect:/index?page="+page+"&size="+size+"&motCle="+motCle;
  }
  
  @RequestMapping(value="/form",method=RequestMethod.GET)
  public String formArticle (Model model)
  {
	 List<Categorie> c=categorieRepository.findAll();
	  model.addAttribute("article", new Article());
	  model.addAttribute("categorie", c);
	  return "formArticle";
  }

  
  @RequestMapping(value="/edit",method=RequestMethod.GET)
  public String edit (Model model, Long id)
  {
	  List<Categorie> c=categorieRepository.findAll();
	  Article p =(Article) articleRepository.findById(id).orElse(null);
	  model.addAttribute("article", p);
	  model.addAttribute("categorie", c);
	  return "editArticle";
  }
  
  @RequestMapping(value="/save",method=RequestMethod.POST)
  public String save (Model model, @Valid Article article , BindingResult bindingResult)
  {
	  if (bindingResult.hasErrors())
	  //{
		  
		// List<Categorie> c=categorieRepository.findAll();
		 // model.addAttribute("article", new Article());
		//  model.addAttribute("categorie", c);
  //}
		  
		  return "formArticle";
	 articleRepository.save(article);
	  return "redirect:/index";
	 // return "confirmation";
  }
  
  

  
  
  
  @RequestMapping(value="/AjoutEntree",method=RequestMethod.GET)
  public String formAjEntree (Model model)
  {
	  

	
	  List<Article> c = articleRepository.findAll();
	  
	  model.addAttribute("article", c);

	  
	  return "formEntree";
  }
  
@RequestMapping(value="NEntree/EnregistrerEntree")
 // @PostMapping(value="/save")

 public String formEnEntree(@RequestBody List<Detail_Entree> customers ) 
 {
	 List<Detail_Entree>  cust = new ArrayList<Detail_Entree>();
	 
	 cust.addAll(customers);
	 detail_entreeRepository.saveAll(customers);
	 

				 return "formEntree";
		}
	  
	  
	  
	  
	    
  @RequestMapping(value="/")

  public String home ()

  {

	  return "redirect:/index";

     }

}
