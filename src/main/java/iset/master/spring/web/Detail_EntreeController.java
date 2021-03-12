package iset.master.spring.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import iset.master.spring.model.Article;
import iset.master.spring.model.Categorie;
import iset.master.spring.model.Detail_Entree;
import iset.master.spring.model.Entree;
import iset.master.spring.model.Fournisseur;
import iset.master.spring.model.Magasin;
import iset.master.spring.repository.Detail_EntreeRepository;
import iset.master.spring.repository.EntreeRepository;
import iset.master.spring.repository.FournisseurRepository;
import iset.master.spring.repository.MagasinRepository;


@RestController

@RequestMapping(value = "NEntree/api/entree", method=RequestMethod.POST)
//,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, 
//method = RequestMethod.POST, 
//consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}) 
//@RequestMapping("NEntree/api/customer")
public class Detail_EntreeController {
	
	
	@Autowired
Detail_EntreeRepository detail_entreeRepository;
	@Autowired
	EntreeRepository entreeRepository;
	@Autowired
	MagasinRepository magasinRepository;
	
	@Autowired
	FournisseurRepository fournisseurRepository;

	//@RequestMapping(value = "NEntree/api/entree/save", method = RequestMethod.POST)

	@PostMapping(value="/save")
	
	
		public int postCustomer(@RequestBody List<Detail_Entree> list,Model model){

			
		detail_entreeRepository.saveAll(list);
		return '1';
	}
	
	//@RequestMapping(value = "NEntree/api/entree/save2", method = RequestMethod.POST)

	@PostMapping(value="/save2")
	public String postEntree(@RequestBody List<Entree> list,Model model){

		for (Entree p :list)
			{

				System.out.print("Designation:"+ p.getClass()+"  , ");
				System.out.println("Prix:"+ p.getRef_entree());
			
			}
	
	entreeRepository.saveAll(list);
	
	return "Post Successfully!";


}
	
	
	
	

	
}
	       // public String formEnEntree(@RequestBody Detail_Entree listCustomers ) 
	       // public String formEnEntree(@RequestBody Detail_Entree detail_Entree ,
	          // public String formEnEntree(@RequestBody List<Object[][]> listCustomers)
	//public String formEnEntree( List<Object[][]> listCustomers)
	
	//1public String formEnEntree(@RequestBody List<Detail_Entree> customers,Model model ) 
	 //1{
		//1 List<Detail_Entree>  cust = new ArrayList<Detail_Entree>();
		 
		 ///1cust.addAll(customers);
		 //1detail_entreeRepository.saveAll(customers);
		 
		 //cust.addAll(customers);
		// detail_entreeRepository.saveAll(customers);
			// @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			  //  @RequestParam Date  date_entree, 
				//@RequestParam Double prix_total_entree,
				//@RequestParam String ref_entree,
				//@RequestParam Long id_fr, 
				//@RequestParam Long id_magasin,
				
						// Model model) 
	 
 
	 
	 //public String formEnEntree(@RequestParam(value = "listCustomers") List<Detail_Entree> detail_Entree ,Model model) 

	// {
		// for (Object[][] row: listCustomers) {
		
	//    System.out.println("ID: " +  cust.get(1));
		 //}

		//@RequestParam(value = "arrayParam") List<String> arrayParam) 
		//for (Detail_Entree p : detail_Entree)
		//{
			//System.out.print("Designation:"+ p.getClass()+"  , ");
			//System.out.println("Prix:"+ p.getPrix());
		//}

		// Detail_Entree  detail = new(Detail_Entree) ;
		 
		// cust.addAll(customers);
		
		// detail_entreeRepository.save(detail_Entree);
		
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	          //  Date date = null;
			//	try {
				//	date = formatter.parse(date_entree);
				//} catch (ParseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//}
		 
		// Magasin magasin= magasinRepository.findById(id_magasin).orElse(null);;
		 //Fournisseur fournisseur=fournisseurRepository.findById(id_fr).orElse(null);;
   
	                //  Date date_entrees = new Date();
		            //   Double prix_total_entrees = 12.210;

	               // Double prix_total_entrees = Double.parseDouble(prix_total_entree);
	    //Entree newEntree = new Entree();
	    //newEntree.setDate_entree( date_entree );
	    //newEntree.setFournisseur(fournisseur);
	  	//newEntree.setPrixTotal_entree(prix_total_entree);
	    //newEntree.setMagasin(magasin);
	    //newEntree.setRef_entree(ref_entree);
	 	  //   entreeRepository.save(newEntree);

	 //detail_entreeRepository.save(listCustomers);
		 

		//int size = detail_Entree.size();
		//int counter = 0;
		// listCustomers
		//List<Detail_Entree> temp = new ArrayList<>();
				
		//for (Detail_Entree emp : detail_Entree)
			//{
				
				
					//temp.add(emp);
					
					//if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
					//	detail_entreeRepository.saveAll(detail_entrees);
						//temp.clear();
			//}
					//counter++;
			//}
		
		
		//1 return "redirect:/index";
			//}
	// }
//1}
	 
