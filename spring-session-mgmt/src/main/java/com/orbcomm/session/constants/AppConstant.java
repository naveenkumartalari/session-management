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
package com.orbcomm.session.constants;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * This class helps to define all constant variables used for application.
 *
 * <p>
 * It will be easy to find all constants variables in one place.
 *
 * @since 20 Dec, 2016 12:06:31 PM
 * @author Alaguraj Murugapoopathi
 */
public final class AppConstant {

    public static final String APP_NAME = "DTM-Console";
    public static final String APP_CONFIG_FILE = "/app.properties";
    public static final String LOG_CONFIG_FILE = "/log4j.properties";
    public static final String HB_CONFIG_FILE = "/hibernate.cfg.xml";
    public static final String JAXB_CLASS_FILE = "/JaxBindImpl.groovy";
    public static final String APP_TIMEZONE = "GMT";
    public static final String APP_DEF_HOST = "localhost";
    public static final String FAILED = "Failed";
    public static final String PASSWORD = "399A76699BC8ECBCE7D3E9C0EB9FA7AF";
    public static final String MID_SI = "DTM-SI";
    public static final String MID_DI = "DTM-DI";
    public static final String ENC_UTF8 = "UTF-8";
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String OUTPUT = "output";
    public static final String OK = "OK";
    public static final String RM = "Removing";
    public static final String BK = "Backuping";
    public static final String RMD = "Removed";
    public static final String BKD = "Backuped";
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String FIELD = "field";
    public static final String APP_PKG_NAME = "com.orbcomm.tms";
    public static final String ARG0 = "arg0";
    public static final String CMP_ARGS = "-parameters";
    public static final String YES = "yes";
    public static final String JAXB_CLS = "JaxBindProvider";
    
    public static final String P_UPPER = "upper";
    public static final String P_LIKE = "like";
    public static final String P_OR = "or";
    public static final String P_AND = "and";
    public static final String P_BT = "between";   
    public static final String P_WHR = "where"; 
    public static final String P_DATE = "date";
    public static final String P_ORD = "order";
    public static final String P_BY = "by";
    
    public static final String DTF_MYSQL = "yyyy-MM-dd";
    public static final String DTF_FG = "d MMM, yyyy HH:mm:ss a";
    public static final String DTF_3M = "MMM";
    public static final String DTF_4Y = "yyyy";
    public static final String DTF_4Y3M = "yyyy-MMM";
    public static final String DTF_HH = "HH";
    
    public static final String CLASSPATH = new File(AppConstant.class
            .getProtectionDomain().getCodeSource().getLocation().getPath())
            .getPath().replace("com:orbcomm:tms:dtm:console:AppConstant.class"
                    .replace(":", File.separator), "");
    public static final String VE_DISABLE_LOG = "org.apache.velocity.runtime.log.NullLogChute";
    public static final String VE_DF = "Transformer.vm";
    public static final String VE_RPF = "RestProvider.vm";
    public static final String VE_DTF = "ExternalInterface.vm";
    public static final String VE_HGF = "handler.vm";
    
    public static final String FT_DTD = "dtd";
    public static final String FT_XML = "xml";
    public static final String FT_XSD = "xsd";
    public static final String FT_JSON = "json";    
    public static final String FT_JAR = "jar";
    public static final String FT_CLASS = "class";
    public static final String FT_JAVA = "java";
    public static final String FT_WSDL = "wsdl";
        
    public static final String CH_AT = "@";
    public static final String CH_OB = "(";
    public static final String CH_CB = ")";
    public static final String CH_OSB = "[";
    public static final String CH_CSB = "]";
    public static final String CH_COMMA = ",";
    public static final String CH_EQ = "=";
    public static final String CH_HSAT = "#@";
    public static final String CH_COLON = ":";
    public static final String CH_DOT = ".";
    public static final String CH_LT = "<";
    public static final String CH_GT = ">";
    public static final String CH_OFB = "{";
    public static final String CH_CFB = "}";
    public static final String CH_HYP = "-";
    public static final String CH_TLD = "~";
    public static final String CH_LF = "\n";
    public static final String CH_TLDH = "~#";
    public static final String CH_ST = "*";
    public static final String CH_SQ = "'";
    public static final String CH_BSL = "/";
    public static final String CH_PCT = "%";
    public static final String CH_FSL = "\\";
    public static final String CH_DQ = "\"";
    public static final String CH_DLR = "$";

    public static final String ACAO_VAL = "*";
    public static final String ACAC_VAL = "true";
    public static final String ACMA_VAL = "1209600";
    public static final String ACAH_VAL = "Origin, X-Requested-With, Content-Type, Accept, Authorization";
    public static final String ACAM_VAL = "GET, POST, PUT, DELETE, HEAD";
    public static final String ACCC_VAL = "no-cache";  
    public static final String ACAO_KEY = "Access-Control-Allow-Origin";
    public static final String ACAC_KEY = "Access-Control-Allow-Credentials";
    public static final String ACMA_KEY = "Access-Control-Max-Age";
    public static final String ACAH_KEY = "Access-Control-Allow-Headers";
    public static final String ACAM_KEY = "Access-Control-Allow-Methods";
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
        
    public static final String JP_CH = "catalina.home";
    public static final String JP_JH = "java.home";
    public static final String JP_UH = "user.home";
    public static final String JP_UN = "user.name";
    public static final String JP_AN = "app.name";
    public static final String JP_UTZ = "user.timezone";
    
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
            
            
    public static final String TO_CHAR = "toCharacter";
    public static final String TO_STRING = "toZtring";
    public static final String TO_NUM= "toNumber";
    public static final String TO_DOUBLE = "toDouble";
    public static final String TO_LONG = "toLong";
    public static final String TO_SHORT = "toShort";
    public static final String TO_INTEGER = "toInteger";
    public static final String TO_FLOAT = "toFloat";
    public static final String TO_BYTE = "toByte";
    public static final String TO_BIGINT = "toBigInteger"; 
    public static final String TO_BIGDEC = "toBigDecimal";
    public static final String TO_TIMESTAMP = "toTimestamp";
    public static final String TO_XGC = "toXMLGregorianCalendar";      
    public static final String TO_BOOLEAN = "toBoolean";
    public static final String TO_XDUR = "toDuration";
    public static final String TO_BA = "toByteArray";
    public static final String TO_OBJ = "toObject";
    public static final String TO_PFLOAT = "toPFloat";
    public static final String TO_PDOUBLE = "toPDouble";
    public static final String TO_PCHAR = "toPChar";
    public static final String TO_PBOOLEAN = "toPBoolean";
    public static final String TO_PBYTE = "toPByte";
    public static final String TO_PSHORT = "toPShort";
    public static final String TO_PINTEGER = "toPInt";
    public static final String TO_PLONG = "toPLong";
    
    public static final String MD_MN = "#mn#";
    public static final String MD_RN = "r.";
    public static final String MD_CN = "c.";
    public static final String MD_TBN = "t.base.";
    public static final String MD_TN = "t.";
    
    public static final String HTTP = "http";
    public static final String HTTPS = "https";
    
    public static final String SVV_MT = "dtmMessageTime";
    public static final String SVV_EC = "dtmErrorCode";
    public static final String SVV_ED = "dtmErrorDescription";
    public static final String SVV_WM = "dtmWatermark";
    
    public static final String AP_SC = "status_code";
    public static final String AP_UID = "user_id";
    public static final String AP_UN = "user_name";
    public static final String AP_RID = "role_id";
    
    public static final String SSO_TOKEN_URL = "https://beta-ssoauth.tms-orbcomm.com/ssoauth/token"; 
    public static final String SEC_TLS = "TLS";
    public static final String SEC_BASIC = "BASIC";
    
    public static final String HOURS = "hours"; 
    public static final String WEEKS = "weeks";
    public static final String DAYS = "days"; 
    public static final String MONTHS = "months";
    public static final String YEARS = "years";
    
}
