$( document ).ready(function() {
	
	var listCustomers = [];
	var formD=[];
	var Edata=[];


	/**
	 * Using JQuery for hiding some elements in view when bootstrap app
	 */
	// Hide customer table when starting
	// we just show it if having any adding-customer
	$('#customerTable').hide();
	$('#postCustomersBtnn').hide();
	
	// Customer-Form submit
    $("#customerForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
    	event.preventDefault();
    	 if($('#qte').val() == '' || $('#prix').val() == '' )
    	  {
    		 alert("donnés manquant!")
    	  }
    
    	
    	 else
    		 {
    	
    	
    	
	
		
		
		
		
		
		// get data from submit form
		
		var formCustomer = {
    			 // LibArticle: $("#article option:selected" ).text(),
    			
    			
				qteSortie : $("#qte").val(),
				prixSortie : $("#prix").val(),
				articleS : {
				id_art : $("#article").val()
						},
						sortieD:{
							id_sortie: $("#id_sortie").val()
				},
    			//address : {
    		    	//street : $("#street").val(),
    			
				D_art : $("#article option:selected").text()

    		    	
    		   // }
    	}
		
		// store customer
		listCustomers.push(formCustomer);
		listCustomers.splice(4, 2);
		//detail();

		var tot=0;
		// re-render customer table by append new customer to table
		//tot=qte*prix;
	//var totG=(formCustomer.qte * formCustomer.prix);
		//var totG=0;
		//var total += jQuery(this).val();
		/////
		
		//info = [];
		//info[0] = 'hi';
		//info[1] = 'hello';
////
		var customerRow = '<tr>' +
							'<td>' + listCustomers.length + '</td>' +
							'<td>' + formCustomer.articleS.id_art + '</td>' +
							'<td>' + formCustomer.D_art + '</td>' +
							'<td>' + formCustomer.qteSortie+  '</td>' +
							'<td>' + formCustomer.prixSortie+ '</td>' +
							'<td class="totalprice">' + formCustomer.qteSortie * formCustomer.prixSortie+ '</td>' +
					        '<td class="text-center">' +
					        	'<input type="hidden" value=' + (listCustomers.length - 1) + '>' +
					        	'<a>' +
					  				'<span class="glyphicon glyphicon-remove"></span>' +
								'</a>' +
					        '</td>' +
						  '</tr>';

	


		$('#customerTable tbody').append(customerRow);
		

		calcul();
	
		
		// just how customer table and POST button
		$('#customerTable').show();
		$('#postCustomersBtnn').show();
		
		// Reset FormData after Posting
    	resetData();
    		 }
	});
    
	// Do DELETE a Customer via JQUERY AJAX
	$(document).on("click","a",function() {
		var customerId = $(this).parent().find('input').val();
		$(this).closest("tr").remove()
		calcul();
	});
	
	// Submit List of Customer to Back-End server
	$('#postCustomersBtnn').click(function(){
		
		
		 if($('#date').val() == ''  )
   	  {
   		 alert("donnés manquant!")
   	  }
   
   	
   	 else
   		 {
		
		
		var formd = {
				 ref_sortie : $('#ref').val(),
				date_sortie : $('#date').val(),
				prixTotal_sortie:$('#totG').val(),
			       magasin:{
				    	  id_magasin: $('#magasin').val()
		    		    	
				},
				 client:
		    	  {
		    	  id: $('#client').val()
		    	  }
		 
    		   // }
    	}
		formD.push(formd);
		
		
		//Edata=[formD,listCustomers];
		ajaxPostDetail();
				ajaxPost();
   		 }
				
	});
	
    function ajaxPost(){
    	var prix_total_entree=20;
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
		    //  contentType:"application/json;charset=utf-8", 

			accept: 'text/plain',
			url : window.location + "/api/sortie/save",

			//url : window.location + "/EnregistrerEntree",
//	data : JSON.stringify(Edata),
			data : JSON.stringify(listCustomers),
			//data : listCustomers,
			// data: {info:info},
			//data : prix_total_entree ,
			//		var date_entree = $('#date').val() ,
				//	var prix_total_entree=$('#totG').val(),
					//var ref_entree = $('#ref').val() ,
				//	var id_fr= $('#fournisseur').val(),
				//	var id_magasin= $('#magasin').val()
					
			    		
	    
	    					
		//	),
		    //  dataType :"application/json;charset=utf-8", 

			dataType: 'text',
			//dataType : 'json',
			success : function(result) {
				// clear customer body
				$('#customerTable tbody').empty();
				$('#customerTable').hide();
				
				// re-set customer table list
				Edata=[];
				listCustomers = [];
				formD=[];
		
				// fill successfully message on view
			//	$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
				//							result +
					//					  "</p>");
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    }
    
    
    function ajaxPostDetail(){
    
    	$.ajax({
			type : "POST",
			contentType : "application/json",
		    //  contentType:"application/json;charset=utf-8", 

			accept: 'text/plain',
			url : window.location + "/api/sortie/save2",

			data : JSON.stringify(formD),
						    		
			dataType: 'text',
			success : function(result) {
			//	alert("insertion effectué!")

				 window.location = "/sortie"
				// clear customer body
				$('#customerTable tbody').empty();
				$('#customerTable').hide();
					
				// fill successfully message on view
			//	$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
				//						result +
					//				  "</p>");
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    }
    
    
    function resetData(){
    	//$("#article").val("");
    	$("#qte").val("");
    	$("#prix").val("");
    	//$("#postcode").val("");
    }
    
    function calcul()
    {
    	
    	var sum = 0;
		$('.totalprice').each(function()
		{
		    sum += parseFloat($(this).text());
		});
		$('#totG').val(sum);
    	
    }
    
    function detail(){
    	
    	
    	var  date_entree = $('#date').val();
    	 var prix_total_entree=$('#totG').val();
    	  var ref_entree = $('#ref').val();
    		var id_fr= $('#fournisseur').val();
    		var id_magasin= $('#magasin').val();
    	
    	  
    }
    
})