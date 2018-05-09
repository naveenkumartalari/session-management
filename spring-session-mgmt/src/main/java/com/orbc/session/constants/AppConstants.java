/*
 *  DTM API : AppConstant.java
 *
 * Copyright (c) 2016 ORBCOMM INC. All rights reserved.
 * This program and the accompanying materials are made 
 * available under the terms and conditions of the ORBCOMM INC.
 *
 * To know about Terms and Conditions, please visit us 
 *  	http://www.orbcomm.com/terms
 * For further information, please contact ORBCOMM INC through
 *  	http://www.orbcomm.com/contact
 */
package com.orbc.session.constants;

import java.io.File;

/**
 * This class helps to define all constant variables used for application.
 *
 * <p>
 * It will be easy to find all constants variables in one place.
 *
 * @since 20 Dec, 2016 12:06:31 PM
 * @author Alaguraj Murugapoopathi
 */
public final class AppConstants {

    public static final String APP_NAME = "synergy-session-mgmt";
    public static final String APP_CONFIG_FILE = "/app.properties";
    public static final String LOG_CONFIG_FILE = "/log4j.properties";
    public static final String HB_CONFIG_FILE = "/hibernate.cfg.xml";
    
    
    public static final String ACCC_VAL = "no-cache";  
    public static final String ACAP_KEY = "Accept";      
    public static final String ACCT_KEY = "content_type";       
    public static final String ACCC_KEY = "Cache-Control"; 
    
    public static final String CLGR_KEY = "grant_type";
    public static final String CLUSR_KEY = "username";
    public static final String CLPASS_KEY = "password";
    public static final String CLRTK_KEY = "refresh_token";
    public static final String CLID_KEY = "client_id";
    public static final String CLID_VAL = "7149320ce92946d4a7b8dc8bedea77f3";
    public static final String CLSE_KEY = "client_secret";
    public static final String CLSE_VAL = "PPFNVwMgQLfPbYiQX3XLVyOyK_WIvIUB1leJvn3oq_c";
    public static final String CLTX_KEY = "cleartext";
    public static final String CLTX_VAL = "Y";
        
    public static final String E_AF = "Authentication failed";
    public static final String E_IJT = "Unacceptable json timestamp, expected numeric!!!";
    public static final String E_IVO = "Access to reflection method failed";
    public static final String E_UDC = "Unimplemented datatype casting";
    public static final String E_IRP = "Invalid request / parameter";
    public static final String E_DATA = "Data operation failed";
    public static final String E_APP = "Application exception occurred";
    public static final String E_UO = "Unimplemented operation";
    public static final String E_UVF = "Choose DTD/XML/XSD/JSON file and upload";
    public static final String E_IVF = "Support DTD/XML/XSD/JSON file format";
    public static final String E_DNF = "Directory(%s) not found";
    public static final String E_PNF = "Package(%s) not found";
    public static final String E_EXNF = "Executable(%s) not found";
    public static final String E_FNF = "File(%s) not found";
    public static final String E_FTNF = "File type(%s) not found";
    public static final String E_UIAT = "Specified ANT task not implemented";
    public static final String E_NSCF = "No such class(%s) found";
    public static final String E_IVCF = "Invalid class found";
    public static final String E_CLF = "Class loader failed";
    public static final String E_NADF = "No annotation data found";
    public static final String E_NVF = "Not a valid file";
    public static final String E_CNYI = "Code generator not yet implemented";
    public static final String E_RLX = "Receiver limit exceeds or not configured";   
    public static final String E_RNF = "Receiver not found";
    public static final String E_SEPNF = "Receiver source endpoint not found";    
    public static final String E_DEPNF = "Receiver destination endpoint not found";    
    public static final String E_SDEPNF = "Receiver secondary destination endpoint not found";    
    public static final String E_SENF = "Source elements not found";
    public static final String E_DENF = "Destination elements not found";
    public static final String E_SDENF = "Secondary destination elements not found";
    public static final String E_SRENF = "Source root element not found";
    public static final String E_DRENF = "Destination root element not found";
    public static final String E_SDRENF = "Secondary destination root element not found";
    public static final String E_IVCL = "Invalid commandline : %s";
    public static final String E_NRD = "No receiver data found";
    public static final String E_NID = "No integration data found";
    public static final String E_CNF = "Customer not found";
    public static final String E_DTNF = "Receiver data transformer not found";
    public static final String E_ADNF = "Auto-deployment folder not found";
    public static final String E_NSE = "No such an element";
    public static final String E_UCJS = "JSON schema file generation failed";
    public static final String E_MSCP = "Missing secure copy parameter";
    public static final String E_MSE = "Missing secure shell execute parameter";
    public static final String E_NVRA = "Not a valid receiver application";
    public static final String E_UDA = "Unable to deploy receiver application";
    public static final String E_SNR = "Deployment server(%s) not running in %s";
    public static final String E_NDNF = "No DTM nodes found for deployment";
    public static final String E_DNNF = "Deployed node not found";
    public static final String E_SNNF = "Server node not found";
    public static final String E_CURL = "Please configure receiver URL before proceed";
    public static final String E_SOF = "Server operation failed HTTP Code : ";
    public static final String E_NVIO = "Not a valid integration operation";
    public static final String E_IOIR = "Integration operation failed, due to invalid response";
    public static final String E_HNF = "Host not found in deployment serverlist";
    public static final String E_RAE = "Receiver already exist";  
    public static final String E_IVRN = "Invalid receiver name";
    public static final String E_IVCID = "Invalid customer id";
    public static final String E_ENF = "Element not found";
    public static final String E_IVMT = "Invalid mapping type";
    public static final String E_OAE = "Receiver already %sed";
    public static final String E_IONI = "Integration operation not yet implemented";    
    public static final String E_ROF = "Receiver operation failed";
    public static final String E_MMNE = "Mapping model doestn't exist";
    public static final String E_INTC = "Not a valid tomcat server command";
    public static final String E_FCS = "Failed while compiling source";
    public static final String E_FGS = "Failed while generating source";
    public static final String E_FEA = "Failed to load receiver archetype";
    public static final String E_FZS = "Failed to pack sources";
    public static final String E_FMTF = "Failed to move transformer application to binary repository";
    public static final String E_FMRF = "Failed to move receiver application to binary repository";
    public static final String E_FDR = "Failed to deploy receiver application";
    public static final String E_FBR = "Failed to build receiver application";
    public static final String E_FBT = "Failed to build transformer application";
    public static final String E_FUR = "Failed to undeploy receiver application";
    public static final String E_FRR = "Failed to remove receiver application files";
    public static final String E_FRRD = "Failed to remove receiver redo application files";
    public static final String E_FSS = "Failed to get server available status";
    public static final String E_FBS = "Failed to build sender application";
    public static final String E_FMSF = "Failed to move sender application to binary repository";
    public static final String E_FCNS = "Failed to copy application files to new server";
    public static final String E_FRCNS = "Failed to remove new server copied application files";
    public static final String E_RTNF = "Receiver's token not found";
    public static final String E_IVT = "Not a valid token";
    public static final String E_TNF = "Receiver token not found";
    public static final String E_DANF = "Definition of acknowledgement not found";
    public static final String E_IVDA = "Invalid definition of acknowledgement";
    public static final String E_IVET = "Invalid endpoint type";
    public static final String E_CCC = "HTTP connection can't be closed";
    public static final String E_SNF = "Loading server node details failed";
    public static final String E_TGTNI = "Traffic graph request type not yet implemented";
    public static final String E_TDNF = "Traffic data not found";
    public static final String E_QMNF = "Queue message not found";
    public static final String E_UDFQ = "Failed to delete message from %s queue";
    public static final String E_CDNF = "Customer data not found";
    public static final String E_PCCR = "Please choose role for %s customer";
    public static final String E_CRU = "Customer(%s) role updation failed";
    public static final String E_CRAE = "Customer role already exist";
    public static final String E_IVLL = "Invalid log4j log level";
    public static final String E_SLL = "No such an appender found";
    public static final String E_BLL = "Both old and new log level are %s";
    public static final String E_MDNF = "Message data not found";
    public static final String E_NSTF = "No stacktrace found";
    public static final String E_NPLF = "No payload found";
    public static final String E_IHD = "Invalid hour definition";
    public static final String E_UFJP = "Unable to find jaxb provider";
            
            
    public static final String HTTP = "http";
    public static final String HTTPS = "https";
    
    public static final String AP_SC = "status_code";
    public static final String AP_UID = "user_id";
    public static final String AP_UN = "user_name";
    public static final String AP_RID = "role_id";
    
    public static final String SSO_TOKEN_URL = "https://beta-ssoauth.tms-orbcomm.com/ssoauth/token"; 
    public static final String SEC_TLS = "TLS";
    public static final String SEC_BASIC = "BASIC";
    
    
    public static final String EMPTY_STRING = "";
    
    
}
