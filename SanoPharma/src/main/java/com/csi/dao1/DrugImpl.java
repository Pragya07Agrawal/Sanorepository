package com.csi.dao1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csi.dao.DrugDao;

import com.csi.model.Drug;
@Component
public class DrugImpl implements DrugDao {
	@Autowired
	JdbcTemplate jdbcTemplate;


	public static final String selectSQL = "select * from drug";
	private static final String updateSQL = "update drug set drugName=? where drugId=?";
	private static final String deleteSQL = "delete from drug where drugId=?";


	@Override
	public List<Drug> getDrugData() {
		// TODO Auto-generated method stub
		List<Drug> drugs = new ArrayList<Drug>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectSQL);

		for (Map<String, Object> row : rows) {
			Drug drug = new Drug();
			drug.setDrugId((int) row.get("drugId"));
			drug.setDrugName((String) row.get("drugName"));

			drug.setDrugDescription((String) row.get("drugDescription"));

			drug.setDrugHeal((String) row.get("drugHeal"));

						drugs.add(drug);
		}
		return drugs;
	


	}

	@Override
	public void saveDrugData(Drug drug) {
		// TODO Auto-generated method stub
		jdbcTemplate.execute(
				"insert into drug(drugId,drugName,drugDescription, drugHeal)values('"
						+ drug.getDrugId() + "','" + drug.getDrugName() + "', '"
						+ drug.getDrugDescription()+ "','" + drug.getDrugHeal() 
						+ "')");
	}
		
	

	@Override
	public void updateDrugData(int drugId, Drug drug) {
		jdbcTemplate.update(updateSQL, drug.getDrugName(), drugId);
	}
		
		
	
		
	

	@Override
	public void deleteDrug(int drugId) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(deleteSQL, drugId);
		
	}}
