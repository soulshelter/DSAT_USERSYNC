package com.innoinc.model.oracle.daishin;

 

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Data
@Alias("daishin")
public class Daishin {
	private String emp_no;
	private String dept_code;
	private String dept_name;
	private String upper_dept;
	private String upper_name;
	
}
