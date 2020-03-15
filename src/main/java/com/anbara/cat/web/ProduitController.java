package com.anbara.cat.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anbara.cat.dao.ProduitRepository;
import com.anbara.cat.entities.Produit;

@Controller
public class ProduitController {

	@Autowired
	ProduitRepository produitRepository;

//	@RequestMapping(value = "/index",method = RequestMethod.GET)
	@GetMapping(value = "/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "keyword", defaultValue = "") String keyword) {
		Page<Produit> produits = produitRepository
				.findByDesignationContains(keyword, PageRequest.of(page, 5));

		model.addAttribute("produits", produits.getContent());
		model.addAttribute("pages", new int[produits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword",keyword);
		return "produits";
	}
	@GetMapping(value = "/delete")
	public String delete( long id,int page, String keyword) {
		this.produitRepository.deleteById(id);
		return "redirect:/index?page="+page+"&keyword="+keyword;
	}
}
