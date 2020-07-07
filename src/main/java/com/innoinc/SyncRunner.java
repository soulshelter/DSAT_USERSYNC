package com.innoinc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.innoinc.model.oracle.daishin.Daishin;
import com.innoinc.model.postgres.ir.IrUser;
import com.innoinc.model.postgres.ir.IrUserGroup;
import com.innoinc.service.DaeshinService;
import com.innoinc.service.IrUserGroupService;
import com.innoinc.service.IrUserService;


@SpringBootApplication
public class SyncRunner implements CommandLineRunner{
   @Autowired
   private DaeshinService daeshinservice;
   @Autowired
   private IrUserService irUserService;
   @Autowired
   private IrUserGroupService irUserGroupService;
   
   List<Daishin> daeshinList;
   Daishin daishin;
   List<IrUser> irUserList;
   IrUserGroup irUserGroup;
   List<IrUserGroup> irUserGroupList;
   

   @Override
   public void run(String... args) throws Exception {
   
  	 daeshinList = daeshinservice.selectAll();
  	 daeshinList.forEach(daishin -> {
  		 System.out.println(daishin.toString());
  	 });
  	 
  	 System.out.println(irUserService.selectVersion());
  	 
  	 irUserGroup = new IrUserGroup();
  	 irUserGroup.setGroup_id("00");
  	 irUserGroup.setGroup_depth(1);
  	 irUserGroup.setGroup_name("보상");
  	 irUserGroup.setGroup_path("ROOT00");
  	 irUserGroup.setGroup_display_name("보상");
  	 
  	 //irUserGroupService.addGroup(irUserGroup);
  	 
  	 irUserGroupList = irUserGroupService.selectAll();
  	 irUserGroupList.forEach(i -> {
  		 System.out.println(i.toString());
  	 });
   }
} 

	
 
