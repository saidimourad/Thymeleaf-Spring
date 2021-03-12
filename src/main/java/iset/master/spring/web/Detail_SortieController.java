package iset.master.spring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iset.master.spring.model.Detail_Entree;
import iset.master.spring.model.Detail_Sortie;
import iset.master.spring.model.Entree;
import iset.master.spring.model.Sortie;
import iset.master.spring.repository.Detail_EntreeRepository;
import iset.master.spring.repository.Detail_SortieRepository;
import iset.master.spring.repository.EntreeRepository;
import iset.master.spring.repository.FournisseurRepository;
import iset.master.spring.repository.MagasinRepository;
import iset.master.spring.repository.SortieRepository;

@RestController

@RequestMapping(value = "NSortie/api/sortie")

public class Detail_SortieController {
	
	@Autowired
	Detail_EntreeRepository detail_entreeRepository;
		@Autowired
		SortieRepository sortieRepository;
		@Autowired
		MagasinRepository magasinRepository;
		
		@Autowired
		FournisseurRepository fournisseurRepository;
		@Autowired
		Detail_SortieRepository detail_sortieRepository;

		
		@PostMapping(value="/save")
		
		
			public int postDsortie(@RequestBody List<Detail_Sortie> list,Model model){

				
			detail_sortieRepository.saveAll(list);
			return '1';
		}
		
		@PostMapping(value="/save2")
		public String postEntree(@RequestBody List<Sortie> list,Model model){

			for (Sortie p :list)
				{

					System.out.print("Designation:"+ p.getClass()+"  , ");
					//System.out.println("Prix:"+ p.getRef_entree());
				
				}
		
			sortieRepository.saveAll(list);
		
		return "Post Successfully!";


	}
		
		
		
		


}
