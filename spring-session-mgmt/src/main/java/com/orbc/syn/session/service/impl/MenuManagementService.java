/**
 * 
 */
package com.orbc.syn.session.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.orbc.syn.session.service.IMenuManagementService;
import com.orbc.syn.session.vo.Menu;
import com.orbc.syn.session.vo.Resource;
import com.orbc.syn.session.vo.User;

/**
 * @author ntalari
 *
 */
@Service
public class MenuManagementService implements IMenuManagementService {
	
	private static final Logger log = LogManager.getLogger(MenuManagementService.class);

	@Override
	public List<Menu> getMenu(User user) {
		

		/*URL url;

		StringBuilder sCurrentLineBuf = null;

		BufferedReader br = null;

		String sourceResponse;

		 String sourceUrl="http://localhost:9000/xmlemployees/";

		try {

			url = new URL(sourceUrl);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestProperty(AppConstants.ACCT_KEY,
					MediaType.APPLICATION_JSON);

			conn.setDoOutput(true);

			log.info("invoking menu management service");

			if (conn.getResponseCode() != 200) {

				throw new Exception("Failed : HTTP error code : "

						+ conn.getResponseCode());

			}

			br = new BufferedReader(new InputStreamReader(

					(conn.getInputStream())));

			sCurrentLineBuf = new StringBuilder();

			String dtmresponse = AppConstants.EMPTY_STRING;

			while (!Utils.isEmpty((dtmresponse = br.readLine()))) {

				sCurrentLineBuf.append(dtmresponse);

			}

			conn.disconnect();

			sourceResponse = sCurrentLineBuf.toString();

			if (Utils.isEmpty(sourceResponse)) {

				throw new Exception("Got empty response from menu management");

			}

			*//**
			 * converting JSON (MenuMgmt's) response to Java object (List<Menu>)
			 *//*
			ObjectMapper mapper = new ObjectMapper();
			List<Menu> menus = mapper.readValue(sourceResponse,
					ArrayList.class);

		} catch (Exception e) {

			throw new RuntimeException("exception occur while calling Menu Management service",e);

		} finally {


			Utils.closeResource(br);

		}*/

		
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
