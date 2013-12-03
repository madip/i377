package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import view.UnitForm;
import dao.UnitDao;
import model.Unit;

@Controller
public class UnitController {

	@Resource
	private UnitDao dao;

	@RequestMapping("/")
	public String index() {
		return "redirect:/search";
	}

	@RequestMapping("/search")
	public String search(ModelMap model,
			@ModelAttribute("searchString") String searchString) {

		if (searchString.isEmpty()) {
			model.addAttribute("searchResults", dao.findAll());

		} else {
			model.addAttribute("searchResults",
					dao.searchByString(searchString));
		}

		return "search";
	}

	@RequestMapping("/delete/{unitCode}")
	public String delete(@PathVariable("unitCode") String unitCode) {

		dao.deleteByCode(unitCode);

		return "redirect:/search";
	}

	@RequestMapping(value = "/admin/clearData")
	public String deleteAll() {

		dao.deleteAll();

		return "redirect:/search";
	}

	@RequestMapping("/addForm")
	public String add(@ModelAttribute("unitForm") UnitForm form) {

		form.setUnits(dao.findAll());
		return "add";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("unitForm") UnitForm form) {

		dao.save(form.getUnit());

		return "redirect:/search";
	}

	@RequestMapping(value = "/view/{unitCode}")
	public String view(@ModelAttribute("unitForm") UnitForm form,
			@PathVariable("unitCode") String unitCode) {
		
		Unit u = dao.findByCode(unitCode);
		form.setUnit(u);
		String t = u.getSuperUnitId();
		
		if (!t.isEmpty())
			form.setSupUnit(dao.findByCode(t));
		form.setSubUnits(dao.findSubUnits(unitCode));
		form.setUnits(dao.findAll());

		return "view";
	}
}
