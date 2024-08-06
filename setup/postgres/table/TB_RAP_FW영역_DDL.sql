CREATE TABLE TB_RPJTE_MSG_M (
  MSG_CTN VARCHAR(4000) NOT NULL,
  LANG_CD VARCHAR(3) NOT NULL,
  MSG_TXT_CTN VARCHAR(4000) NOT NULL,
  RMK VARCHAR(4000) NULL,
  OPT_VAL_CTN1 VARCHAR(4000) NULL,
  OPT_VAL_CTN2 VARCHAR(4000) NULL,
  OPT_VAL_CTN3 VARCHAR(4000) NULL,
  USE_YN VARCHAR(1) NULL,
  DATA_INS_USER_ID VARCHAR(50) NULL,
  DATA_INS_USER_IP VARCHAR(40) NULL,
  DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
  DATA_UPD_USER_ID VARCHAR(50) NULL,
  DATA_UPD_USER_IP VARCHAR(40) NULL,
  DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
  CONSTRAINT TB_RPJTE_MSG_M_PK PRIMARY KEY (MSG_CTN,LANG_CD)
);


COMMENT ON COLUMN TB_RPJTE_MSG_M.MSG_CTN IS '메시지코드';
COMMENT ON COLUMN TB_RPJTE_MSG_M.LANG_CD IS '언어코드';
COMMENT ON COLUMN TB_RPJTE_MSG_M.MSG_TXT_CTN IS '메시지명';
COMMENT ON COLUMN TB_RPJTE_MSG_M.RMK IS '비고';
COMMENT ON COLUMN TB_RPJTE_MSG_M.OPT_VAL_CTN1 IS '옵션값내용1';
COMMENT ON COLUMN TB_RPJTE_MSG_M.OPT_VAL_CTN2 IS '옵션값내용2';
COMMENT ON COLUMN TB_RPJTE_MSG_M.OPT_VAL_CTN3 IS '옵션값내용3';
COMMENT ON COLUMN TB_RPJTE_MSG_M.USE_YN IS '사용여부';
COMMENT ON COLUMN TB_RPJTE_MSG_M.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_MSG_M.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_MSG_M.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_MSG_M.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_MSG_M.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_MSG_M.DATA_UPD_DTM IS '데이터수정일시';



CREATE TABLE TB_RPJTE_MENU_M (
MNU_ID VARCHAR(50) NOT NULL,
MNU_NM VARCHAR(1000) NOT NULL,
msg_ctn          VARCHAR(4000),
MNU_URL VARCHAR(500) NULL,
MNU_LV_NO NUMERIC(10,0) NULL,
UPPR_MNU_ID VARCHAR(50) NULL,
SORT_ORD NUMERIC(10,0) NULL,
mnu_eps_yn       VARCHAR(1),
USE_YN VARCHAR(1) NULL,
MNU_DESC VARCHAR(200) NULL,
mnu_opt_val_ctn1 VARCHAR(500),
mnu_opt_val_ctn2 VARCHAR(500),
mnu_opt_val_ctn3 VARCHAR(500),
mnu_opt_val_ctn4 VARCHAR(500),
mnu_opt_val_ctn5 VARCHAR(500),
DATA_INS_USER_ID VARCHAR(50) NULL,
DATA_INS_USER_IP VARCHAR(40) NULL,
DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
DATA_UPD_USER_ID VARCHAR(50) NULL,
DATA_UPD_USER_IP VARCHAR(40) NULL,
DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
CONSTRAINT TB_RPJTE_MENU_M_PK PRIMARY KEY (MNU_ID)
);

COMMENT ON COLUMN TB_RPJTE_MENU_M.MNU_ID IS '메뉴아이디';

COMMENT ON COLUMN TB_RPJTE_MENU_M.MNU_NM IS '메뉴메시지코드';
comment on column TB_RPJTE_MENU_M.mnu_eps_yn  is '메뉴노출여부';
COMMENT ON COLUMN TB_RPJTE_MENU_M.MNU_URL IS '메뉴경로';
COMMENT ON COLUMN TB_RPJTE_MENU_M.MNU_LV_NO IS '메뉴레벨';
COMMENT ON COLUMN TB_RPJTE_MENU_M.UPPR_MNU_ID IS '상위메뉴아이디';
COMMENT ON COLUMN TB_RPJTE_MENU_M.SORT_ORD IS '메뉴정렬순서번호';
COMMENT ON COLUMN TB_RPJTE_MENU_M.USE_YN IS '사용여부';
COMMENT ON COLUMN TB_RPJTE_MENU_M.MNU_DESC IS '메뉴설명';
comment on column TB_RPJTE_MENU_M.mnu_opt_val_ctn1 is '메뉴옵션값내용1';
comment on column TB_RPJTE_MENU_M.mnu_opt_val_ctn2 is '메뉴옵션값내용2';
comment on column TB_RPJTE_MENU_M.mnu_opt_val_ctn3 is '메뉴옵션값내용3';
comment on column TB_RPJTE_MENU_M.mnu_opt_val_ctn4 is '메뉴옵션값내용4';
comment on column TB_RPJTE_MENU_M.mnu_opt_val_ctn5 is '메뉴옵션값내용5';
COMMENT ON COLUMN TB_RPJTE_MENU_M.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_MENU_M.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_MENU_M.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_MENU_M.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_MENU_M.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_MENU_M.DATA_UPD_DTM IS '데이터수정일시';


CREATE TABLE TB_RPJTE_CMN_GR_C (
CMN_GR_CD VARCHAR(50) NOT NULL,
CMN_GR_CD_NM VARCHAR(50) NOT NULL,
CMN_GR_CD_DESC VARCHAR(1000) NULL,
WKT_AREA_DIVS_CD VARCHAR(50) NULL,
MSG_CTN VARCHAR(4000),
SORT_ORD NUMERIC(10,0) NULL,
OPT_VAL_NM1 VARCHAR(100) NULL,
OPT_VAL_NM2 VARCHAR(100) NULL,
OPT_VAL_NM3 VARCHAR(100) NULL,
OPT_VAL_NM4 VARCHAR(100) NULL,
OPT_VAL_NM5 VARCHAR(100) NULL,
OPT_VAL_NM6 VARCHAR(100) NULL,
OPT_VAL_NM7 VARCHAR(100) NULL,
OPT_VAL_NM8 VARCHAR(100) NULL,
OPT_VAL_NM9 VARCHAR(100) NULL,
OPT_VAL_NM10 VARCHAR(100) NULL,
OPT_VAL_NM11 VARCHAR(100) NULL,
OPT_VAL_NM12 VARCHAR(100) NULL,
OPT_VAL_NM13 VARCHAR(100) NULL,
OPT_VAL_NM14 VARCHAR(100) NULL,
OPT_VAL_NM15 VARCHAR(100) NULL,
RMK VARCHAR(4000) NULL,
USE_YN VARCHAR(1) NULL,
DATA_INS_USER_ID VARCHAR(50) NULL,
DATA_INS_USER_IP VARCHAR(40) NULL,
DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
DATA_UPD_USER_ID VARCHAR(50) NULL,
DATA_UPD_USER_IP VARCHAR(40) NULL,
DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
CONSTRAINT TB_RPJTE_CMN_GR_C_PK PRIMARY KEY (CMN_GR_CD)
);

COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.CMN_GR_CD IS '공통그룹코드';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.CMN_GR_CD_NM IS '공통그룹코드명';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.CMN_GR_CD_DESC IS '공통그룹코드설명';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.WKT_AREA_DIVS_CD IS '업무영역구분코드';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.MSG_CTN IS '메세지내용';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.SORT_ORD IS '정렬순서';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM1 IS '옵션값명1';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM2 IS '옵션값명2';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM3 IS '옵션값명3';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM4 IS '옵션값명4';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM5 IS '옵션값명5';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM6 IS '옵션값명6';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM7 IS '옵션값명7';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM8 IS '옵션값명8';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM9 IS '옵션값명9';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM10 IS '옵션값명10';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM11 IS '옵션값명11';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM12 IS '옵션값명12';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM13 IS '옵션값명13';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM14 IS '옵션값명14';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.OPT_VAL_NM15 IS '옵션값명15';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.RMK IS '비고';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.USE_YN IS '사용여부';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_CMN_GR_C.DATA_UPD_DTM IS '데이터수정일시';


CREATE TABLE TB_RPJTE_CMN_C (
CMN_GR_CD VARCHAR(50) NOT NULL,
CMN_CD VARCHAR(150) NOT NULL,
CMN_CD_NM VARCHAR(200) NOT NULL,
CMN_CD_DESC VARCHAR(400) NULL,
UPPR_CMN_CD VARCHAR(150) NULL,
MSG_CTN VARCHAR(4000),
SORT_ORD NUMERIC(10,0) NULL,
USE_YN VARCHAR(1) NULL,
OPT_VAL_CTN1 VARCHAR(4000) NULL,
OPT_VAL_CTN2 VARCHAR(4000) NULL,
OPT_VAL_CTN3 VARCHAR(4000) NULL,
OPT_VAL_CTN4 VARCHAR(4000) NULL,
OPT_VAL_CTN5 VARCHAR(4000) NULL,
OPT_VAL_CTN6 VARCHAR(4000) NULL,
OPT_VAL_CTN7 VARCHAR(4000) NULL,
OPT_VAL_CTN8 VARCHAR(4000) NULL,
OPT_VAL_CTN9 VARCHAR(4000) NULL,
OPT_VAL_CTN10 VARCHAR(4000) NULL,
OPT_VAL_CTN11 VARCHAR(4000) NULL,
OPT_VAL_CTN12 VARCHAR(4000) NULL,
OPT_VAL_CTN13 VARCHAR(4000) NULL,
OPT_VAL_CTN14 VARCHAR(4000) NULL,
OPT_VAL_CTN15 VARCHAR(4000) NULL,
DATA_INS_USER_ID VARCHAR(50) NULL,
DATA_INS_USER_IP VARCHAR(40) NULL,
DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
DATA_UPD_USER_ID VARCHAR(50) NULL,
DATA_UPD_USER_IP VARCHAR(40) NULL,
DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
CONSTRAINT TB_RPJTE_CMN_C_PK PRIMARY KEY (CMN_GR_CD,CMN_CD)
);

COMMENT ON COLUMN TB_RPJTE_CMN_C.CMN_GR_CD IS '공통그룹코드';
COMMENT ON COLUMN TB_RPJTE_CMN_C.CMN_CD IS '공통코드';
COMMENT ON COLUMN TB_RPJTE_CMN_C.CMN_CD_NM IS '공통코드명';
COMMENT ON COLUMN TB_RPJTE_CMN_C.CMN_CD_DESC IS '공통코드설명';
COMMENT ON COLUMN TB_RPJTE_CMN_C.UPPR_CMN_CD IS '상위공통코드';
COMMENT ON COLUMN TB_RPJTE_CMN_C.MSG_CTN IS '메세지내용';
COMMENT ON COLUMN TB_RPJTE_CMN_C.SORT_ORD IS '정렬순서';
COMMENT ON COLUMN TB_RPJTE_CMN_C.USE_YN IS '사용여부';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN1 IS '옵션값내용1';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN2 IS '옵션값내용2';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN3 IS '옵션값내용3';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN4 IS '옵션값내용4';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN5 IS '옵션값내용5';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN6 IS '옵션값내용6';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN7 IS '옵션값내용7';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN8 IS '옵션값내용8';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN9 IS '옵션값내용9';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN10 IS '옵션값내용10';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN11 IS '옵션값내용11';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN12 IS '옵션값내용12';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN13 IS '옵션값내용13';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN14 IS '옵션값내용14';
COMMENT ON COLUMN TB_RPJTE_CMN_C.OPT_VAL_CTN15 IS '옵션값내용15';
COMMENT ON COLUMN TB_RPJTE_CMN_C.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_CMN_C.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_CMN_C.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_CMN_C.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_CMN_C.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_CMN_C.DATA_UPD_DTM IS '데이터수정일시';


CREATE TABLE TB_RPJTE_DEPT_M (
DEPT_CD VARCHAR(20) NOT NULL,
COP_CD VARCHAR(10) NOT NULL,
DEPT_NM VARCHAR(300) NULL,
DEPT_ENG_NM VARCHAR(300) NULL,
DEPT_CNG_NM VARCHAR(300) NULL,
TEM_LDR_USER_ID VARCHAR(50) NULL,
UPPR_DEPT_CD VARCHAR(20) NULL,
USE_YN VARCHAR(1) NULL,
DATA_INS_USER_ID VARCHAR(50) NULL,
DATA_INS_USER_IP VARCHAR(40) NULL,
DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
DATA_UPD_USER_ID VARCHAR(50) NULL,
DATA_UPD_USER_IP VARCHAR(40) NULL,
DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
CONSTRAINT TB_RPJTE_DEPT_M_PK PRIMARY KEY (DEPT_CD)
);

COMMENT ON COLUMN TB_RPJTE_DEPT_M.DEPT_CD IS '부서코드';
COMMENT ON COLUMN TB_RPJTE_DEPT_M.COP_CD IS '사업부코드';
COMMENT ON COLUMN TB_RPJTE_DEPT_M.DEPT_NM IS '부서명';
COMMENT ON COLUMN TB_RPJTE_DEPT_M.DEPT_ENG_NM IS '부서영문명';
COMMENT ON COLUMN TB_RPJTE_DEPT_M.DEPT_CNG_NM IS '부서중문명';
COMMENT ON COLUMN TB_RPJTE_DEPT_M.TEM_LDR_USER_ID IS '팀리더사용자ID';
COMMENT ON COLUMN TB_RPJTE_DEPT_M.UPPR_DEPT_CD IS '상위부서코드';
COMMENT ON COLUMN TB_RPJTE_DEPT_M.USE_YN IS '유효여부';
COMMENT ON COLUMN TB_RPJTE_DEPT_M.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_DEPT_M.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_DEPT_M.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_DEPT_M.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_DEPT_M.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_DEPT_M.DATA_UPD_DTM IS '데이터수정일시';

CREATE TABLE TB_RPJTE_EMP_M (
USER_ID VARCHAR(50) NOT NULL,
EMP_NO VARCHAR(20) NULL,
EMP_NM VARCHAR(50) NULL,
EMP_ENG_NM VARCHAR(100) NULL,
EMP_CNG_NM VARCHAR(100) NULL,
DEPT_CD VARCHAR(20) NULL,
DEPT_NM VARCHAR(300) NULL,
DEPT_ENG_NM VARCHAR(300) NULL,
DEPT_CNG_NM VARCHAR(300) NULL,
COP_CD VARCHAR(10) NULL,
JTI_CD VARCHAR(10) NULL,
JTI_NM VARCHAR(200) NULL,
JTI_ENG_NM VARCHAR(50) NULL,
JTI_CNG_NM VARCHAR(50) NULL,
JPS_CD VARCHAR(10) NULL,
JPS_NM VARCHAR(200) NULL,
JPS_ENG_NM VARCHAR(50) NULL,
JPS_CNG_NM VARCHAR(50) NULL,
INO_STAT_CD VARCHAR(20) NULL,
JCOM_DT VARCHAR(8) NULL,
RSGN_DT VARCHAR(8) NULL,
UPPR_EMP_NO VARCHAR(20) NULL,
ONDU_REGN_CD VARCHAR(50) NULL,
ONDU_REGN_NM VARCHAR(50) NULL,
SSO_DTPL_NM VARCHAR(100) NULL,
HME_TANO VARCHAR(10) NULL,
HME_PHN VARCHAR(50) NULL,
OFC_TANO VARCHAR(10) NULL,
OFC_PHN VARCHAR(50) NULL,
OFC_ETN_PHN VARCHAR(50) NULL,
DOC_AUTH_CD VARCHAR(20) NULL,
EML_SVR_DMN_IFO_NM VARCHAR(200) NULL,
INO_DIVS_CD VARCHAR(20) NULL,
EMP_HPHN VARCHAR(50) NULL,
OLD_DEPT_CD VARCHAR(20) NULL,
OLD_EMP_NO VARCHAR(20) NULL,
DEPT_ENG_DESC VARCHAR(100) NULL,
EMP_LOWR_GR_CD VARCHAR(50) NULL,
EMP_UPPR_GR_CD VARCHAR(50) NULL,
EML_DMN_IFO_NM VARCHAR(200) NULL,
SSO_DTPL_CD VARCHAR(50) NULL,
SSO_EMP_CNG_NM VARCHAR(100) NULL,
CTRY_CD VARCHAR(10) NULL,
SSO_CHG_TP_CD VARCHAR(50) NULL,
SSO_CHG_DT VARCHAR(8) NULL,
USE_YN VARCHAR(1) NULL,
DATA_INS_USER_ID VARCHAR(50) NULL,
DATA_INS_USER_IP VARCHAR(40) NULL,
DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
DATA_UPD_USER_ID VARCHAR(50) NULL,
DATA_UPD_USER_IP VARCHAR(40) NULL,
DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
CONSTRAINT TB_RPJTE_EMP_M_PK PRIMARY KEY (USER_ID)
);

COMMENT ON COLUMN TB_RPJTE_EMP_M.USER_ID IS '사용자ID';
COMMENT ON COLUMN TB_RPJTE_EMP_M.EMP_NO IS '사원번호';
COMMENT ON COLUMN TB_RPJTE_EMP_M.EMP_NM IS '사원명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.EMP_ENG_NM IS '사원영문명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.EMP_CNG_NM IS '사원중문명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.DEPT_CD IS '부서코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.DEPT_NM IS '부서명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.DEPT_ENG_NM IS '부서영문명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.DEPT_CNG_NM IS '부서중문명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.COP_CD IS '법인코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.JTI_CD IS '직위코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.JTI_NM IS '직위명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.JTI_ENG_NM IS '직위영문명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.JTI_CNG_NM IS '직위중문명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.JPS_CD IS '직책코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.JPS_NM IS '직책명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.JPS_ENG_NM IS '직책영문명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.JPS_CNG_NM IS '직책중문명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.INO_STAT_CD IS '재직상태코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.JCOM_DT IS '입사일자';
COMMENT ON COLUMN TB_RPJTE_EMP_M.RSGN_DT IS '퇴사일자';
COMMENT ON COLUMN TB_RPJTE_EMP_M.UPPR_EMP_NO IS '상위자사번';
COMMENT ON COLUMN TB_RPJTE_EMP_M.ONDU_REGN_CD IS '근무지역코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.ONDU_REGN_NM IS '근무지역명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.SSO_DTPL_NM IS 'MYINFO위치';
COMMENT ON COLUMN TB_RPJTE_EMP_M.HME_TANO IS '자택전화지역번호';
COMMENT ON COLUMN TB_RPJTE_EMP_M.HME_PHN IS '자택전화번호';
COMMENT ON COLUMN TB_RPJTE_EMP_M.OFC_TANO IS '사무실전화지역번호';
COMMENT ON COLUMN TB_RPJTE_EMP_M.OFC_PHN IS '사무실전화번호';
COMMENT ON COLUMN TB_RPJTE_EMP_M.OFC_ETN_PHN IS '내선번호';
COMMENT ON COLUMN TB_RPJTE_EMP_M.DOC_AUTH_CD IS '문서권한코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.EML_SVR_DMN_IFO_NM IS '메일서버정보';
COMMENT ON COLUMN TB_RPJTE_EMP_M.INO_DIVS_CD IS '재직구분코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.EMP_HPHN IS '사원휴대전화번호';
COMMENT ON COLUMN TB_RPJTE_EMP_M.OLD_DEPT_CD IS '변경전부서코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.OLD_EMP_NO IS '변경전사원번호';
COMMENT ON COLUMN TB_RPJTE_EMP_M.DEPT_ENG_DESC IS '부서영어설명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.EMP_LOWR_GR_CD IS '사원하위그룹코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.EMP_UPPR_GR_CD IS '사원상위그룹코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.EML_DMN_IFO_NM IS '이메일도메인정보명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.SSO_DTPL_CD IS 'SSO근무지코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.SSO_EMP_CNG_NM IS 'SSO사원중국어명';
COMMENT ON COLUMN TB_RPJTE_EMP_M.CTRY_CD IS '국가코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.SSO_CHG_TP_CD IS 'SSO변경유형코드';
COMMENT ON COLUMN TB_RPJTE_EMP_M.SSO_CHG_DT IS 'SSO변경일자';
COMMENT ON COLUMN TB_RPJTE_EMP_M.USE_YN IS '사용여부';
COMMENT ON COLUMN TB_RPJTE_EMP_M.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_EMP_M.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_EMP_M.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_EMP_M.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_EMP_M.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_EMP_M.DATA_UPD_DTM IS '데이터수정일시';

create table TB_RPJTE_APR_TPL_M
(
apr_tpl_id       VARCHAR(50) not null,
intg_apr_tp_cd   VARCHAR(50),
eapr_tpl_id      VARCHAR(50),
apr_tpl_nm       VARCHAR(200),
sort_ord         NUMERIC(10),
apr_tpl_desc     VARCHAR(200),
use_yn           VARCHAR(1),
prs_desc         VARCHAR(4000),
wcst_use_yn      VARCHAR(1),
wcst_desc        TEXT,
notf_use_yn      VARCHAR(1),
ntdk_id          NUMERIC(10),
mgr_use_yn       VARCHAR(1),
data_ins_user_id VARCHAR(50),
data_ins_user_ip VARCHAR(40),
data_ins_dtm     timestamp default current_timestamp,
data_upd_user_id VARCHAR(50),
data_upd_user_ip VARCHAR(40),
data_upd_dtm     timestamp default current_timestamp
);

comment on table TB_RPJTE_APR_TPL_M
is '결재양식기본';
comment on column TB_RPJTE_APR_TPL_M.apr_tpl_id
is '결재양식ID';
comment on column TB_RPJTE_APR_TPL_M.intg_apr_tp_cd
is '통합결재유형코드';
comment on column TB_RPJTE_APR_TPL_M.eapr_tpl_id
is '전자결재양식ID';
comment on column TB_RPJTE_APR_TPL_M.apr_tpl_nm
is '결재양식명';
comment on column TB_RPJTE_APR_TPL_M.sort_ord
is '정렬순서';
comment on column TB_RPJTE_APR_TPL_M.apr_tpl_desc
is '결재양식설명';
comment on column TB_RPJTE_APR_TPL_M.use_yn
is '사용여부';
comment on column TB_RPJTE_APR_TPL_M.prs_desc
is '프로세스설명';
comment on column TB_RPJTE_APR_TPL_M.wcst_use_yn
is '동의서사용여부';
comment on column TB_RPJTE_APR_TPL_M.wcst_desc
is '동의서설명';
comment on column TB_RPJTE_APR_TPL_M.notf_use_yn
is '통보사용여부';
comment on column TB_RPJTE_APR_TPL_M.ntdk_id
is '통보처ID';
comment on column TB_RPJTE_APR_TPL_M.mgr_use_yn
is '담당자사용여부';
comment on column TB_RPJTE_APR_TPL_M.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_APR_TPL_M.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_APR_TPL_M.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_APR_TPL_M.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_APR_TPL_M.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_APR_TPL_M.data_upd_dtm
is '데이터수정일시';
alter table TB_RPJTE_APR_TPL_M
add constraint TB_RPJTE_APR_TPL_M_PK primary key (APR_TPL_ID);


CREATE TABLE TB_RPJTE_NTDK_M (
NTDK_ID NUMERIC(10,0) NOT NULL,
NTDK_NM VARCHAR(200) NULL,
NTDK_DESC VARCHAR(200) NULL,
USE_YN VARCHAR(1) NULL,
DATA_INS_USER_ID VARCHAR(50) NULL,
DATA_INS_USER_IP VARCHAR(40) NULL,
DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
DATA_UPD_USER_ID VARCHAR(50) NULL,
DATA_UPD_USER_IP VARCHAR(40) NULL,
DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
CONSTRAINT TB_RPJTE_NTDK_M_PK PRIMARY KEY (NTDK_ID)
);

COMMENT ON COLUMN TB_RPJTE_NTDK_M.NTDK_ID IS '통보처아이디';
COMMENT ON COLUMN TB_RPJTE_NTDK_M.NTDK_NM IS '통보처제목';
COMMENT ON COLUMN TB_RPJTE_NTDK_M.NTDK_DESC IS '통보처설명';
COMMENT ON COLUMN TB_RPJTE_NTDK_M.USE_YN IS '사용여부';
COMMENT ON COLUMN TB_RPJTE_NTDK_M.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_NTDK_M.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_NTDK_M.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_NTDK_M.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_NTDK_M.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_NTDK_M.DATA_UPD_DTM IS '데이터수정일시';


create table TB_RPJTE_NTDK_D
(
ntdk_id          NUMERIC(10) not null,
ntdk_seq         NUMERIC(18) not null,
ntdk_divs_cd     VARCHAR(50),
apr_notf_user_id VARCHAR(50) not null,
sort_ord         NUMERIC(10),
use_yn           VARCHAR(1),
data_ins_user_id VARCHAR(50),
data_ins_user_ip VARCHAR(40),
data_ins_dtm     timestamp default current_timestamp,
data_upd_user_id VARCHAR(50),
data_upd_user_ip VARCHAR(40),
data_upd_dtm     timestamp default current_timestamp
)
;
comment on table TB_RPJTE_NTDK_D
is '통보처상세';
comment on column TB_RPJTE_NTDK_D.ntdk_id
is '통보처ID';
comment on column TB_RPJTE_NTDK_D.ntdk_seq
is '통보처순번';
comment on column TB_RPJTE_NTDK_D.ntdk_divs_cd
is '통보처구분코드';
comment on column TB_RPJTE_NTDK_D.apr_notf_user_id
is '결재통보사용자ID';
comment on column TB_RPJTE_NTDK_D.sort_ord
is '정렬순서';
comment on column TB_RPJTE_NTDK_D.use_yn
is '사용여부';
comment on column TB_RPJTE_NTDK_D.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_NTDK_D.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_NTDK_D.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_NTDK_D.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_NTDK_D.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_NTDK_D.data_upd_dtm
is '데이터수정일시';
alter table TB_RPJTE_NTDK_D
add constraint TB_RPJTE_NTDK_D_PK primary key (NTDK_ID, NTDK_SEQ);

create table TB_RPJTE_APR_RULE_M
(
apr_rule_id          VARCHAR(50) not null,
apr_rule_nm          VARCHAR(100) not null,
apr_ln_add_pmit_yn   VARCHAR(1) not null,
apr_rfer_add_psbl_yn VARCHAR(1) not null,
apr_ln_rstb_pmit_yn  VARCHAR(1) not null,
apr_ln_dupl_pmit_yn  VARCHAR(1) not null,
apr_exc_tgt_id       VARCHAR(50),
mst_ntdk_id          NUMERIC(10),
data_ins_user_id     VARCHAR(50),
data_ins_user_ip     VARCHAR(40),
data_ins_dtm         timestamp default current_timestamp,
data_upd_user_id     VARCHAR(50),
data_upd_user_ip     VARCHAR(40),
data_upd_dtm         timestamp default current_timestamp
);
comment on table TB_RPJTE_APR_RULE_M
is '결재규칙기본';
comment on column TB_RPJTE_APR_RULE_M.apr_rule_id
is '결재규칙ID';
comment on column TB_RPJTE_APR_RULE_M.apr_rule_nm
is '결재규칙명';
comment on column TB_RPJTE_APR_RULE_M.apr_ln_add_pmit_yn
is '결재라인추가허용여부';
comment on column TB_RPJTE_APR_RULE_M.apr_rfer_add_psbl_yn
is '결재참조자추가가능여부';
comment on column TB_RPJTE_APR_RULE_M.apr_ln_rstb_pmit_yn
is '결재라인재설정허용여부';
comment on column TB_RPJTE_APR_RULE_M.apr_ln_dupl_pmit_yn
is '결재라인중복허용여부';
comment on column TB_RPJTE_APR_RULE_M.apr_exc_tgt_id
is '결재제외ID';
comment on column TB_RPJTE_APR_RULE_M.mst_ntdk_id
is '기본통보처ID';
comment on column TB_RPJTE_APR_RULE_M.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_APR_RULE_M.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_APR_RULE_M.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_APR_RULE_M.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_APR_RULE_M.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_APR_RULE_M.data_upd_dtm
is '데이터수정일시';
alter table TB_RPJTE_APR_RULE_M
add constraint TB_RPJTE_APR_RULE_M_PK primary key (APR_RULE_ID);



create table TB_RPJTE_APR_RULE_D
(
apr_rule_id        VARCHAR(50) not null,
apr_ln_id          VARCHAR(30) not null,
apr_tp_divs_cd     VARCHAR(20),
prl_yn             VARCHAR(1),
apr_ln_snb         NUMERIC(18,5),
apr_ln_seq         NUMERIC(18),
apr_ln_role_cd     VARCHAR(10),
dept_cd            VARCHAR(20),
user_id            VARCHAR(50),
apr_ln_chg_psbl_yn VARCHAR(1),
apr_ln_del_psbl_yn VARCHAR(1),
data_ins_user_id   VARCHAR(50),
data_ins_user_ip   VARCHAR(40),
data_ins_dtm       timestamp default current_timestamp,
data_upd_user_id   VARCHAR(50),
data_upd_user_ip   VARCHAR(40),
data_upd_dtm       timestamp default current_timestamp
)
;
comment on table TB_RPJTE_APR_RULE_D
is '결재규칙상세';
comment on column TB_RPJTE_APR_RULE_D.apr_rule_id
is '결재규칙ID';
comment on column TB_RPJTE_APR_RULE_D.apr_ln_id
is '결재라인ID';
comment on column TB_RPJTE_APR_RULE_D.apr_tp_divs_cd
is '결재유형구분코드';
comment on column TB_RPJTE_APR_RULE_D.prl_yn
is '병렬여부';
comment on column TB_RPJTE_APR_RULE_D.apr_ln_snb
is '결재라인차수';
comment on column TB_RPJTE_APR_RULE_D.apr_ln_seq
is '결재라인순번';
comment on column TB_RPJTE_APR_RULE_D.apr_ln_role_cd
is '결재라인역할코드';
comment on column TB_RPJTE_APR_RULE_D.dept_cd
is '부서코드';
comment on column TB_RPJTE_APR_RULE_D.user_id
is '사용자ID';
comment on column TB_RPJTE_APR_RULE_D.apr_ln_chg_psbl_yn
is '결재라인변경가능여부';
comment on column TB_RPJTE_APR_RULE_D.apr_ln_del_psbl_yn
is '결재라인삭제가능여부';
comment on column TB_RPJTE_APR_RULE_D.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_APR_RULE_D.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_APR_RULE_D.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_APR_RULE_D.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_APR_RULE_D.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_APR_RULE_D.data_upd_dtm
is '데이터수정일시';
alter table TB_RPJTE_APR_RULE_D
add constraint TB_RPJTE_APR_RULE_D_PK primary key (APR_RULE_ID, APR_LN_ID);



create table TB_RPJTE_APR_RULE_EXC_M
(
apr_exc_tgt_id   VARCHAR(50) not null,
apr_exc_nm       VARCHAR(20),
data_ins_user_id VARCHAR(50),
data_ins_user_ip VARCHAR(40),
data_ins_dtm     timestamp default current_timestamp,
data_upd_user_id VARCHAR(50),
data_upd_user_ip VARCHAR(40),
data_upd_dtm     timestamp default current_timestamp
);
comment on table TB_RPJTE_APR_RULE_EXC_M
is '결재규칙제외기본';
comment on column TB_RPJTE_APR_RULE_EXC_M.apr_exc_tgt_id
is '결재제외대상ID';
comment on column TB_RPJTE_APR_RULE_EXC_M.apr_exc_nm
is '결재제외명';
comment on column TB_RPJTE_APR_RULE_EXC_M.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_APR_RULE_EXC_M.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_APR_RULE_EXC_M.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_APR_RULE_EXC_M.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_APR_RULE_EXC_M.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_APR_RULE_EXC_M.data_upd_dtm
is '데이터수정일시';
alter table TB_RPJTE_APR_RULE_EXC_M
add constraint TB_RPJTE_APR_RULE_EXC_M_PK primary key (APR_EXC_TGT_ID);

create table TB_RPJTE_APR_RULE_EXC_D
(
apr_exc_tgt_id   VARCHAR(50) not null,
apr_exc_seq      NUMERIC(18) not null,
apr_exc_divs_cd  VARCHAR(20) not null,
apr_exc_user_id  VARCHAR(50),
apr_exc_jti_cd   VARCHAR(10),
apr_exc_jps_cd   VARCHAR(10),
data_ins_user_id VARCHAR(50),
data_ins_user_ip VARCHAR(40),
data_ins_dtm     timestamp default current_timestamp,
data_upd_user_id VARCHAR(50),
data_upd_user_ip VARCHAR(40),
data_upd_dtm     timestamp default current_timestamp
);
comment on table TB_RPJTE_APR_RULE_EXC_D
is '결재규칙제외상세';
comment on column TB_RPJTE_APR_RULE_EXC_D.apr_exc_tgt_id
is '결재제외대상ID';
comment on column TB_RPJTE_APR_RULE_EXC_D.apr_exc_seq
is '결재제외순번';
comment on column TB_RPJTE_APR_RULE_EXC_D.apr_exc_divs_cd
is '결재제외구분코드(직급, 직책, 사용자)';
comment on column TB_RPJTE_APR_RULE_EXC_D.apr_exc_user_id
is '결재제외사용자ID';
comment on column TB_RPJTE_APR_RULE_EXC_D.apr_exc_jti_cd
is '결재제외직위코드';
comment on column TB_RPJTE_APR_RULE_EXC_D.apr_exc_jps_cd
is '결재제외직책코드';
comment on column TB_RPJTE_APR_RULE_EXC_D.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_APR_RULE_EXC_D.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_APR_RULE_EXC_D.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_APR_RULE_EXC_D.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_APR_RULE_EXC_D.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_APR_RULE_EXC_D.data_upd_dtm
is '데이터수정일시';
alter table TB_RPJTE_APR_RULE_EXC_D
add constraint TB_RPJTE_APR_RULE_EXC_D_PK primary key (APR_EXC_TGT_ID, APR_EXC_SEQ);


create table TB_RPJTE_APR_REQ_M
(
apr_req_id           VARCHAR(50) not null,
apr_tpl_id           VARCHAR(50),
eapr_doc_no          VARCHAR(50),
apr_req_user_id      VARCHAR(50),
apr_pvn_ddln_cd      VARCHAR(50),
dept_cd              VARCHAR(20),
dept_nm              VARCHAR(300),
ondu_regn_cd         VARCHAR(50),
ondu_regn_nm         VARCHAR(50),
apr_req_tit_nm       VARCHAR(200),
trnm_bdy_ctn         TEXT,
apr_req_desc         VARCHAR(4000),
apr_req_dtm          timestamp,
wcst_cnc_yn          VARCHAR(1),
apr_req_prog_stat_cd VARCHAR(50),
wkt_scrn_url         VARCHAR(500),
apr_wait_scrn_url    VARCHAR(500),
mbil_wkt_scrn_url    VARCHAR(500),
apr_file_gr_id       VARCHAR(50),
ref_apr_req_id       VARCHAR(50),
opt_val_ctn1         VARCHAR(4000),
opt_val_ctn2         VARCHAR(4000),
opt_val_ctn3         VARCHAR(4000),
opt_val_ctn4         VARCHAR(4000),
opt_val_ctn5         VARCHAR(4000),
data_ins_user_id     VARCHAR(50),
data_ins_user_ip     VARCHAR(40),
data_ins_dtm         timestamp default current_timestamp,
data_upd_user_id     VARCHAR(50),
data_upd_user_ip     VARCHAR(40),
data_upd_dtm         timestamp default current_timestamp
);

comment on table TB_RPJTE_APR_REQ_M
is '결재 요청 기본';

comment on column TB_RPJTE_APR_REQ_M.apr_req_id
is '결재요청ID';
comment on column TB_RPJTE_APR_REQ_M.apr_tpl_id
is '결재양식ID';
comment on column TB_RPJTE_APR_REQ_M.eapr_doc_no
is '전자결재문서번호';
comment on column TB_RPJTE_APR_REQ_M.apr_req_user_id
is '결재요청사용자ID';
comment on column TB_RPJTE_APR_REQ_M.apr_pvn_ddln_cd
is '결재보존기한코드';
comment on column TB_RPJTE_APR_REQ_M.dept_cd
is '부서코드';
comment on column TB_RPJTE_APR_REQ_M.dept_nm
is '부서명';
comment on column TB_RPJTE_APR_REQ_M.ondu_regn_cd
is '근무지역코드';
comment on column TB_RPJTE_APR_REQ_M.ondu_regn_nm
is '근무지역명';
comment on column TB_RPJTE_APR_REQ_M.apr_req_tit_nm
is '결재요청제목명';
comment on column TB_RPJTE_APR_REQ_M.trnm_bdy_ctn
is '전송본문내용';
comment on column TB_RPJTE_APR_REQ_M.apr_req_desc
is '결재요청설명';
comment on column TB_RPJTE_APR_REQ_M.apr_req_dtm
is '결재요청일시';
comment on column TB_RPJTE_APR_REQ_M.wcst_cnc_yn
is '동의서동의여부';
comment on column TB_RPJTE_APR_REQ_M.apr_req_prog_stat_cd
is '결재요청진행상태코드';
comment on column TB_RPJTE_APR_REQ_M.wkt_scrn_url
is '업무화면URL주소';
comment on column TB_RPJTE_APR_REQ_M.apr_wait_scrn_url
is '결재대기화면URL주소';
comment on column TB_RPJTE_APR_REQ_M.mbil_wkt_scrn_url
is '모바일업무화면URL주소';
comment on column TB_RPJTE_APR_REQ_M.apr_file_gr_id
is '결재파일그룹ID';
comment on column TB_RPJTE_APR_REQ_M.ref_apr_req_id
is '참조결재요청ID';
comment on column TB_RPJTE_APR_REQ_M.opt_val_ctn1
is '옵션값내용1(사용:추가결재파일그룹ID)';
comment on column TB_RPJTE_APR_REQ_M.opt_val_ctn2
is '옵션값내용2';
comment on column TB_RPJTE_APR_REQ_M.opt_val_ctn3
is '옵션값내용3';
comment on column TB_RPJTE_APR_REQ_M.opt_val_ctn4
is '옵션값내용4';
comment on column TB_RPJTE_APR_REQ_M.opt_val_ctn5
is '옵션값내용5';
comment on column TB_RPJTE_APR_REQ_M.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_APR_REQ_M.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_APR_REQ_M.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_APR_REQ_M.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_APR_REQ_M.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_APR_REQ_M.data_upd_dtm
is '데이터수정일시';

alter table TB_RPJTE_APR_REQ_M
add constraint TB_RPJTE_APR_REQ_M_PK primary key (APR_REQ_ID);



create table TB_RPJTE_APR_LN_M
(
apr_req_id             VARCHAR(50) not null,
apr_ln_seq             NUMERIC(18) not null,
apr_ln_snb             NUMERIC(18,5),
grnr_apr_tp_divs_cd    VARCHAR(1),
apr_ffil_tp_cd         VARCHAR(50),
prl_yn                 VARCHAR(1),
apr_aprv_user_id       VARCHAR(50),
apr_psg_stat_cd        VARCHAR(30),
apr_aprv_dtm           timestamp,
apr_aprv_opin_utf8_ctn VARCHAR(1000),
apr_dlgt_user_id       VARCHAR(50),
apr_dlgt_no            NUMERIC(20),
apr_ln_divs_cd         VARCHAR(20),
eml_sndo_seq           NUMERIC(18),
data_ins_user_id       VARCHAR(50),
data_ins_user_ip       VARCHAR(40),
data_ins_dtm           timestamp default current_timestamp,
data_upd_user_id       VARCHAR(50),
data_upd_user_ip       VARCHAR(40),
data_upd_dtm           timestamp default current_timestamp
)
;
comment on table TB_RPJTE_APR_LN_M
is '결재라인기본';
comment on column TB_RPJTE_APR_LN_M.apr_req_id
is '결재요청ID';
comment on column TB_RPJTE_APR_LN_M.apr_ln_seq
is '결재라인순번';
comment on column TB_RPJTE_APR_LN_M.apr_ln_snb
is '결재라인차수';
comment on column TB_RPJTE_APR_LN_M.grnr_apr_tp_divs_cd
is '승인자결재유형구분코드';
comment on column TB_RPJTE_APR_LN_M.apr_ffil_tp_cd
is '결재수행유형코드';
comment on column TB_RPJTE_APR_LN_M.prl_yn
is '병렬여부';
comment on column TB_RPJTE_APR_LN_M.apr_aprv_user_id
is '결재승인사용자ID';
comment on column TB_RPJTE_APR_LN_M.apr_psg_stat_cd
is '결재처리상태코드';
comment on column TB_RPJTE_APR_LN_M.apr_aprv_dtm
is '결재승인일시';
comment on column TB_RPJTE_APR_LN_M.apr_aprv_opin_utf8_ctn
is '결재승인의견UTF8내용';
comment on column TB_RPJTE_APR_LN_M.apr_dlgt_user_id
is '결재위임사용자ID';
comment on column TB_RPJTE_APR_LN_M.apr_dlgt_no
is '결재위임번호';
comment on column TB_RPJTE_APR_LN_M.apr_ln_divs_cd
is '결재라인구분코드';
comment on column TB_RPJTE_APR_LN_M.eml_sndo_seq
is '이메일발송순번';
comment on column TB_RPJTE_APR_LN_M.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_APR_LN_M.data_ins_user_ip
is '데���터입력사용자IP주소';
comment on column TB_RPJTE_APR_LN_M.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_APR_LN_M.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_APR_LN_M.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_APR_LN_M.data_upd_dtm
is '데이터수정일시';
alter table TB_RPJTE_APR_LN_M
add constraint TB_RPJTE_APR_LN_M_PK primary key (APR_REQ_ID, APR_LN_SEQ);

CREATE TABLE TB_RPJTE_ATCH_FILE_M (
ATCH_FILE_GR_ID VARCHAR(50) NOT NULL,
ATCH_FILE_ID VARCHAR(50) NOT NULL,
ATCH_FILE_NM VARCHAR(500) NULL,
SORT_ORD NUMERIC(10,0) NULL,
ATCH_FILE_SAVE_LOC_DIVS_CD VARCHAR(20) NULL,
ATCH_FILE_SAVE_NM VARCHAR(500) NULL,
ATCH_FILE_SIZE NUMERIC NULL,
ATCH_FILE_EFNM_NM VARCHAR(100) NULL,
ATCH_FILE_SAVE_PATH_CTN VARCHAR(4000) NULL,
ATCH_FILE_TP_CD VARCHAR(20) NULL,
OPT_VAL_CTN1 VARCHAR(4000) NULL,
OPT_VAL_CTN2 VARCHAR(4000) NULL,
OPT_VAL_CTN3 VARCHAR(4000) NULL,
OPT_VAL_CTN4 VARCHAR(4000) NULL,
OPT_VAL_CTN5 VARCHAR(4000) NULL,
USE_YN VARCHAR(1) NULL,
DATA_INS_USER_ID VARCHAR(50) NULL,
DATA_INS_USER_IP VARCHAR(40) NULL,
DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
DATA_UPD_USER_ID VARCHAR(50) NULL,
DATA_UPD_USER_IP VARCHAR(40) NULL,
DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
CONSTRAINT TB_RPJTE_ATCH_FILE_M_PK PRIMARY KEY (ATCH_FILE_GR_ID,ATCH_FILE_ID)
);


COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.ATCH_FILE_GR_ID IS '첨부파일그룹ID';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.ATCH_FILE_ID IS '첨부파일ID';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.ATCH_FILE_NM IS '첨부파일명';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.SORT_ORD IS '정렬순서';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.ATCH_FILE_SAVE_LOC_DIVS_CD IS '첨부파일저장위치구분코드';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.ATCH_FILE_SAVE_NM IS '첨부파일저장명';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.ATCH_FILE_SIZE IS '첨부파일크기';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.ATCH_FILE_EFNM_NM IS '첨부파일확장자명';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.ATCH_FILE_SAVE_PATH_CTN IS '첨부파일저장경로내용';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.ATCH_FILE_TP_CD IS '첨부파일유형코드';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.OPT_VAL_CTN1 IS '옵션값내용1';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.OPT_VAL_CTN2 IS '옵션값내용2';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.OPT_VAL_CTN3 IS '옵션값내용3';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.OPT_VAL_CTN4 IS '옵션값내용4';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.OPT_VAL_CTN5 IS '옵션값내용5';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.USE_YN IS '사용여부';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_ATCH_FILE_M.DATA_UPD_DTM IS '데이터수정일시';


CREATE TABLE TB_RPJTE_HR_DEPT_I (
CODE_NAME_CN VARCHAR(200) NULL,
CODE_NAME_EN VARCHAR(200) NULL,
CODE_NAME_KO VARCHAR(200) NULL,
CODE_NUMB VARCHAR(10) NULL,
CODE_UPER VARCHAR(10) NULL,
CREATEDATE VARCHAR(10) NULL,
DIVISION VARCHAR(8) NULL,
UPDATEDATE VARCHAR(10) NULL,
VALID_FLAG VARCHAR(5) NULL,
CHIEF_NUMB VARCHAR(16) NULL,
IF_CREATION_DATE timestamp NULL,
TRANSFER_FLAG VARCHAR(1) NULL,
TRANSFER_DATE timestamp NULL,
IF_ID NUMERIC NULL
);


COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.CODE_NAME_CN IS '부서명_중국어';
COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.CODE_NAME_EN IS '부서명_영어';
COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.CODE_NAME_KO IS '부서명_한글';
COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.CODE_NUMB IS '부서코드';
COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.CODE_UPER IS '상위부서코드';
COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.CREATEDATE IS '생성일';
COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.DIVISION IS '구분(C100외는 중국)';
COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.UPDATEDATE IS '수정일';
COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.VALID_FLAG IS '사용유무';
COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.CHIEF_NUMB IS '팀 리더사번';
COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.IF_CREATION_DATE IS '인터페이스 수신일시';
COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.TRANSFER_FLAG IS '마스터 반영 여부';
COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.TRANSFER_DATE IS '마스터 반영 일시';
COMMENT ON COLUMN TB_RPJTE_HR_DEPT_I.IF_ID IS '인터페이스 순번';


CREATE TABLE TB_RPJTE_HR_EMP_I (
SA_COMP VARCHAR(8) NULL,
SA_DEPT VARCHAR(8) NULL,
SA_DEPT_NAME VARCHAR(100) NULL,
SA_DEPT_NAME_C VARCHAR(200) NULL,
SA_DEPT_NAME_E VARCHAR(200) NULL,
SA_DEPT_NEW VARCHAR(8) NULL,
SA_EDEPT_NAME VARCHAR(150) NULL,
SA_FUNC VARCHAR(4) NULL,
SA_FUNC_NAME VARCHAR(80) NULL,
SA_FUNC_NAME_C VARCHAR(80) NULL,
SA_FUNC_NAME_E VARCHAR(80) NULL,
SA_HAND VARCHAR(30) NULL,
SA_HNAME VARCHAR(30) NULL,
SA_JOBX VARCHAR(5) NULL,
SA_JOBX_NAME VARCHAR(80) NULL,
SA_JOBX_NAME_C VARCHAR(80) NULL,
SA_JOBX_NAME_E VARCHAR(80) NULL,
SA_NAME VARCHAR(30) NULL,
SA_NAME_E VARCHAR(30) NULL,
SA_PHON_AREA VARCHAR(20) NULL,
SA_PHON_D VARCHAR(50) NULL,
SA_PHON_H VARCHAR(50) NULL,
SA_PHON_HAREA VARCHAR(20) NULL,
SA_PHON_O VARCHAR(50) NULL,
SA_RECT VARCHAR(8) NULL,
SA_SABUN VARCHAR(16) NULL,
SA_SABUN_LEADER VARCHAR(16) NULL,
SA_SABUN_NEW VARCHAR(16) NULL,
SA_SYSTEM VARCHAR(4) NULL,
SA_TEMP VARCHAR(2) NULL,
SA_TEMP_DATE VARCHAR(8) NULL,
SA_USER VARCHAR(20) NULL,
SSO_EX_FLAG VARCHAR(2) NULL,
SSO_MAILSERVER VARCHAR(50) NULL,
SSO_PS_DATE VARCHAR(8) NULL,
SA_GNMU VARCHAR(8) NULL,
SA_GNMU_NAME VARCHAR(80) NULL,
SSO_LOCATE VARCHAR(75) NULL,
SA_PAYXGB CHAR(1) NULL,
SA_SNBNGB CHAR(2) NULL,
SA_SNBNGR CHAR(1) NULL,
SA_MAIL VARCHAR(100) NULL,
SSO_SU_GNMU VARCHAR(4) NULL,
SSO_CNAME VARCHAR(50) NULL,
SA_NATIONALITY VARCHAR(10) NULL,
IF_CREATION_DATE timestamp NULL,
TRANSFER_FLAG VARCHAR(1) NULL,
TRANSFER_DATE timestamp NULL,
IF_ID NUMERIC(22,0) NULL
);

COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_COMP IS '법인 코드';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_DEPT IS '부서코드(옛날부서)';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_DEPT_NAME IS '부서명';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_DEPT_NAME_C IS '부서 중문명';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_DEPT_NAME_E IS '부서 영문명';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_DEPT_NEW IS '부서코드(현재부서코드)';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_EDEPT_NAME IS '영문 부서명';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_FUNC IS '직책';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_FUNC_NAME IS '직책명';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_FUNC_NAME_C IS '직책 중문명';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_FUNC_NAME_E IS '직책영문명';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_HAND IS '핸드폰 번호(보안으로 데이터값 없음)';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_HNAME IS '이름 중문명';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_JOBX IS '직위코드';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_JOBX_NAME IS '직위명';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_JOBX_NAME_C IS '직위중문명';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_JOBX_NAME_E IS '직위영문명';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_NAME IS '이름';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_NAME_E IS '영문이름';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_PHON_AREA IS '지역 번호(집 전화)';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_PHON_D IS '전화번호2(내선번호)';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_PHON_H IS '전화번호3(집전화번호)';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_PHON_HAREA IS '지역 번호(사무실 전화)';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_PHON_O IS '전화번호1(사무실전화번호)';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_RECT IS '입사날자';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_SABUN IS '사번(옛날 사번)';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_SABUN_LEADER IS '상급자 사번';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_SABUN_NEW IS '사번(현재 사번)';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_SYSTEM IS '문서중앙화 권한';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_TEMP IS '입사현황';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_TEMP_DATE IS '퇴직날자';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_USER IS 'ID';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SSO_EX_FLAG IS '정보 변경 코드(C생성, U:변경, D:삭제)';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SSO_MAILSERVER IS '메일 서버';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SSO_PS_DATE IS '변경날짜';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_GNMU IS '인사정보상 근무지코드';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_GNMU_NAME IS '인사정보상 근무지';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SSO_LOCATE IS 'MYINFO상 근무지';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_PAYXGB IS '생산직,사무직구분(사무직:E, 생산/기술직:H)';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_SNBNGB IS '사원하위그룹';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_SNBNGR IS '사원상위그룹';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_MAIL IS 'EMAIL 도메인';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SSO_SU_GNMU IS 'SSO 근무지코드';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SSO_CNAME IS 'SSO 이름 중문명';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.SA_NATIONALITY IS '국가구분';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.IF_CREATION_DATE IS '인터페이스 수신일시';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.TRANSFER_FLAG IS '마스터 반영 여부';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.TRANSFER_DATE IS '마스터 반영 일시';
COMMENT ON COLUMN TB_RPJTE_HR_EMP_I.IF_ID IS '인터페이스 순번';

CREATE TABLE TB_RPJTE_ROLE_M (
ROLE_CD VARCHAR(20) NOT NULL,
ROLE_NM VARCHAR(400) NULL,
ROLE_DESC VARCHAR(4000) NULL,
USE_YN VARCHAR(1) NULL,
DATA_INS_USER_ID VARCHAR(50) NULL,
DATA_INS_USER_IP VARCHAR(40) NULL,
DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
DATA_UPD_USER_ID VARCHAR(50) NULL,
DATA_UPD_USER_IP VARCHAR(40) NULL,
DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
CONSTRAINT TB_RPJTE_ROLE_M_PK PRIMARY KEY (ROLE_CD)
);


COMMENT ON COLUMN TB_RPJTE_ROLE_M.ROLE_CD IS '역할코드';
COMMENT ON COLUMN TB_RPJTE_ROLE_M.ROLE_NM IS '역할명';
COMMENT ON COLUMN TB_RPJTE_ROLE_M.ROLE_DESC IS '역할설명';
COMMENT ON COLUMN TB_RPJTE_ROLE_M.USE_YN IS '사용여부';
COMMENT ON COLUMN TB_RPJTE_ROLE_M.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_M.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_ROLE_M.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_ROLE_M.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_M.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_ROLE_M.DATA_UPD_DTM IS '데이터수정일시';


CREATE TABLE TB_RPJTE_ROLE_MENU_M (
ROLE_CD VARCHAR(20) NOT NULL,
MNU_ID VARCHAR(50) NOT NULL,
DATA_INS_USER_ID VARCHAR(50) NULL,
DATA_INS_USER_IP VARCHAR(40) NULL,
DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
DATA_UPD_USER_ID VARCHAR(50) NULL,
DATA_UPD_USER_IP VARCHAR(40) NULL,
DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
CONSTRAINT TB_RPJTE_ROLE_MENU_M_PK PRIMARY KEY (ROLE_CD,MNU_ID)
);


COMMENT ON COLUMN TB_RPJTE_ROLE_MENU_M.ROLE_CD IS '역할코드';
COMMENT ON COLUMN TB_RPJTE_ROLE_MENU_M.MNU_ID IS '메뉴ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_MENU_M.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_MENU_M.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_ROLE_MENU_M.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_ROLE_MENU_M.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_MENU_M.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_ROLE_MENU_M.DATA_UPD_DTM IS '데이터수정일시';


CREATE TABLE TB_RPJTE_ROLE_EMP_M (
ROLE_CD VARCHAR(20) NOT NULL,
USER_ID VARCHAR(50) NOT NULL,
DATA_INS_USER_ID VARCHAR(50) NULL,
DATA_INS_USER_IP VARCHAR(40) NULL,
DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
DATA_UPD_USER_ID VARCHAR(50) NULL,
DATA_UPD_USER_IP VARCHAR(40) NULL,
DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
CONSTRAINT TB_RPJTE_ROLE_EMP_M_PK PRIMARY KEY (ROLE_CD,USER_ID)
);


COMMENT ON COLUMN TB_RPJTE_ROLE_EMP_M.ROLE_CD IS '역할코드';
COMMENT ON COLUMN TB_RPJTE_ROLE_EMP_M.USER_ID IS '사용자ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_EMP_M.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_EMP_M.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_ROLE_EMP_M.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_ROLE_EMP_M.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_EMP_M.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_ROLE_EMP_M.DATA_UPD_DTM IS '데이터수정일시';


CREATE TABLE TB_RPJTE_API_M (
API_ID VARCHAR(50) NOT NULL,
API_NM VARCHAR(100) NULL,
API_URL VARCHAR(500) NULL,
USE_YN VARCHAR(1) NULL,
DATA_INS_USER_ID VARCHAR(50) NULL,
DATA_INS_USER_IP VARCHAR(40) NULL,
DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
DATA_UPD_USER_ID VARCHAR(50) NULL,
DATA_UPD_USER_IP VARCHAR(40) NULL,
DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
HTTP_MTHD_CD VARCHAR(50) NULL,
CONSTRAINT TB_RPJTE_API_M_PK PRIMARY KEY (API_ID)
);

COMMENT ON COLUMN TB_RPJTE_API_M.API_ID IS 'API ID';
COMMENT ON COLUMN TB_RPJTE_API_M.API_NM IS 'API명';
COMMENT ON COLUMN TB_RPJTE_API_M.API_URL IS 'APIURL주소';
COMMENT ON COLUMN TB_RPJTE_API_M.HTTP_MTHD_CD IS 'HTTP방법코드';
COMMENT ON COLUMN TB_RPJTE_API_M.USE_YN IS '사용여부';
COMMENT ON COLUMN TB_RPJTE_API_M.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_API_M.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_API_M.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_API_M.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_API_M.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_API_M.DATA_UPD_DTM IS '데이터수정일시';


CREATE TABLE TB_RPJTE_ROLE_API_M (
ROLE_CD VARCHAR(20) NOT NULL,
API_ID VARCHAR(50) NOT NULL,
DATA_INS_USER_ID VARCHAR(50) NULL,
DATA_INS_USER_IP VARCHAR(40) NULL,
DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
DATA_UPD_USER_ID VARCHAR(50) NULL,
DATA_UPD_USER_IP VARCHAR(40) NULL,
DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
CONSTRAINT TB_RPJTE_ROLE_API_M_PK PRIMARY KEY (ROLE_CD,API_ID)
);

COMMENT ON COLUMN TB_RPJTE_ROLE_API_M.ROLE_CD IS 'API ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_API_M.API_ID IS 'API ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_API_M.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_API_M.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_ROLE_API_M.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_ROLE_API_M.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_API_M.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_ROLE_API_M.DATA_UPD_DTM IS '데이터수정일시';


CREATE TABLE TB_RPJTE_ROLE_DEPT_M (
ROLE_CD VARCHAR(20) NOT NULL,
DEPT_CD VARCHAR(20) NOT NULL,
DATA_INS_USER_ID VARCHAR(50) NULL,
DATA_INS_USER_IP VARCHAR(40) NULL,
DATA_INS_DTM timestamp DEFAULT current_timestamp  NULL,
DATA_UPD_USER_ID VARCHAR(50) NULL,
DATA_UPD_USER_IP VARCHAR(40) NULL,
DATA_UPD_DTM timestamp DEFAULT current_timestamp  NULL,
CONSTRAINT TB_RPJTE_ROLE_DEPT_M_PK PRIMARY KEY (ROLE_CD,DEPT_CD)
);


COMMENT ON COLUMN TB_RPJTE_ROLE_DEPT_M.ROLE_CD IS '역할코드';
COMMENT ON COLUMN TB_RPJTE_ROLE_DEPT_M.DEPT_CD IS '부서코드';
COMMENT ON COLUMN TB_RPJTE_ROLE_DEPT_M.DATA_INS_USER_ID IS '데이터입력사용자ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_DEPT_M.DATA_INS_USER_IP IS '데이터입력사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_ROLE_DEPT_M.DATA_INS_DTM IS '데이터입력일시';
COMMENT ON COLUMN TB_RPJTE_ROLE_DEPT_M.DATA_UPD_USER_ID IS '데이터수정사용자ID';
COMMENT ON COLUMN TB_RPJTE_ROLE_DEPT_M.DATA_UPD_USER_IP IS '데이터수정사용자IP주소';
COMMENT ON COLUMN TB_RPJTE_ROLE_DEPT_M.DATA_UPD_DTM IS '데이터수정일시';



create table TB_RPJTE_BBS_M
(
bbm_no            NUMERIC not null,
bbs_tp_cd         VARCHAR(10),
bbm_sort_ord      NUMERIC,
bbm_tit_nm        VARCHAR(300),
bbm_ctn           TEXT,
smry_ctn          VARCHAR(4000),
atch_file_gr_id   VARCHAR(50),
htag_ctn          VARCHAR(300),
impt_yn           VARCHAR(1),
use_yn            VARCHAR(1),
bbm_vwct          NUMERIC,
ptup_end_dt       VARCHAR(8),
noti_use_yn       VARCHAR(1),
poup_use_yn       VARCHAR(1),
poup_st_dtm       timestamp,
poup_end_dtm      timestamp,
poup_eps_nuse_ddn NUMERIC(7),
bbm_clsf_cd       VARCHAR(50),
ptup_tgt_cop_cd   VARCHAR(10),
data_ins_user_id  VARCHAR(50),
data_ins_user_ip  VARCHAR(40),
data_ins_dtm      timestamp default current_timestamp,
data_upd_user_id  VARCHAR(50),
data_upd_user_ip  VARCHAR(40),
data_upd_dtm      timestamp default current_timestamp
);

comment on table TB_RPJTE_BBS_M
is '게시판기본';
comment on column TB_RPJTE_BBS_M.bbm_no
is '게시글번호';
comment on column TB_RPJTE_BBS_M.bbs_tp_cd
is '게시판유형코드';
comment on column TB_RPJTE_BBS_M.bbm_sort_ord
is '게시글정렬순서';
comment on column TB_RPJTE_BBS_M.bbm_tit_nm
is '게시글제목명';
comment on column TB_RPJTE_BBS_M.bbm_ctn
is '게시글내용';
comment on column TB_RPJTE_BBS_M.smry_ctn
is '요약내용';
comment on column TB_RPJTE_BBS_M.atch_file_gr_id
is '첨부파일그룹ID';
comment on column TB_RPJTE_BBS_M.htag_ctn
is '해시태그내용';
comment on column TB_RPJTE_BBS_M.impt_yn
is '중요여부';
comment on column TB_RPJTE_BBS_M.use_yn
is '사용여부';
comment on column TB_RPJTE_BBS_M.bbm_vwct
is '게시글조회수';
comment on column TB_RPJTE_BBS_M.ptup_end_dt
is '게시종료일자';
comment on column TB_RPJTE_BBS_M.noti_use_yn
is '공지사용여부';
comment on column TB_RPJTE_BBS_M.poup_use_yn
is '팝업사용여부';
comment on column TB_RPJTE_BBS_M.poup_st_dtm
is '팝업시작일시';
comment on column TB_RPJTE_BBS_M.poup_end_dtm
is '팝업종료일시';
comment on column TB_RPJTE_BBS_M.poup_eps_nuse_ddn
is '팝업노출미사용일수';
comment on column TB_RPJTE_BBS_M.bbm_clsf_cd
is '게시글분류코드';
comment on column TB_RPJTE_BBS_M.ptup_tgt_cop_cd
is '게시대상법인코드';
comment on column TB_RPJTE_BBS_M.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_BBS_M.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_BBS_M.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_BBS_M.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_BBS_M.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_BBS_M.data_upd_dtm
is '데이터수정일시';
alter table TB_RPJTE_BBS_M
add constraint TB_RPJTE_BBS_M_PK primary key (BBM_NO);


create table TB_RPJTE_BBS_RE_D
(
bbm_no           NUMERIC not null,
bbm_re_no        NUMERIC not null,
bbm_re_ctn       VARCHAR(1000) not null,
re_del_yn        VARCHAR(1) not null,
data_ins_user_id VARCHAR(50),
data_ins_user_ip VARCHAR(40),
data_ins_dtm     timestamp default current_timestamp,
data_upd_user_id VARCHAR(50),
data_upd_user_ip VARCHAR(40),
data_upd_dtm     timestamp default current_timestamp
)
;
comment on table TB_RPJTE_BBS_RE_D
is '게시판댓글상세';
comment on column TB_RPJTE_BBS_RE_D.bbm_no
is '게시글번호';
comment on column TB_RPJTE_BBS_RE_D.bbm_re_no
is '게시글댓글번호';
comment on column TB_RPJTE_BBS_RE_D.bbm_re_ctn
is '게시글댓글내용';
comment on column TB_RPJTE_BBS_RE_D.re_del_yn
is '댓글삭제여부';
comment on column TB_RPJTE_BBS_RE_D.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_BBS_RE_D.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_BBS_RE_D.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_BBS_RE_D.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_BBS_RE_D.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_BBS_RE_D.data_upd_dtm
is '데이터수정일시';
alter table TB_RPJTE_BBS_RE_D
add constraint TB_RPJTE_BBS_RE_D_PK primary key (BBM_NO, BBM_RE_NO);

create table TB_RPJTE_DT_M
(
cop_cd           VARCHAR(10) not null,
scal_dt          VARCHAR(8) not null,
scal_yy          VARCHAR(4),
scal_mm          VARCHAR(2),
scal_dd          VARCHAR(2),
lcal_dt          VARCHAR(8),
dywk_no_cd       VARCHAR(1),
yywk             VARCHAR(6),
mm_wct           NUMERIC(3),
hldy_yn          VARCHAR(1),
hldy_nm          VARCHAR(30),
opt_val_nm1      VARCHAR(100),
opt_val_nm2      VARCHAR(100),
opt_val_nm3      VARCHAR(100),
opt_val_nm4      VARCHAR(100),
opt_val_nm5      VARCHAR(100),
data_ins_user_id VARCHAR(50),
data_ins_user_ip VARCHAR(40),
data_ins_dtm     timestamp default current_timestamp,
data_upd_user_id VARCHAR(50),
data_upd_user_ip VARCHAR(40),
data_upd_dtm     timestamp default current_timestamp
)
;
comment on table TB_RPJTE_DT_M
is '날짜기본';
comment on column TB_RPJTE_DT_M.cop_cd
is '법인코드';
comment on column TB_RPJTE_DT_M.scal_dt
is '양력일자';
comment on column TB_RPJTE_DT_M.scal_yy
is '양력년도';
comment on column TB_RPJTE_DT_M.scal_mm
is '양력월';
comment on column TB_RPJTE_DT_M.scal_dd
is '양력일';
comment on column TB_RPJTE_DT_M.lcal_dt
is '음력일자';
comment on column TB_RPJTE_DT_M.dywk_no_cd
is '요일번호코드';
comment on column TB_RPJTE_DT_M.yywk
is '년주차수';
comment on column TB_RPJTE_DT_M.mm_wct
is '월주차수';
comment on column TB_RPJTE_DT_M.hldy_yn
is '휴일여부';
comment on column TB_RPJTE_DT_M.hldy_nm
is '휴일명';
comment on column TB_RPJTE_DT_M.opt_val_nm1
is '옵션값명1';
comment on column TB_RPJTE_DT_M.opt_val_nm2
is '옵션값명2';
comment on column TB_RPJTE_DT_M.opt_val_nm3
is '옵션값명3';
comment on column TB_RPJTE_DT_M.opt_val_nm4
is '옵션값명4';
comment on column TB_RPJTE_DT_M.opt_val_nm5
is '옵션값명5';
comment on column TB_RPJTE_DT_M.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_DT_M.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_DT_M.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_DT_M.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_DT_M.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_DT_M.data_upd_dtm
is '데이터수정일시';
alter table TB_RPJTE_DT_M
add constraint TB_RPJTE_DT_M_PK primary key (COP_CD, SCAL_DT);

create table TB_RPJTE_EML_SNDO_LOG_M
(
eml_sndo_seq     NUMERIC(18) not null,
eml_log_seq      NUMERIC(18) not null,
eml_tp_cd        VARCHAR(20),
eml_tit_nm       VARCHAR(100),
eml_rcvr_lst_ctn VARCHAR(4000) not null,
sed_emal         VARCHAR(100) not null,
sed_dtm          timestamp not null,
eml_trnm_stat_cd VARCHAR(20),
eml_trnm_rlt_ctn VARCHAR(200),
eml_bdy_ctn      VARCHAR(4000),
apr_req_id       VARCHAR(50),
opt_val_nm1      VARCHAR(100),
opt_val_nm2      VARCHAR(100),
opt_val_nm3      VARCHAR(100),
opt_val_nm4      VARCHAR(100),
opt_val_nm5      VARCHAR(100),
data_ins_user_id VARCHAR(50),
data_ins_user_ip VARCHAR(40),
data_ins_dtm     timestamp default current_timestamp,
data_upd_user_id VARCHAR(50),
data_upd_user_ip VARCHAR(40),
data_upd_dtm     timestamp default current_timestamp
);
comment on table TB_RPJTE_EML_SNDO_LOG_M
is '메일발송로그기본';
comment on column TB_RPJTE_EML_SNDO_LOG_M.eml_sndo_seq
is '이메일발송순번';
comment on column TB_RPJTE_EML_SNDO_LOG_M.eml_log_seq
is '이메일로그순번';
comment on column TB_RPJTE_EML_SNDO_LOG_M.eml_tp_cd
is '이메일유형코드';
comment on column TB_RPJTE_EML_SNDO_LOG_M.eml_rcvr_lst_ctn
is '이메일수신자목록내용';
comment on column TB_RPJTE_EML_SNDO_LOG_M.sed_emal
is '발신이메일주소';
comment on column TB_RPJTE_EML_SNDO_LOG_M.sed_dtm
is '발신일시';
comment on column TB_RPJTE_EML_SNDO_LOG_M.eml_trnm_stat_cd
is '이메일전송상태코드';
comment on column TB_RPJTE_EML_SNDO_LOG_M.eml_trnm_rlt_ctn
is '이메일전송결과내용';
comment on column TB_RPJTE_EML_SNDO_LOG_M.eml_bdy_ctn
is '이메일본문내용';
comment on column TB_RPJTE_EML_SNDO_LOG_M.apr_req_id
is '결재요청ID';
comment on column TB_RPJTE_EML_SNDO_LOG_M.opt_val_nm1
is '옵션값명1';
comment on column TB_RPJTE_EML_SNDO_LOG_M.opt_val_nm2
is '옵션값명2';
comment on column TB_RPJTE_EML_SNDO_LOG_M.opt_val_nm3
is '옵션값명3';
comment on column TB_RPJTE_EML_SNDO_LOG_M.opt_val_nm4
is '옵션값명4';
comment on column TB_RPJTE_EML_SNDO_LOG_M.opt_val_nm5
is '옵션값명5';
comment on column TB_RPJTE_EML_SNDO_LOG_M.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_EML_SNDO_LOG_M.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_EML_SNDO_LOG_M.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_EML_SNDO_LOG_M.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_EML_SNDO_LOG_M.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_EML_SNDO_LOG_M.data_upd_dtm
is '데이터수정일시';
create index TB_RPJTE_EML_SNDO_LOG_M_IX01 on TB_RPJTE_EML_SNDO_LOG_M (SED_DTM);
alter table TB_RPJTE_EML_SNDO_LOG_M
add constraint TB_RPJTE_EML_SNDO_LOG_M_PK primary key (EML_SNDO_SEQ, EML_LOG_SEQ);

create table TB_RPJTE_LOGN_LOG_M
(
cont_log_id      VARCHAR(50) not null,
cont_dtm         timestamp default current_timestamp not null,
cont_user_id     VARCHAR(50) not null,
cont_ip          VARCHAR(40),
data_ins_user_id VARCHAR(50),
data_ins_user_ip VARCHAR(40),
data_ins_dtm     timestamp default current_timestamp,
data_upd_user_id VARCHAR(50),
data_upd_user_ip VARCHAR(40),
data_upd_dtm     timestamp default current_timestamp
);

comment on column TB_RPJTE_LOGN_LOG_M.cont_log_id
is '접속로그ID';
comment on column TB_RPJTE_LOGN_LOG_M.cont_dtm
is '접속일시';
comment on column TB_RPJTE_LOGN_LOG_M.cont_user_id
is '접속사용자ID';
comment on column TB_RPJTE_LOGN_LOG_M.cont_ip
is '접속IP주소';
comment on column TB_RPJTE_LOGN_LOG_M.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_LOGN_LOG_M.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_LOGN_LOG_M.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_LOGN_LOG_M.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_LOGN_LOG_M.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_LOGN_LOG_M.data_upd_dtm
is '데이터수정일시';

create index TB_RPJTE_LOGN_LOG_M_IX01 on TB_RPJTE_LOGN_LOG_M (CONT_DTM);

alter table TB_RPJTE_LOGN_LOG_M
add constraint TB_RPJTE_LOGN_LOG_M_PK primary key (CONT_LOG_ID);


create table TB_RPJTE_MNU_ACES_LOG_M
(
aces_log_id      VARCHAR(50) not null,
mnu_id           VARCHAR(50) not null,
cont_dtm         timestamp default current_timestamp not null,
cont_user_id     VARCHAR(50),
cont_ip          VARCHAR(40),
data_ins_user_id VARCHAR(50),
data_ins_user_ip VARCHAR(40),
data_ins_dtm     timestamp default current_timestamp,
data_upd_user_id VARCHAR(50),
data_upd_user_ip VARCHAR(40),
data_upd_dtm     timestamp default current_timestamp
);
comment on column TB_RPJTE_MNU_ACES_LOG_M.aces_log_id
is '접근로그ID';
comment on column TB_RPJTE_MNU_ACES_LOG_M.mnu_id
is '메뉴ID';
comment on column TB_RPJTE_MNU_ACES_LOG_M.cont_dtm
is '접속일시';
comment on column TB_RPJTE_MNU_ACES_LOG_M.cont_user_id
is '접속사용자ID';
comment on column TB_RPJTE_MNU_ACES_LOG_M.cont_ip
is '접속IP주소';
comment on column TB_RPJTE_MNU_ACES_LOG_M.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_MNU_ACES_LOG_M.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_MNU_ACES_LOG_M.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_MNU_ACES_LOG_M.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_MNU_ACES_LOG_M.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_MNU_ACES_LOG_M.data_upd_dtm
is '데이터수정일시';
create index TB_RPJTE_MNU_ACES_LOG_M_IX01 on TB_RPJTE_MNU_ACES_LOG_M (CONT_DTM);
create index TB_RPJTE_MNU_ACES_LOG_M_IX02 on TB_RPJTE_MNU_ACES_LOG_M (CONT_USER_ID);
create index TB_RPJTE_MNU_ACES_LOG_M_IX03 on TB_RPJTE_MNU_ACES_LOG_M (CONT_IP);

alter table TB_RPJTE_MNU_ACES_LOG_M
add constraint TB_RPJTE_MNU_ACES_LOG_M_PK primary key (ACES_LOG_ID);


create table TB_RPJTE_IF_LOG_M
(
if_log_seq       NUMERIC(22) not null,
if_log_dtm       timestamp not null,
if_nm            VARCHAR(300),
if_divs_cd       VARCHAR(20),
if_trmt_val_ctn  VARCHAR(4000),
if_rest_val_ctn  VARCHAR(4000),
opt_val_nm1      VARCHAR(100),
opt_val_nm2      VARCHAR(100),
opt_val_nm3      VARCHAR(100),
opt_val_nm4      VARCHAR(100),
opt_val_nm5      VARCHAR(100),
data_ins_user_id VARCHAR(50),
data_ins_user_ip VARCHAR(40),
data_ins_dtm     timestamp default current_timestamp,
data_upd_user_id VARCHAR(50),
data_upd_user_ip VARCHAR(40),
data_upd_dtm     timestamp default current_timestamp
);
comment on table TB_RPJTE_IF_LOG_M
is '인터페이스로그기본';
comment on column TB_RPJTE_IF_LOG_M.if_log_seq
is '인터페이스로그순번';
comment on column TB_RPJTE_IF_LOG_M.if_log_dtm
is '인터페이스로그일시';
comment on column TB_RPJTE_IF_LOG_M.if_nm
is '인터페이스명';
comment on column TB_RPJTE_IF_LOG_M.if_divs_cd
is '인터페이스구분코드';
comment on column TB_RPJTE_IF_LOG_M.if_trmt_val_ctn
is '인터페이스송신값내용';
comment on column TB_RPJTE_IF_LOG_M.if_rest_val_ctn
is '인터페이스수신값내용';
comment on column TB_RPJTE_IF_LOG_M.opt_val_nm1
is '옵션값명1';
comment on column TB_RPJTE_IF_LOG_M.opt_val_nm2
is '옵션값명2';
comment on column TB_RPJTE_IF_LOG_M.opt_val_nm3
is '옵션값명3';
comment on column TB_RPJTE_IF_LOG_M.opt_val_nm4
is '옵션값명4';
comment on column TB_RPJTE_IF_LOG_M.opt_val_nm5
is '옵션값명5';
comment on column TB_RPJTE_IF_LOG_M.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_IF_LOG_M.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_IF_LOG_M.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_IF_LOG_M.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_IF_LOG_M.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_IF_LOG_M.data_upd_dtm
is '데이터수정일시';
create index TB_RPJTE_IF_LOG_M_IX01 on TB_RPJTE_IF_LOG_M (IF_LOG_DTM);
alter table TB_RPJTE_IF_LOG_M
add constraint TB_RPJTE_IF_LOG_M_PK primary key (IF_LOG_SEQ);


create table TB_RPJTE_EML_SNDO_QUE_M
(
eml_sndo_seq     NUMERIC(18) not null,
eml_tp_cd        VARCHAR(20),
eml_tit_nm       VARCHAR(1000) not null,
eml_rcvr_lst_ctn VARCHAR(4000) not null,
sed_emal         VARCHAR(100) not null,
eml_sed_user_nm  VARCHAR(100),
sed_dtm          timestamp,
eml_trnm_stat_cd VARCHAR(20),
eml_trnm_rlt_ctn VARCHAR(200),
eml_dtl_ctn      TEXT,
apr_req_id       VARCHAR(50),
opt_val_nm1      VARCHAR(100),
opt_val_nm2      VARCHAR(100),
opt_val_nm3      VARCHAR(100),
opt_val_nm4      VARCHAR(100),
opt_val_nm5      VARCHAR(100),
data_ins_user_id VARCHAR(50),
data_ins_user_ip VARCHAR(40),
data_ins_dtm     timestamp default current_timestamp,
data_upd_user_id VARCHAR(50),
data_upd_user_ip VARCHAR(40),
data_upd_dtm     timestamp default current_timestamp
);
comment on table TB_RPJTE_EML_SNDO_QUE_M
is '메일발송큐기본';
comment on column TB_RPJTE_EML_SNDO_QUE_M.eml_sndo_seq
is '이메일발송순번';
comment on column TB_RPJTE_EML_SNDO_QUE_M.eml_tp_cd
is '이메일유형코드';
comment on column TB_RPJTE_EML_SNDO_QUE_M.eml_tit_nm
is '이메일제목명';
comment on column TB_RPJTE_EML_SNDO_QUE_M.eml_rcvr_lst_ctn
is '이메일수신자목록내용';
comment on column TB_RPJTE_EML_SNDO_QUE_M.sed_emal
is '발신이메일주소';
comment on column TB_RPJTE_EML_SNDO_QUE_M.eml_sed_user_nm
is '이메일발신사용자명';
comment on column TB_RPJTE_EML_SNDO_QUE_M.sed_dtm
is '발신일시';
comment on column TB_RPJTE_EML_SNDO_QUE_M.eml_trnm_stat_cd
is '이메일전송상태코드';
comment on column TB_RPJTE_EML_SNDO_QUE_M.eml_trnm_rlt_ctn
is '이메일전송결과내용';
comment on column TB_RPJTE_EML_SNDO_QUE_M.eml_dtl_ctn
is '이메일상세내용';
comment on column TB_RPJTE_EML_SNDO_QUE_M.apr_req_id
is '결재요청ID';
comment on column TB_RPJTE_EML_SNDO_QUE_M.opt_val_nm1
is '옵션값명1';
comment on column TB_RPJTE_EML_SNDO_QUE_M.opt_val_nm2
is '옵션값명2';
comment on column TB_RPJTE_EML_SNDO_QUE_M.opt_val_nm3
is '옵션값명3';
comment on column TB_RPJTE_EML_SNDO_QUE_M.opt_val_nm4
is '옵션값명4';
comment on column TB_RPJTE_EML_SNDO_QUE_M.opt_val_nm5
is '옵션값명5';
comment on column TB_RPJTE_EML_SNDO_QUE_M.data_ins_user_id
is '데이터입력사용자ID';
comment on column TB_RPJTE_EML_SNDO_QUE_M.data_ins_user_ip
is '데이터입력사용자IP주소';
comment on column TB_RPJTE_EML_SNDO_QUE_M.data_ins_dtm
is '데이터입력일시';
comment on column TB_RPJTE_EML_SNDO_QUE_M.data_upd_user_id
is '데이터수정사용자ID';
comment on column TB_RPJTE_EML_SNDO_QUE_M.data_upd_user_ip
is '데이터수정사용자IP주소';
comment on column TB_RPJTE_EML_SNDO_QUE_M.data_upd_dtm
is '데이터수정일시';

create index TB_RPJTE_EML_SNDO_QUE_M_IX01 on TB_RPJTE_EML_SNDO_QUE_M (EML_TRNM_RLT_CTN);
alter table TB_RPJTE_EML_SNDO_QUE_M
add constraint TB_RPJTE_EML_SNDO_QUE_M_PK primary key (EML_SNDO_SEQ);

