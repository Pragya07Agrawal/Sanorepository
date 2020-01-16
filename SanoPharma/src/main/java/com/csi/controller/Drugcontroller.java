package com.csi.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.csi.dao.DrugDao;
import com.csi.dao1.DrugImpl;
import com.csi.model.Drug;


@RestController
public class Drugcontroller {
	
	@RestController
	@RequestMapping("/api")
	public class Mrcontroller {
		
		@Autowired
		DrugImpl drugimpl;
		@GetMapping("/getdata")
		public List<Drug> getData() {
       return drugimpl.getDrugData();
		}

		@PostMapping("/savedata")
		public String saveData(@RequestBody Drug drug) {
			drugimpl.saveDrugData(drug);

			return "save data successfully";
		}

		@PutMapping("/updatedata/{drugId}")
		public String updateData(@PathVariable("drugId") int drugId, @RequestBody Drug drug) {
			drugimpl.updateDrugData(drugId, drug);
			return "update data successfully";
		}

		@DeleteMapping("/deletedata/{drugId}")
		public String deleteData(@PathVariable("drugId") int drugId) {
			drugimpl.deleteDrug(drugId);
			return "delete data successfully";
		}
	}

		

}
