/**
 * 
 */
package com.orbcomm.session.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.orbcomm.session.service.IMenuManagementService;
import com.orbcomm.session.vo.Menu;
import com.orbcomm.session.vo.Resource;
import com.orbcomm.session.vo.User;

/**
 * @author ntalari
 *
 */
@Service
public class MenuManagementService implements IMenuManagementService {

	@Override
	public List<Menu> getMenu(User user) {
		Resource resource1=new Resource();
		resource1.setName("Resource1");
		resource1.setUrl("http://www.sampleurl.com/fwa1");
		resource1.setType("XSS");
		resource1.setDesc("description1");
		resource1.setId(1);
		resource1.setVersion("1.1.0");
		resource1.setAccessPoints(Arrays.asList("AP1","AP2"));
		resource1.setTags(Arrays.asList("Tag1","Tag2"));
		resource1.setActive(1);
		
		Menu menu1=new Menu();
		menu1.setName("Menu1");
		menu1.setToolTip("menu1");
		menu1.setResource(resource1);
		menu1.setId(1);
		
		List<Menu> menus=new ArrayList<>();
		menus.add(menu1);
		menus.add(menu1);
		return menus;
	}

}
