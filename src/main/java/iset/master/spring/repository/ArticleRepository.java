package iset.master.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iset.master.spring.model.Article;
import iset.master.spring.model.Categorie;
import iset.master.spring.model.Detail_Entree;


public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	@Query ("select a from Article a where a.designation_art like :x ")
	public Page<Article> chercherParMotCle (@Param ("x") String mc,	Pageable pageable);
	
	
//	@Query (" SELECT c.designation_cat, a.designation_art, a.qte_stock, SUM(e.qteEntre) as Detail_Entree , SUM(s.qteSortie) as Detail_Sortie FROM Categorie c, Article a,  Detail_Entree e  , Detail_Sortie s WHERE c.id = a.categorie and  a.id=e.articles and  a.id=s.articles  group by a.designation_art ") 

		
		//@Query ("select a from Article a where a.designation_art like :x ")
		//public Page<Article> Stock (@Param ("x") String mc,	Pageable pageable);
//@Query ("select a from Article a where a.designation_art like :x ")
	//@Query ("select a, e from Article a, Detail_Entree e  group by a.designation_art") 
		
//@Query (" SELECT c.designation_cat, a.designation_art, a.qte_stock, SUM(e.qteEntre) as Detail_Entree , SUM(s.qteSortie) as Detail_Sortie FROM Categorie c, Article a,  Detail_Entree e  , Detail_Sortie s WHERE c.id = a.categorie and  a.id=e.articles and  a.id=s.articles  group by a.designation_art ") 

	//public List<Article> Stock();


//public Page<Article> Stock(@Param ("x") String mc,	Pageable pageable);


//@Query (
  //      value = "(SELECT SUM(points) FROM (SELECT COUNT(topic.id_user) AS points FROM topic WHERE topic.id_user = :id" +
    //            " UNION ALL SELECT 2 * COUNT(answer.id_user) AS points FROM answer WHERE answer.id_user = :id UNION ALL " +
      //          "SELECT 3 * COUNT(answer.id_user) AS points FROM answer WHERE answer.id_user = :id AND answer.useful = TRUE) t)",
                
                
                
        //nativeQuery = true
 //   )
   // Long getPoints(@Param("id") Long id);

	 //@Query("SELECT n, a FROM Newsletter n JOIN n.admin a WHERE n.state != :state AND n.sendTime < :date ORDER BY n.sendTime ASC")
	//@Query ("select a, e from Article a , Detail_Entree e  group by a.designation_art") 
	//@Query (" SELECT  a.designation_art, a.qte_stock , a.prix_art, a.id_art, a.categorie from Article a  group by a.designation_art ") 

	//@Query ("SELECT a, e, s from Article a  JOIN  Detail_Entree e on a.id_art=e.id_detaile  JOIN Detail_Sortie s on a.id_art=s.id_DetailS group by a.designation_art") 
//	@Query ("SELECT a, e from Article a  JOIN  Detail_Entree e on a.id_art=e.id_detaile   group by a.designation_art") 
	
//@Query("SELECT p.firstName, p.lastName, n.phoneNumber FROM Person p LEFT JOIN PhoneBookEntry n ON p.firstName = n.firstName AND p.lastName = n.lastName").getResultList();
//@Query (" SELECT  a.designation_art, a.qte_stock , a.prix_art, a.id_art, a.categorie,SUM(e.qteEntre) from Article a JOIN  Detail_Entree e on a.id_art=e.id_detaile ") 

//@Query (value =" SELECT  a  from Article a JOIN  Detail_Entree e on a.id_art=e.id_detaile ") 
@Query (value = "SELECT a.id_art, a.designation_art, a.qte_stock , a.prix_art,  a.id, SUM(e.qte_entre), SUM(s.qte_sortie) from article a LEFT JOIN  detail_entree e on a.id_art=e.id_art LEFT JOIN  Detail_Sortie s on a.id_art=s.id_art where a.designation_art like :x  group by a.designation_art",  nativeQuery = true)

public Page<Object[]> stock(@Param ("x") String mc, Pageable pageable);

//public Object[][] stock();
} 
