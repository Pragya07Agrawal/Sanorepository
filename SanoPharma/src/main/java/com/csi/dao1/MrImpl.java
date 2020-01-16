package com.csi.dao1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csi.dao.MrDao;

import com.csi.model.MR;
@Component
public class MrImpl implements MrDao {
	@Autowired
	JdbcTemplate jdbcTemplate;


	public static final String selectSQL = "select * from mr";
	private static final String updateSQL = "update mr set mrName=? where mrId=?";
	private static final String deleteSQL = "delete from mr where mrId=?";


	@Override
	public List<MR> getMrData() {
		// TODO Auto-generated method stub
		List<MR> mrs = new ArrayList<MR>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectSQL);

		for (Map<String, Object> row : rows) {
			MR mr = new MR();
			mr.setMrId((int) row.get("mrId"));
			mr.setMrName((String) row.get("mrName"));

			mr.setMrMobileNumber((int) row.get("mrMobileNumber"));

			mr.setMrHighestEdu((String) row.get("mrHighestEdu"));

	
		

			mrs.add(mr);
		}
		return mrs;

		
	}

	@Override
	public void saveMrData(MR mr) {
		// TODO Auto-generated method stub
		jdbcTemplate.execute(
				"insert into mr(mrId,mrName,mrMobileNumber, mrHighestEdu)values('"
						+ mr.getMrId() + "','" + mr.getMrName() + "', '"
						+ mr.getMrMobileNumber()+ "','" + mr.getMrHighestEdu()
						+ "')");
	}
		
	

	@Override
	public void updateMrData(int mrId, MR mr) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(updateSQL, mr.getMrName(), mrId);
	}
		
	

	@Override
	public void deleteMrData(int mrId) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(deleteSQL, mrId);
		
		
	}

	
	
}
