package com.csi.controller;

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



import com.csi.dao1.MrImpl;
import com.csi.model.Drug;
import com.csi.model.MR;

@RestController
@RequestMapping("/ap")
public class Mrcontroller {
	
	@Autowired
	MrImpl mrimpl;
	@GetMapping("/getdata1")
	public List<MR> getData() {

		return mrimpl.getMrData();
	}

	@PostMapping("/savedata1")
	public String saveData(@RequestBody MR mr) {
		mrimpl.saveMrData(mr);

		return "save data successfully";
	}

	@PutMapping("/updatedata/{mrId}")
	public String updateData(@PathVariable("mrId") int mrId, @RequestBody MR mr) {
		mrimpl.updateMrData(mrId, mr);
		return "update data successfully";
	}

	@DeleteMapping("/deletedata/{drugId}")
	public String deleteData(@PathVariable("mrId") int mrId) {
		mrimpl.deleteMrData(mrId);
		return "delete data successfully";
	}
}

	