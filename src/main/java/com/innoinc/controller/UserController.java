///**
// * UserController
// * 
// * 사용자와 관련된 데이터의 RESTAPI Controller
// * 
// * @author 박민성
// */
//
//package com.innoinc.controller;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.innoinc.model.ir.IrUser;
//import com.innoinc.service.IrUserService;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.ObjectUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class UserController {
//	
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    
//    @Autowired
//    IrUserService iruserService;
//    List<IrUser> iruserList;
//    IrUser iruser;
//    String asccessToken;
//
//    /**
//     * 로그인 인증부분
//     * 
//     * 유저 아이디체크 후 아이디가 있을 경우 true을 준다.
//     * 
//     * @return Json Hashmap
//     */
//    @GetMapping("/json/manage/login")
//    public Map<String,String> dataReturn(
//            @RequestParam(value="userid", required=false) String userid
//    ) {
//        Map<String,String> userMap = new HashMap<>();
//
//        asccessToken = "null";
//
//        iruser = iruserService.selectIruserByUserid(userid);
//
//        if(!ObjectUtils.isEmpty(iruser)) {
//            logger.debug(iruser.toString());
//            asccessToken = "true";
//        }
//        userMap.put("accessToken", asccessToken);
//
//        return userMap;
//    }
//
//    /**
//     * 
//     * 모든 유저의 데이터를 줌
//     * 
//     * @return Json Array
//     */
//    @GetMapping("/json/manage/user")
//    public ArrayList<Map<String,String>> dataReturn() {
//        ArrayList<Map<String,String>> data = new ArrayList<>();
//        
//        iruserList = iruserService.selectAll();
//        iruserList.forEach(iruser -> {
//            Map<String,String> userMap = new HashMap<>();
//            logger.debug(iruser.toString());
//            userMap.put("userId", iruser.getUser_id());
//            userMap.put("userName", iruser.getUser_name());
//            userMap.put("loginLockReason", iruser.getLogin_lock_reason());
//            userMap.put("authLevel", iruser.getAuth_level());
//            userMap.put("regDate", String.valueOf(iruser.getReg_date()));
//            data.add(userMap);
//        });
//
//        //model.addAttribute(iruserList);
//        return data;
//    }
//}