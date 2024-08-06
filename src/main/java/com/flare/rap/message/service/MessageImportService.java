package com.flare.rap.message.service;

import com.flare.rap.common.model.DmlResponseVO;

public interface MessageImportService {

    /**
     * Front / Back End에서 추출한 메시지코드 데이터를 Message 테이블로 Import 함
     * 추출한 메시지는 임시테이블에 담겨있어야 Import 정상 진행 됨.
     *
     */

    DmlResponseVO importMessage(String allUpdateYn);

}